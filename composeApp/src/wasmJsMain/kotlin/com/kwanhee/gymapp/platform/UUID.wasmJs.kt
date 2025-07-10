package com.kwanhee.gymapp.platform

import kotlinx.browser.window
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
actual fun randomUUID(): String {
    return  kotlin.uuid.Uuid.random().toString()
}
