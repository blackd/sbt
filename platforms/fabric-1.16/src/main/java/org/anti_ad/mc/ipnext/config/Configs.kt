@file:Suppress("unused")

package org.anti_ad.mc.ipnext.config

import org.anti_ad.mc.common.Savable
import org.anti_ad.mc.common.config.builder.CATEGORY
import org.anti_ad.mc.common.config.builder.ConfigDeclaration
import org.anti_ad.mc.common.config.builder.ConfigSaveLoadManager
import org.anti_ad.mc.common.config.builder.createBuilder
import org.anti_ad.mc.common.config.builder.hotkey
import org.anti_ad.mc.common.config.builder.hotkeyedBool
import org.anti_ad.mc.common.config.builder.toMultiConfig
import org.anti_ad.mc.common.input.KeybindSettings

private const val category = "smallbuildtweaks.config.category"

object Tweaks : ConfigDeclaration {
    override val builder = createBuilder()
        .CATEGORY("$category.hotkeys")
    val OPEN_CONFIG_MENU                          /**/ by hotkey("LEFT_SHIFT,\\",
                                                                 KeybindSettings.INGAME_DEFAULT)
        .CATEGORY("$category.survival")
    val INSTANT_MINING_COOLDOWN                   /**/ by hotkeyedBool(false)
    val DISABLE_BLOCK_BREAKING_COOLDOWN           /**/ by hotkeyedBool(false)
    val DISABLE_ITEM_USE_COOLDOWN                 /**/ by hotkeyedBool(false)
    val DISABLE_SCREEN_SHAKING_ON_DAMAGE          /**/ by hotkeyedBool(false)
    val DISABLE_LAVA_FOG                          /**/ by hotkeyedBool(false)

}


const val FILE_PATH = "smallbuildtweaks/sbt.json"

val Configs = listOf(
    Tweaks,
)

object SaveLoadManager : Savable by ConfigSaveLoadManager(Configs.toMultiConfig(),
                                                          FILE_PATH)
