@file:OptIn(InternalResourceApi::class)

package gymapp.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.FontResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceItem

private const val MD: String = "composeResources/gymapp.composeapp.generated.resources/"

internal val Res.font.IBMPlexSansKR_Bold: FontResource by lazy {
      FontResource("font:IBMPlexSansKR_Bold", setOf(
        ResourceItem(setOf(), "${MD}font/IBMPlexSansKR-Bold.ttf", -1, -1),
      ))
    }

internal val Res.font.IBMPlexSansKR_ExtraLight: FontResource by lazy {
      FontResource("font:IBMPlexSansKR_ExtraLight", setOf(
        ResourceItem(setOf(), "${MD}font/IBMPlexSansKR-ExtraLight.ttf", -1, -1),
      ))
    }

internal val Res.font.IBMPlexSansKR_Light: FontResource by lazy {
      FontResource("font:IBMPlexSansKR_Light", setOf(
        ResourceItem(setOf(), "${MD}font/IBMPlexSansKR-Light.ttf", -1, -1),
      ))
    }

internal val Res.font.IBMPlexSansKR_Medium: FontResource by lazy {
      FontResource("font:IBMPlexSansKR_Medium", setOf(
        ResourceItem(setOf(), "${MD}font/IBMPlexSansKR-Medium.ttf", -1, -1),
      ))
    }

internal val Res.font.IBMPlexSansKR_Regular: FontResource by lazy {
      FontResource("font:IBMPlexSansKR_Regular", setOf(
        ResourceItem(setOf(), "${MD}font/IBMPlexSansKR-Regular.ttf", -1, -1),
      ))
    }

internal val Res.font.IBMPlexSansKR_SemiBold: FontResource by lazy {
      FontResource("font:IBMPlexSansKR_SemiBold", setOf(
        ResourceItem(setOf(), "${MD}font/IBMPlexSansKR-SemiBold.ttf", -1, -1),
      ))
    }

internal val Res.font.IBMPlexSansKR_Thin: FontResource by lazy {
      FontResource("font:IBMPlexSansKR_Thin", setOf(
        ResourceItem(setOf(), "${MD}font/IBMPlexSansKR-Thin.ttf", -1, -1),
      ))
    }

internal val Res.font.NotoColorEmoji_Regular: FontResource by lazy {
      FontResource("font:NotoColorEmoji_Regular", setOf(
        ResourceItem(setOf(), "${MD}font/NotoColorEmoji-Regular.ttf", -1, -1),
      ))
    }

internal val Res.font.NotoSansKR_VariableFont_wght: FontResource by lazy {
      FontResource("font:NotoSansKR_VariableFont_wght", setOf(
        ResourceItem(setOf(), "${MD}font/NotoSansKR-VariableFont_wght.ttf", -1, -1),
      ))
    }

@InternalResourceApi
internal fun _collectCommonMainFont0Resources(map: MutableMap<String, FontResource>) {
  map.put("IBMPlexSansKR_Bold", Res.font.IBMPlexSansKR_Bold)
  map.put("IBMPlexSansKR_ExtraLight", Res.font.IBMPlexSansKR_ExtraLight)
  map.put("IBMPlexSansKR_Light", Res.font.IBMPlexSansKR_Light)
  map.put("IBMPlexSansKR_Medium", Res.font.IBMPlexSansKR_Medium)
  map.put("IBMPlexSansKR_Regular", Res.font.IBMPlexSansKR_Regular)
  map.put("IBMPlexSansKR_SemiBold", Res.font.IBMPlexSansKR_SemiBold)
  map.put("IBMPlexSansKR_Thin", Res.font.IBMPlexSansKR_Thin)
  map.put("NotoColorEmoji_Regular", Res.font.NotoColorEmoji_Regular)
  map.put("NotoSansKR_VariableFont_wght", Res.font.NotoSansKR_VariableFont_wght)
}
