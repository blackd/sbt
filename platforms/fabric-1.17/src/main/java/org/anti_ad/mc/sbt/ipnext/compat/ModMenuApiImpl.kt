package org.anti_ad.mc.sbt.ipnext.compat

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import org.anti_ad.mc.sbt.ipnext.gui.ConfigScreen

class ModMenuApiImpl : ModMenuApi {

    override fun getModConfigScreenFactory(): ConfigScreenFactory<ConfigScreen> {
        return ConfigScreenFactory<ConfigScreen> { parent ->
            val c = ConfigScreen()
            c.parent = parent
            c.dumpWidgetTree()
            c
        }
    }
}