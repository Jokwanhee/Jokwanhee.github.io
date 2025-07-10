package com.kwanhee.gymapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kwanhee.gymapp.ui.theme.GymTheme
import gymapp.composeapp.generated.resources.NotoColorEmoji_Regular
import gymapp.composeapp.generated.resources.Res
import kotlinx.datetime.Clock
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun DateHeader(
    modifier: Modifier = Modifier
) {

    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val dayOfWeek = when (today.dayOfWeek) {
        DayOfWeek.MONDAY -> "월"
        DayOfWeek.TUESDAY -> "화"
        DayOfWeek.WEDNESDAY -> "수"
        DayOfWeek.THURSDAY -> "목"
        DayOfWeek.FRIDAY -> "금"
        DayOfWeek.SATURDAY -> "토"
        DayOfWeek.SUNDAY -> "일"
        // else -> "" // Should not happen if all DayOfWeek are covered, but added for safety if compiler insists
        else -> ""
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "오늘은 ${today.monthNumber}월 ${today.dayOfMonth}일 (${dayOfWeek})",
            style = GymTheme.typography.headlineSmallBL,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row {
            Text(
                text = "갈래? 말래?",
                style = GymTheme.typography.titleMediumB,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Text(
                text = "🤷‍♀️",
                style = GymTheme.typography.emojiTitleMedium,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
    }
}
