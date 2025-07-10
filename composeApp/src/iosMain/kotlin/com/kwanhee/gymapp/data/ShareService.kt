package com.kwanhee.gymapp.data

class iOSShareService() : ShareService {
    override fun share(title: String, url: String) {
    }
}

actual class ShareServiceProvider {
    actual fun getShareService(): ShareService = iOSShareService()
}