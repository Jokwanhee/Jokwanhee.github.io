package com.kwanhee.gymapp.platform

import java.util.UUID

actual fun randomUUID(): String = UUID.randomUUID().toString()
