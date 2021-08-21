package org.anti_ad.mc.sbt.common.config.builder

import com.google.gson.JsonParseException
import org.anti_ad.mc.sbt.common.Log
import org.anti_ad.mc.sbt.common.Savable
import org.anti_ad.mc.sbt.common.config.IConfigElement
import org.anti_ad.mc.sbt.common.extensions.*
import org.anti_ad.mc.sbt.common.vanilla.glue.VanillaUtil
import org.anti_ad.mc.sbt.common.vanilla.glue.loggingPath
import java.io.IOException
import java.nio.file.Path


class ConfigSaveLoadManager(private val config: IConfigElement,
                            path: String) : org.anti_ad.mc.sbt.common.Savable {
    private val configFile: Path = VanillaUtil.configDirectory() / path
    private val path = configFile.loggingPath

    override fun save() {
        try {
            config.toJsonElement().toJsonString().writeToFile(configFile)
        } catch (e: IOException) {
            org.anti_ad.mc.sbt.common.Log.error("Failed to write config file $path")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun load(clientWorld: Any?) {
        try {
            if (!configFile.exists()) return
            configFile.readToString().parseAsJson()
                .let { config.fromJsonElement(it) }
        } catch (e: IOException) {
            org.anti_ad.mc.sbt.common.Log.error("Failed to read config file $path")
        } catch (e: JsonParseException) {
            org.anti_ad.mc.sbt.common.Log.error("Failed to parse config file $path as JSON")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}