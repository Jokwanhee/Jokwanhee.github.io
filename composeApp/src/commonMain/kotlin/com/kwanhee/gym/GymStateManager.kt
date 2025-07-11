package com.kwanhee.gym

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.kwanhee.gym.model.FriendState
import com.kwanhee.gym.model.GymStatus
import com.kwanhee.gym.model.PageEntry
import com.kwanhee.gym.model.UserGymState
import com.kwanhee.gymapp.utils.UrlUtils
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.uuid.ExperimentalUuidApi

@Composable
fun rememberGymStateManager(
    friendId: String? = null
): GymStateManager {
    val scope = rememberCoroutineScope()
    return remember(friendId) {
        GymStateManager(friendId, scope)
    }
}

class GymStateManager(
    private val friendId: String? = null,
    private val coroutineScope: CoroutineScope
) {
    private var _userState = mutableStateOf<UserGymState?>(null)
    val userState: State<UserGymState?> = _userState

    private var _friendState = mutableStateOf<FriendState?>(null)
    val friendState: State<FriendState?> = _friendState

    private var _showEmojiReaction = mutableStateOf(false)
    val showEmojiReaction: State<Boolean> = _showEmojiReaction

    private var _reactionEmoji = mutableStateOf("")
    val reactionEmoji: State<String> = _reactionEmoji

    private var _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    init {
        loadUserState()
        friendId?.let { loadFriendStateFromSupabase(it) }
    }

    fun selectStatus(status: GymStatus) {
        val userName = _userState.value?.name ?: "나"

        _userState.value = UserGymState(
            name = userName,
            status = status,
            lastUpdated = Clock.System.now().epochSeconds
        )

        showReactionAnimation(status)
    }

    private fun showReactionAnimation(status: GymStatus) {
        _reactionEmoji.value = when (status) {
            GymStatus.GO -> "🏋️‍♂️💪🎉"
            GymStatus.NO -> "😴🛋️💤"
            GymStatus.THINKING -> "🤔💭❓"
        }

        _showEmojiReaction.value = true

        coroutineScope.launch {
            delay(3000)
            _showEmojiReaction.value = false
        }
    }

    private fun loadUserState() {
        // This would be loaded from local storage
        _userState.value = null
    }


    private fun loadFriendStateFromSupabase(shareId: String) {
        _isLoading.value = true
        coroutineScope.launch {
            try {
                val result = withContext(Dispatchers.Default) {
                    SupabaseClient.client.postgrest["pages"]
                        .select(columns = Columns.list("state", "date", "share_token")) {
                            filter { eq("share_token", shareId) }
                        }.decodeSingleOrNull<PageEntry>()
                }

                if (result != null) {
                    val gymStatus = when (result.state) {
                        1 -> GymStatus.GO
                        2 -> GymStatus.NO
                        3 -> GymStatus.THINKING
                        else -> null
                    }

                    if (gymStatus != null && result.date != null) {
                        val instant = Instant.parse(result.date + "T00:00:00Z")
                        _friendState.value = FriendState(
                            friendId = shareId,
                            name = "친구",
                            status = gymStatus,
                            lastUpdated = instant.epochSeconds
                        )
                    } else {
                        _friendState.value = null
                    }
                } else {
                    _friendState.value = null
                }
            } catch (e: Exception) {
                println("Error loading friend state: ${e.message}")
                _friendState.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }

    @OptIn(ExperimentalUuidApi::class)
    suspend fun createAndGenerateShareUrl(baseUrl: String): String? {
        val currentStatus = _userState.value?.status ?: return null

        val shareToken = kotlin.uuid.Uuid.random().toString()
        val stateValue = when (currentStatus) {
            GymStatus.GO -> 1
            GymStatus.NO -> 2
            GymStatus.THINKING -> 3
        }

        return try {
            withContext(Dispatchers.Default) {
                SupabaseClient.client.postgrest["pages"].insert(
                    PageEntry(
                        state = stateValue,
                        shareToken = shareToken,
                        date = Clock.System.now().toLocalDateTime(TimeZone.UTC).date.toString()
                    )
                )
                UrlUtils.generateShareUrl(baseUrl, shareToken)
            }
        } catch (e: Exception) {
            println("Error creating share link: ${e.message}")
            null
        }
    }
}
