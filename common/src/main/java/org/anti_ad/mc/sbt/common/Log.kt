package org.anti_ad.mc.sbt.common

import org.anti_ad.mc.sbt.common.Log.LogLevel.*
import org.anti_ad.mc.sbt.common.extensions.tryCatch
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Log {
    private const val id = "smallbuildtweaks"
    val innerLogger: Logger = LogManager.getLogger(org.anti_ad.mc.sbt.common.Log.id)

    var shouldDebug: () -> Boolean = { true }
    var shouldTrace: () -> Boolean = { true }

    fun error(message: String) = org.anti_ad.mc.sbt.common.Log.innerLogger.error("[${org.anti_ad.mc.sbt.common.Log.id}] $message").also {
        org.anti_ad.mc.sbt.common.Log.onLog(ERROR,
                                            message)
    }

    fun warn(message: String) = org.anti_ad.mc.sbt.common.Log.innerLogger.warn("[${org.anti_ad.mc.sbt.common.Log.id}] $message").also {
        org.anti_ad.mc.sbt.common.Log.onLog(WARN,
                                            message)
    }

    fun info(message: String) = org.anti_ad.mc.sbt.common.Log.innerLogger.info("[${org.anti_ad.mc.sbt.common.Log.id}] $message").also {
        org.anti_ad.mc.sbt.common.Log.onLog(INFO,
                                            message)
    }
//  fun printDebug(message: String) = innerLogger.debug("[$id] $message")

    fun debug(message: String) = org.anti_ad.mc.sbt.common.Log.debug { message }
    fun debug(message: () -> String) {
        if (org.anti_ad.mc.sbt.common.Log.shouldDebug()) {
            val messageString = message()
            org.anti_ad.mc.sbt.common.Log.innerLogger.info("[${org.anti_ad.mc.sbt.common.Log.id}/DEBUG] $messageString").also {
                org.anti_ad.mc.sbt.common.Log.onLog(DEBUG,
                                                    messageString)
            }
        }
    }

    // for trace
    private var indent = 0

    inline fun indent(unit: () -> Unit) {
        org.anti_ad.mc.sbt.common.Log.indent()
        unit()
        org.anti_ad.mc.sbt.common.Log.unindent()
    }
    fun indent() {
        org.anti_ad.mc.sbt.common.Log.indent++
    }

    fun unindent() {
        org.anti_ad.mc.sbt.common.Log.indent--
    }

    fun clearIndent() {
        org.anti_ad.mc.sbt.common.Log.indent = 0
    }

    val kept = mutableListOf<String>()
    var keeping: Boolean = false

    fun keep(reason: String,  unit: () -> Unit) {
        org.anti_ad.mc.sbt.common.Log.kept.clear()
        org.anti_ad.mc.sbt.common.Log.keeping = true
        val shouldTraceOld = org.anti_ad.mc.sbt.common.Log.shouldTrace
        val shouldDebugOld = org.anti_ad.mc.sbt.common.Log.shouldDebug
        tryCatch({
                     org.anti_ad.mc.sbt.common.Log.keeping = false
                     org.anti_ad.mc.sbt.common.Log.shouldDebug = { true }
                     org.anti_ad.mc.sbt.common.Log.shouldTrace = { true }
                     org.anti_ad.mc.sbt.common.Log.indent = 0
                     org.anti_ad.mc.sbt.common.Log.trace("Kept logs for $reason")
                     org.anti_ad.mc.sbt.common.Log.kept.forEach {
                         org.anti_ad.mc.sbt.common.Log.trace(it)
                     }
                     org.anti_ad.mc.sbt.common.Log.trace("Operation terminated by:")
                     it.stackTrace.forEach { element ->
                         org.anti_ad.mc.sbt.common.Log.trace(element.toString())
                     }
                 },
                 unit)
        org.anti_ad.mc.sbt.common.Log.indent = 0;
        org.anti_ad.mc.sbt.common.Log.shouldDebug = shouldDebugOld
        org.anti_ad.mc.sbt.common.Log.shouldTrace = shouldTraceOld
    }

    private inline fun getMessageString(message: () -> String): String = " ".repeat(org.anti_ad.mc.sbt.common.Log.indent * 4) + message()

    fun trace(vararg messages: String) {
        messages.forEach {
            org.anti_ad.mc.sbt.common.Log.trace { it }
        }
    }
    fun trace(message: String) = org.anti_ad.mc.sbt.common.Log.trace { message }
    fun trace(message: () -> String) {
        if (org.anti_ad.mc.sbt.common.Log.keeping) {
            org.anti_ad.mc.sbt.common.Log.kept.add(org.anti_ad.mc.sbt.common.Log.getMessageString(message))
        }
        if (org.anti_ad.mc.sbt.common.Log.shouldTrace()) {
            val messageString = org.anti_ad.mc.sbt.common.Log.getMessageString(message)
            org.anti_ad.mc.sbt.common.Log.innerLogger.info("[${org.anti_ad.mc.sbt.common.Log.id}/TRACE] $messageString").also {
                org.anti_ad.mc.sbt.common.Log.onLog(TRACE,
                                                    messageString)
            }
        }
    }

    data class LogMessage(val level: org.anti_ad.mc.sbt.common.Log.LogLevel,
                          val message: String)

    enum class LogLevel : Comparable<org.anti_ad.mc.sbt.common.Log.LogLevel> {
        TRACE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        ;
    }

    private val logListener = mutableSetOf<(org.anti_ad.mc.sbt.common.Log.LogMessage) -> Unit>()

    private fun onLog(level: org.anti_ad.mc.sbt.common.Log.LogLevel,
                      message: String) {
        val logMessage = org.anti_ad.mc.sbt.common.Log.LogMessage(level,
                                                                  message)
        org.anti_ad.mc.sbt.common.Log.logListener.forEach { it(logMessage) }
    }

    fun addLogListener(listener: (org.anti_ad.mc.sbt.common.Log.LogMessage) -> Unit) {
        org.anti_ad.mc.sbt.common.Log.logListener.add(listener)
    }

    fun removeLogListener(listener: (org.anti_ad.mc.sbt.common.Log.LogMessage) -> Unit) {
        org.anti_ad.mc.sbt.common.Log.logListener.remove(listener)
    }

    inline fun withLogListener(noinline listener: (org.anti_ad.mc.sbt.common.Log.LogMessage) -> Unit,
                               block: () -> Unit) {
        org.anti_ad.mc.sbt.common.Log.addLogListener(listener)
        block()
        org.anti_ad.mc.sbt.common.Log.removeLogListener(listener)
    }

    inline fun withLogListener(level: org.anti_ad.mc.sbt.common.Log.LogLevel,
                               noinline listener: (org.anti_ad.mc.sbt.common.Log.LogMessage) -> Unit,
                               block: () -> Unit) {
        org.anti_ad.mc.sbt.common.Log.withLogListener({ logMessage ->
                                                          if (logMessage.level >= level) {
                                                              listener(logMessage)
                                                          }
                                                      },
                                                      block)
    }

}
