package com.kwanhee.gym

import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLTextAreaElement

class WasmPlatform {
    val name: String = "Web with Kotlin/Wasm"
}

fun getPlatform() = WasmPlatform()

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
