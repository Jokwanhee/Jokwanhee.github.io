package com.kwanhee.gymapp.data

interface ShareService {
    fun share(title: String, url: String)
}

expect class ShareServiceProvider() {
    fun getShareService(): ShareService
}