package org.anti_ad.mc.ipnext

import org.anti_ad.mc.common.Log
import org.anti_ad.mc.common.vanilla.alias.aliasInitGlue
import org.anti_ad.mc.common.vanilla.render.renderInitTheGlue
import org.anti_ad.mc.common.vanilla.vanillaInitGlue
import org.anti_ad.mc.ipnext.config.SaveLoadManager
import org.anti_ad.mc.ipnext.event.ClientInitHandler
import org.anti_ad.mc.ipnext.input.InputHandler

@Suppress("unused")
fun init() {

    ClientInitHandler.register {

        Log.shouldDebug = { false }
        Log.shouldTrace = { false }

        renderInitTheGlue()
        aliasInitGlue()
        vanillaInitGlue()

        InputHandler.onClientInit()
        SaveLoadManager.load()
        //CustomDataFileLoader.load()

    }

}