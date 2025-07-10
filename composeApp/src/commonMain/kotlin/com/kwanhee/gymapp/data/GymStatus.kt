package com.kwanhee.gymapp.data

import kotlinx.datetime.Clock

// 헬스장 가는 상태 enum
enum class GymStatus(val emoji: String, val text: String, val description: String) {
    GO("✅", "오케이 콜~", "텐션 UP! 오늘은 운동하는 날! 💪"),
    NO("❌", "난 안가지ㅣㅣ~", "오늘은 쉬는 날... 집에서 뒹굴거려~ 😴"),
    THINKING("❔", "일단 고민중이긴해~", "갈까 말까... 아직 정하지 못했어 🤔")
}

// 사용자 상태 데이터 클래스
data class UserGymState(
    val name: String,
    val status: GymStatus,
    val lastUpdated: Long = Clock.System.now().epochSeconds
)

// 친구 상태 데이터 클래스  
data class FriendState(
    val friendId: String,
    val name: String,
    val status: GymStatus,
    val lastUpdated: Long
)
