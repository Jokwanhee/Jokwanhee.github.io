package com.kwanhee.gym

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kwanhee.gym.WebConstants.PATH_START
import com.kwanhee.gym.WebConstants.POP_STATE
import com.kwanhee.gymapp.navigation.NavigationScreens
import com.kwanhee.gymapp.screens.GymScreen
import com.kwanhee.gymapp.screens.ShareScreen
import kotlinx.browser.window
import org.w3c.dom.events.Event

object WebConstants {
    const val PATH_START = "/"
    const val POP_STATE = "popstate"
}

@Composable
fun App() {
    val currentPath = remember { mutableStateOf(window.location.pathname) }
    DisposableEffect(Unit) {
        val onPopState: (Event) -> Unit = {
            currentPath.value = window.location.pathname
        }
        window.addEventListener(POP_STATE, onPopState)

        onDispose {
            window.removeEventListener(POP_STATE, onPopState)
        }
    }

    val path = currentPath.value

    when {
        path == "" || path == PATH_START -> {
            GymScreen()
        }

        path.startsWith("$PATH_START${NavigationScreens.ShareScreen.route}") -> {
            ShareScreen()
        }


        else -> {
            // TODO: PageNotFound
        }
    }
}