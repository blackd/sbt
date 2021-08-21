package org.anti_ad.mc.sbt.common.gui.screen

data class ScreenInfo(val isPauseScreen: Boolean = false) {
    companion object {
        val default = ScreenInfo()
    }
}