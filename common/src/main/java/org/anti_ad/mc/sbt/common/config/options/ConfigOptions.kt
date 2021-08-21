package org.anti_ad.mc.sbt.common.config.options

import com.google.gson.JsonElement
import com.google.gson.JsonNull
import org.anti_ad.mc.sbt.common.Log
import org.anti_ad.mc.sbt.common.config.ConfigOptionBase
import org.anti_ad.mc.sbt.common.config.ConfigOptionNumericBase
import org.anti_ad.mc.sbt.common.config.IConfigOptionPrimitive
import org.anti_ad.mc.sbt.common.config.IConfigOptionToggleable
import org.anti_ad.mc.sbt.common.extensions.next
import org.anti_ad.mc.sbt.common.extensions.previous
import org.anti_ad.mc.sbt.common.gui.widgets.ConfigButtonInfo

class ConfigDouble(defaultValue: Double,
                   minValue: Double,
                   maxValue: Double) :
    ConfigOptionNumericBase<Double>(defaultValue,
                                    minValue,
                                    maxValue) {
    override fun setNumericValue(value: Number) = run { this.value = value.toDouble() }
    val doubleValue
        get() = value
}

class ConfigInteger(defaultValue: Int,
                    minValue: Int,
                    maxValue: Int) :
    ConfigOptionNumericBase<Int>(defaultValue,
                                 minValue,
                                 maxValue) {
    override fun setNumericValue(value: Number) = run { this.value = value.toInt() }
    val integerValue
        get() = value
}

open class ConfigBoolean(final override val defaultValue: Boolean) :
    ConfigOptionBase(), IConfigOptionPrimitive<Boolean>, IConfigOptionToggleable {
    override var value = defaultValue
    override fun toggleNext() = run { value = !value }
    override fun togglePrevious() = run { value = !value }
    val booleanValue
        get() = value
}

class ConfigEnum<E : Enum<E>>(override val defaultValue: E) :
    ConfigOptionBase(), IConfigOptionPrimitive<E>, IConfigOptionToggleable {
    override var value = defaultValue
    override fun toggleNext() = run { value = value.next() }
    override fun togglePrevious() = run { value = value.previous() }
}

class ConfigString(override val defaultValue: String) :
    ConfigOptionBase(), IConfigOptionPrimitive<String> {
    override var value = defaultValue
}

class ConfigButton(val info: ConfigButtonInfo) : ConfigOptionBase() { // fake config that acts as button
    override fun toJsonElement(): JsonElement {
        org.anti_ad.mc.sbt.common.Log.error("this is a config button") // shouldn't be called
        return JsonNull.INSTANCE
    }

    override fun fromJsonElement(element: JsonElement) {
        org.anti_ad.mc.sbt.common.Log.warn("this is a config button $element")
    }

    override val isModified = false
    override fun resetToDefault() {}
}