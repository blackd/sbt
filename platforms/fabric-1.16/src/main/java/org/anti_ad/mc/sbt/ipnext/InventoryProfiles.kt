package org.anti_ad.mc.sbt.ipnext

import org.anti_ad.mc.sbt.common.Log
import org.anti_ad.mc.sbt.common.vanilla.alias.aliasInitGlue
import org.anti_ad.mc.sbt.common.vanilla.render.renderInitTheGlue
import org.anti_ad.mc.sbt.common.vanilla.vanillaInitGlue
import org.anti_ad.mc.sbt.ipnext.config.SaveLoadManager
import org.anti_ad.mc.sbt.ipnext.event.ClientInitHandler
import org.anti_ad.mc.sbt.ipnext.input.InputHandler

@Suppress("unused")
fun init() {

    ClientInitHandler.register {

        org.anti_ad.mc.sbt.common.Log.shouldDebug = { false }
        org.anti_ad.mc.sbt.common.Log.shouldTrace = { false }

        renderInitTheGlue()
        aliasInitGlue()
        vanillaInitGlue()

        InputHandler.onClientInit()
        SaveLoadManager.load()
        //CustomDataFileLoader.load()

    }

}