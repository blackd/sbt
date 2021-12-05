package org.anti_ad.mc.sbt.ipnext.input

import org.anti_ad.mc.sbt.common.IInputHandler
import org.anti_ad.mc.sbt.common.extensions.tryCatch
import org.anti_ad.mc.sbt.common.input.GlobalInputHandler
import org.anti_ad.mc.sbt.common.vanilla.VanillaScreenUtil
import org.anti_ad.mc.sbt.ipnext.config.Tweaks
import org.anti_ad.mc.sbt.ipnext.gui.ConfigScreen


object InputHandler : org.anti_ad.mc.sbt.common.IInputHandler {

    // public static Keybind debugKey = new Keybind("RIGHT_CONTROL,BACKSPACE", KeybindSettings.ANY_DEFAULT);

    override fun onInput(lastKey: Int,
                         lastAction: Int): Boolean {
        return tryCatch(false) {
            if (Tweaks.OPEN_CONFIG_MENU.isActivated()) {
                VanillaScreenUtil.openScreen(ConfigScreen())
            }
            return false
        }
    }

    fun onClientInit() {
        GlobalInputHandler.register(this)
    }
}