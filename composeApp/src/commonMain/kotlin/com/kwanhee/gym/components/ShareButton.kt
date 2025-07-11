package com.kwanhee.gymapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kwanhee.gymapp.ui.theme.GymColors
import com.kwanhee.gymapp.ui.theme.GymTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ShareButton(
    onShare: (String?) -> Unit,
    modifier: Modifier = Modifier
) {
    var showCopiedMessage by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                onShare(null) // Initially call without URL
                showCopiedMessage = true

                // 2초 후 메시지 숨기기

                scope.launch {
                    delay(2000)
                    showCopiedMessage = false
                }
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "🔗",
                    style = GymTheme.typography.emojiHeadlineSmall,
                    modifier = Modifier.padding(end = 12.dp)
                )
                Text(
                    text = "친구에게 링크 공유하기",
                    style = GymTheme.typography.titleMediumB,
                    color = GymColors.GoGreen
                )
            }

            Text(
                text = "친구가 오늘 헬스장 갈지 확인해보세요!",
                style = GymTheme.typography.labelSmallM,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )

            AnimatedVisibility(
                visible = showCopiedMessage,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Text(
                    text = "📋 링크가 복사되었어요!",
                    style = GymTheme.typography.labelSmallM,
                    color = GymColors.GoGreen,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .background(
                            color = GymColors.GoGreen.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Composable
fun ShareUrlDisplay(
    url: String,
    onCopy: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showCopied by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8F9FA)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "공유 링크:",
                style = GymTheme.typography.labelSmallM,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = url,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = if (showCopied) "✅" else "📋",
                    style = GymTheme.typography.emojiTitleMedium,
                    modifier = Modifier
                        .clickable {
                            onCopy()
                            showCopied = true
                            scope.launch {
                                delay(2000)
                                showCopied = false
                            }
                        }
                        .padding(start = 8.dp)
                )
            }
        }
    }
}
