package com.kwanhee.gymapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboard
import androidx.compose.ui.unit.dp
import com.kwanhee.gym.model.GymStatus
import com.kwanhee.gym.rememberGymStateManager
import com.kwanhee.gymapp.ui.components.AnimatedEmojiReaction
import com.kwanhee.gymapp.ui.components.DateHeader
import com.kwanhee.gymapp.ui.components.GymStatusButton
import com.kwanhee.gymapp.ui.components.ShareButton
import com.kwanhee.gymapp.ui.theme.GymColors
import kotlinx.coroutines.launch

@Composable
fun GymScreen(
    friendId: String? = null,
    onShare: (url: String) -> Unit = {},
) {
    val clipboard = LocalClipboard.current
    val stateManager = rememberGymStateManager()
    val coroutineScope = rememberCoroutineScope()

    val userState by stateManager.userState
    val showEmojiReaction by stateManager.showEmojiReaction
    val reactionEmoji by stateManager.reactionEmoji
    val isLoading by stateManager.isLoading

    Scaffold(
        containerColor = GymColors.Background,
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GymColors.Background)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .fillMaxHeight()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                DateHeader()

                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GymStatus.entries.forEach { status ->
                        GymStatusButton(
                            status = status,
                            isSelected = userState?.status == status,
                            onClick = { stateManager.selectStatus(status) }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))


                if (userState?.status != null) {
                    ShareButton(
                        onShare = {
                            coroutineScope.launch {
                                val shareUrl =
                                    stateManager.createAndGenerateShareUrl("https://jokwanhee.github.io")
                                onShare(shareUrl.orEmpty())
                                println("공유 링크: $shareUrl")
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }

            AnimatedVisibility(
                visible = showEmojiReaction,
                enter = scaleIn(
                    animationSpec = spring(
                        dampingRatio = 0.5f,
                        stiffness = 200f
                    )
                ) + fadeIn(),
                exit = scaleOut(
                    animationSpec = spring(
                        dampingRatio = 0.7f,
                        stiffness = 300f
                    )
                ) + fadeOut(),
                modifier = Modifier.align(Alignment.Center)
            ) {
                AnimatedEmojiReaction(
                    emoji = reactionEmoji,
                    isVisible = showEmojiReaction
                )
            }
        }
    }
}