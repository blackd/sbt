package org.anti_ad.mc.ipnext.input

import org.anti_ad.mc.common.IInputHandler
import org.anti_ad.mc.common.extensions.tryCatch
import org.anti_ad.mc.common.input.GlobalInputHandler
import org.anti_ad.mc.common.vanilla.VanillaScreenUtil
import org.anti_ad.mc.ipnext.config.Tweaks
import org.anti_ad.mc.ipnext.gui.ConfigScreen


object InputHandler : IInputHandler {

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