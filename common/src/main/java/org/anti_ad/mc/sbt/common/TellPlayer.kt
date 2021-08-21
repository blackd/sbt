package org.anti_ad.mc.sbt.common

import org.anti_ad.mc.sbt.common.Log
import org.anti_ad.mc.sbt.common.vanilla.glue.VanillaUtil

object TellPlayer {

    fun chat(message: String) {
        if (!VanillaUtil.inGame()) return
        VanillaUtil.chat(message)
    }

    inline fun listenLog(level: org.anti_ad.mc.sbt.common.Log.LogLevel,
                         block: () -> Unit) {
        org.anti_ad.mc.sbt.common.Log.withLogListener(level,
                                                      { chat(it.message) },
                                                      block)
    }
}