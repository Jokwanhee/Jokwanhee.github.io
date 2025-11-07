package com.kwanhee.gymapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kwanhee.gymapp.ui.theme.GymColors

@Composable
fun GymScreen() {
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
        }
    }
}