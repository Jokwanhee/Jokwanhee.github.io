package com.kwanhee.gymapp

import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLTextAreaElement
import kotlin.js.Promise

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

private const val TEXT_COPIED = "Text copied to clipboard"


// TODO: 모바일에서 멈춤 현상 발생
internal fun copyToClipboard(text: String) {
    val textArea = document.createElement("textarea") as HTMLTextAreaElement
    textArea.value = text
    document.body?.appendChild(textArea)
    textArea.select()
    document.execCommand(text)
    document.body?.removeChild(textArea)
    window.navigator.clipboard.writeText(text)
    window.alert(text)
}
