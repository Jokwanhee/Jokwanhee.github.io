package com.kwanhee.gymapp.data

//@JsExport
//@JsName("createJsObject")
//private fun createJsObject(): JsAny = js("({})")

class WebShareService() : ShareService {
    override fun share(title: String, url: String) {
//        val data: ShareData = createJsObject().unsafeCast<ShareData>()
//        data.title = title
//        data.url = url


//        if (navigator.canShare(data)) {e
//            navigator.shareAsync(data)
//        } else {
//            // 공유할 수 없는 경우 처리
//        }
    }
}

actual class ShareServiceProvider {
    actual fun getShareService(): ShareService = WebShareService()
}