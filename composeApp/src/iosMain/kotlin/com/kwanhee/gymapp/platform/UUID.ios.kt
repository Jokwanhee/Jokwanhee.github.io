package com.kwanhee.gymapp.platform

import platform.Foundation.NSUUID

actual fun randomUUID(): String = NSUUID().UUIDString()
