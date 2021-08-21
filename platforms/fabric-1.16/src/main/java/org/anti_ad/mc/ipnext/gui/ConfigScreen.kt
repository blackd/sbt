package org.anti_ad.mc.ipnext.gui

import org.anti_ad.mc.common.config.CategorizedMultiConfig
import org.anti_ad.mc.common.config.builder.toMultiConfigList
import org.anti_ad.mc.common.gui.screen.ConfigScreenBase
import org.anti_ad.mc.common.gui.widgets.toListWidget
import org.anti_ad.mc.common.vanilla.alias.TranslatableText
import org.anti_ad.mc.common.vanilla.alias.glue.I18n
import org.anti_ad.mc.ipnext.ModInfo
import org.anti_ad.mc.ipnext.config.Configs
import org.anti_ad.mc.ipnext.config.SaveLoadManager
import org.anti_ad.mc.ipnext.config.Tweaks

private const val BUTTON_PREFIX = "smallbuildtweaks.gui.config."
private const val DISPLAY_NAME_PREFIX = "smallbuildtweaks.config.name."
private const val DESCRIPTION_PREFIX = "smallbuildtweaks.config.description."

class ConfigScreen : ConfigScreenBase(TranslatableText("smallbuildtweaks.gui.config.title",
                                                       ModInfo.MOD_VERSION)) {


    companion object {
        var storedSelectedIndex = 0
    }

    private fun CategorizedMultiConfig.toListWidget() =
        this.toListWidget(
            { I18n.translateOrElse(DISPLAY_NAME_PREFIX + it) { it } },
            { I18n.translateOrEmpty(DESCRIPTION_PREFIX + it) },
            { I18n.translateOrElse(it) { it.substringAfterLast('.') } }
        )

    init {
        openConfigMenuHotkey = Tweaks.OPEN_CONFIG_MENU
        Configs // hide debugs class
            .toMultiConfigList().forEach { multi ->
                addNavigationButtonWithWidget(I18n.translate(BUTTON_PREFIX + multi.key)) { multi.toListWidget() }
            }
        selectedIndex = storedSelectedIndex
    }

    override fun closeScreen() {
        storedSelectedIndex = selectedIndex
        SaveLoadManager.save()
        super.closeScreen()
    }
}