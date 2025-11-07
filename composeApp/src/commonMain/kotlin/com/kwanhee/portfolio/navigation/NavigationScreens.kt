package com.kwanhee.portfolio.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationScreens(var route: String) {
    @Serializable
    data object GymScreen : NavigationScreens("/")

    @Serializable
    data object ShareScreen : NavigationScreens("share/")
}
