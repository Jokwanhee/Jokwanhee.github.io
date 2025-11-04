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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kwanhee.gym.model.FriendState
import com.kwanhee.gymapp.ui.components.FriendStatusCard
import com.kwanhee.gymapp.ui.components.LoadingFriendCard
import com.kwanhee.gymapp.ui.theme.GymColors
import com.kwanhee.gymapp.ui.theme.GymTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ShareScreen(token: String) {
    var friendState by remember { mutableStateOf<FriendState?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

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
