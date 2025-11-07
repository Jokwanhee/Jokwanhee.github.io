package com.kwanhee.portfolio.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.kwanhee.portfolio.ui.KwanheeColors

@Composable
fun MainScreen() {
    Scaffold(
        containerColor = KwanheeColors.Background,
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(KwanheeColors.Background)
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
        }
    }
}