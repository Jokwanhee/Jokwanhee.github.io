package com.kwanhee.gymapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform