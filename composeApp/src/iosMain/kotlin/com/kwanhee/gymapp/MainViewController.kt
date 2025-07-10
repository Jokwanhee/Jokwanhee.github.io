package com.kwanhee.gymapp

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController(friendId: String?) = ComposeUIViewController {
    App(friendId = friendId)
}
