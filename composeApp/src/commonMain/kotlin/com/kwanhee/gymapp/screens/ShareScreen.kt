package com.kwanhee.gymapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kwanhee.gymapp.data.FriendState
import com.kwanhee.gymapp.data.GymStatus
import com.kwanhee.gymapp.data.PageEntry
import com.kwanhee.gymapp.data.SupabaseClient
import com.kwanhee.gymapp.ui.components.FriendStatusCard
import com.kwanhee.gymapp.ui.components.LoadingFriendCard
import com.kwanhee.gymapp.ui.theme.GymColors
import com.kwanhee.gymapp.ui.theme.GymTheme
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.datetime.Instant
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ShareScreen(token: String) {
    var friendState by remember { mutableStateOf<FriendState?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(token) {
        isLoading = true
        error = null
        try {
            val result = SupabaseClient.client.postgrest["pages"]
                .select(columns = Columns.list("state", "date", "share_token")) {
                    filter {
                        eq("share_token", token)
                    }
                }.decodeSingleOrNull<PageEntry>()

            if (result != null) {
                val gymStatus = when (result.state) {
                    1 -> GymStatus.GO
                    2 -> GymStatus.NO
                    3 -> GymStatus.THINKING
                    else -> null
                }

                if (gymStatus != null && result.date != null) {
                    val instant = Instant.parse(result.date + "T00:00:00Z")
                    friendState = FriendState(
                        friendId = token,
                        name = "친구", // Name is not in the pages table, so using a placeholder
                        status = gymStatus,
                        lastUpdated = instant.epochSeconds
                    )
                } else {
                    error = "유효하지 않은 공유 정보입니다."
                }
            } else {
                error = "공유 정보를 찾을 수 없습니다."
            }
        } catch (e: Exception) {
            error = "데이터를 불러오는 중 오류가 발생했습니다: ${e.message}"
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GymColors.Background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 600.dp)
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when {
                isLoading -> {
                    LoadingFriendCard()
                }

                error != null -> {
                    Text("오류: $error")
                }

                friendState != null -> {
                    FriendStatusCard(friendState = friendState)
                }

                else -> {
                    Text("공유된 정보가 없습니다.")
                }
            }
        }
    }
}

@Preview
@Composable
fun ShareScreenPreview() {
    // Replace with a valid or mock token for preview purposes
    GymTheme {
        ShareScreen(token = "sample_token")
    }
}
