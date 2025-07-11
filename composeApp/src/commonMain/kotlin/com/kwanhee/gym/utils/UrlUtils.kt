package com.kwanhee.gymapp.utils

// URL 처리를 위한 유틸리티
object UrlUtils {
    // 공유 URL 생성
    fun generateShareUrl(baseUrl: String, shareToken: String): String {
        val cleanBaseUrl = baseUrl.removeSuffix("/")
        return "$cleanBaseUrl/share/$shareToken"
    }
}
