package com.kwanhee.gymapp.data

//@JsExport
//@JsName("createJsObject")
//private fun createJsObject(): JsAny = js("({})")

class DesktopShareService() : ShareService {
    override fun share(title: String, url: String) {
    }
}

actual class ShareServiceProvider {
    actual fun getShareService(): ShareService = DesktopShareService()
}