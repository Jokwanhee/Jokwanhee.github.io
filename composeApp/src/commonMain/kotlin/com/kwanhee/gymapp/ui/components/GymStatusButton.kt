package com.kwanhee.gymapp.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kwanhee.gymapp.data.GymStatus
import com.kwanhee.gymapp.ui.theme.GymColors
import com.kwanhee.gymapp.ui.theme.GymTheme
import gymapp.composeapp.generated.resources.NotoColorEmoji_Regular
import gymapp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun GymStatusButton(
    status: GymStatus,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // 선택 상태에 따른 애니메이션
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.05f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    val backgroundColor by animateColorAsState(
        targetValue = when {
            isSelected -> when (status) {
                GymStatus.GO -> GymColors.GoGreen
                GymStatus.NO -> GymColors.NoRed
                GymStatus.THINKING -> GymColors.ThinkingGray
            }
            else -> Color.White
        },
        animationSpec = tween(300)
    )

    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else Color.Black,
        animationSpec = tween(300)
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .scale(scale)
            .shadow(
                elevation = if (isSelected) 8.dp else 4.dp,
                shape = RoundedCornerShape(999.dp)
            )
            .clickable { onClick() },
        shape = RoundedCornerShape(999.dp), // 완전 동그랗게
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = status.emoji,
                style = GymTheme.typography.emojiTitleLarge,
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = status.text,
                style = GymTheme.typography.titleLargeB,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AnimatedEmojiReaction(
    emoji: String,
    isVisible: Boolean,
    modifier: Modifier = Modifier
) {
    if (isVisible) {
        val scale by animateFloatAsState(
            targetValue = if (isVisible) 1.5f else 0f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMedium
            )
        )

        Text(
            text = emoji,
            fontFamily = FontFamily(Font(Res.font.NotoColorEmoji_Regular)),
            fontSize = 48.sp,
            modifier = modifier.scale(scale),
            textAlign = TextAlign.Center
        )
    }
}
