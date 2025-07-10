// Copyright 2025 dev.kwan
package com.kwanhee.gymapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kwanhee.gymapp.data.FriendState
import com.kwanhee.gymapp.data.GymStatus
import com.kwanhee.gymapp.ui.theme.GymColors
import com.kwanhee.gymapp.ui.theme.GymTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun FriendStatusCard(
    friendState: FriendState?,
    modifier: Modifier = Modifier
) {
    if (friendState != null) {
        GoStatusCard(
            friendState = friendState,
            modifier = modifier,

            )
    }
//    if (friendState?.status == GymStatus.GO) {
//    } else {
//        DefaultStatusCard(friendState = friendState, modifier = modifier)
//    }
}

@Composable
private fun GoStatusCard(
    friendState: FriendState,
    modifier: Modifier = Modifier
) {
    // Unix 타임스탬프를 오전/오후 HH:mm:ss 형식으로 변환
    val lastUpdatedDateTime = Instant.fromEpochSeconds(friendState.lastUpdated)
        .toLocalDateTime(TimeZone.currentSystemDefault())
    val month = when (lastUpdatedDateTime.month) {
        Month.JANUARY -> 1
        Month.FEBRUARY -> 2
        Month.MARCH -> 3
        Month.APRIL -> 4
        Month.MAY -> 5
        Month.JUNE -> 6
        Month.JULY -> 7
        Month.AUGUST -> 8
        Month.SEPTEMBER -> 9
        Month.OCTOBER -> 10
        Month.NOVEMBER -> 11
        Month.DECEMBER -> 12
        else -> 0
    }
    val date = lastUpdatedDateTime.dayOfMonth


    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 0.dp, // 그림자 제거 또는 약하게
                shape = RoundedCornerShape(24.dp)
            ),
        shape = RoundedCornerShape(24.dp), // 더 둥근 모서리
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFBEF) // 연한 베이지색 배경 (이미지와 유사하게)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 1. 상단: 친구 현황 보고서 + 역도 이모지
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${month}월 ${date}일 친구의 편지",
                    style = GymTheme.typography.titleLargeB.copy(fontSize = 22.sp),
                    color = Color.Black
                )
                Spacer(Modifier.width(8.dp))
                Text("🏋️", fontSize = 36.sp) // 임시 텍스트 이모지
                Spacer(Modifier.width(4.dp))
                Text("📊", fontSize = 20.sp) // 임시 텍스트 이모지
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 2. 상태 메시지 카드 (녹색 배경)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = when (friendState.status) {
                            GymStatus.GO ->  GymColors.GoGreen
                            GymStatus.NO -> GymColors.NoRed
                            GymStatus.THINKING -> GymColors.ThinkingGray
                        },
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 20.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = when (friendState.status) {
                            GymStatus.GO -> "🎉 오늘 가야지~!"
                            GymStatus.NO -> "오늘은 안감!"
                            GymStatus.THINKING -> "고민중이긴해~"
                        },
                        style = GymTheme.typography.titleMediumB.copy(fontSize = 18.sp),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Spacer(modifier = Modifier.height(12.dp))

                    // 친구의 마음 섹션
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = Color.Black.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(vertical = 10.dp, horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = when (friendState.status) {
                                GymStatus.GO -> "오늘도 헬스해야지~ 오케이~ 💪"
                                GymStatus.NO -> "일이 있어서 못가~ 미안하긴해~"
                                GymStatus.THINKING -> "진짜 갈래? 말래?"
                            },
                            style = GymTheme.typography.bodyMediumR,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            lineHeight = 20.sp,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 3. 하단 리액션 이모지
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                when(friendState.status) {
                    GymStatus.GO -> Text("💪 🔥 ⚡", fontSize = 28.sp)
                    GymStatus.NO -> Text("😴 🛋️ 💤", fontSize = 28.sp)
                    GymStatus.THINKING -> Text( "🤔 💭 ", fontSize = 28.sp)
                }

            }

            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}


@Composable
private fun DefaultStatusCard(
    friendState: FriendState?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            ),
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
            if (friendState != null) {
                // 친구 이름
                Text(
                    text = "🙋‍♂️ ${friendState.name} 친구:",
                    style = GymTheme.typography.titleMediumB,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // 친구 상태 배지
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(999.dp)) // clip을 먼저 적용
                        .background(
                            color = when (friendState.status) {
                                GymStatus.GO -> GymColors.GoGreen // GO 상태는 이제 GoStatusCard에서 처리되지만, 만약을 위해 남겨둠
                                GymStatus.NO -> GymColors.NoRed
                                GymStatus.THINKING -> GymColors.ThinkingGray
                            }
                        )
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = friendState.status.emoji,
                        style = GymTheme.typography.emojiTitleMedium,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = friendState.status.text,
                        style = GymTheme.typography.titleMediumB,
                        color = Color.White
                    )
                }

                // 업데이트 시간 (선택사항) - GO 상태가 아닐 때
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = GymTheme.typography.emojiLabelSmall.toSpanStyle()
                                .copy(color = Color.Gray)
                        ) {
                            append("👉")
                        }
                        withStyle(
                            style = GymTheme.typography.labelSmallM.toSpanStyle()
                                .copy(color = Color.Gray)
                        ) {
                            append(" \"${friendState.status.text}\"")
                        }
                    },
                    modifier = Modifier.padding(top = 8.dp),
                    textAlign = TextAlign.Center
                )
            } else {
                // 친구가 아직 선택하지 않은 경우
                Text(
                    text = "🤔 친구가 아직 선택하지 않았어요",
                    style = GymTheme.typography.titleMediumR,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "링크를 공유해서 친구 상태를 확인해보세요!",
                    style = GymTheme.typography.labelSmallM,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun FriendStatusCardGoPreview() {
    val friendStateGo = FriendState(
        friendId = "friendGo",
        name = "헬스왕",
        status = GymStatus.GO,
        lastUpdated = Clock.System.now().epochSeconds - 3600 // 1시간 전
    )
    GymTheme {
        Column(Modifier.padding(16.dp).background(Color(0xFFE0E0E0))) { // 프리뷰 배경색
            FriendStatusCard(friendState = friendStateGo)
        }
    }
}

@Preview
@Composable
fun FriendStatusCardNoPreview() {
    val friendStateNo = FriendState(
        friendId = "friendNo",
        name = "집돌이",
        status = GymStatus.NO,
        lastUpdated = Clock.System.now().epochSeconds
    )
    GymTheme {
        Column(Modifier.padding(16.dp)) {
            FriendStatusCard(friendState = friendStateNo)
        }
    }
}

@Preview
@Composable
fun FriendStatusCardThinkingPreview() {
    val friendStateThinking = FriendState(
        friendId = "friendThinking",
        name = "고민중",
        status = GymStatus.THINKING,
        lastUpdated = Clock.System.now().epochSeconds
    )
    GymTheme {
        Column(Modifier.padding(16.dp)) {
            FriendStatusCard(friendState = friendStateThinking)
        }
    }
}

@Preview
@Composable
fun FriendStatusCardNullPreview() {
    GymTheme {
        Column(Modifier.padding(16.dp)) {
            FriendStatusCard(friendState = null)
        }
    }
}

@Composable
fun LoadingFriendCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            ),
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
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "⏳",
                    style = GymTheme.typography.emojiTitleMedium,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "기다려봐~ 친구 상태 확인 중이래!",
                    style = GymTheme.typography.titleMediumR,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}

@Preview
@Composable
fun LoadingFriendCardPreview() {
    GymTheme {
        LoadingFriendCard()
    }
}
