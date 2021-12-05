package org.anti_ad.mc.sbt.common.gui.widgets

import org.anti_ad.mc.sbt.common.Log
import org.anti_ad.mc.sbt.common.config.IConfigOption
import org.anti_ad.mc.sbt.common.config.IConfigOptionNumeric
import org.anti_ad.mc.sbt.common.config.options.ConfigBoolean
import org.anti_ad.mc.sbt.common.config.options.ConfigButton
import org.anti_ad.mc.sbt.common.config.options.ConfigEnum
import org.anti_ad.mc.sbt.common.config.options.ConfigHotkey
import org.anti_ad.mc.sbt.common.config.options.ConfigString
import org.anti_ad.mc.sbt.common.math2d.Rectangle
import org.anti_ad.mc.sbt.common.vanilla.render.glue.IdentifierHolder
import org.anti_ad.mc.sbt.common.vanilla.render.glue.Sprite
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rDrawSprite

//region Widget Providers for Config Options

fun ConfigHotkey.toWidget() = ConfigHotkeyWidget(this)

fun IConfigOptionNumeric<*>.toWidget() = ConfigNumericWidget(this)

fun ConfigString.toWidget() = ConfigStringWidget(this)

fun IConfigOption.toConfigWidget(): ConfigWidgetBase<IConfigOption> = when (this) {
    is ConfigBoolean -> this.toWidget()
    is IConfigOptionNumeric<*> -> this.toWidget()
    is ConfigEnum<*> -> this.toWidget()
    is ConfigHotkey -> this.toWidget()
    is ConfigString -> this.toWidget()
    is ConfigButton -> this.toWidget()
    else -> object : ConfigWidgetBase<IConfigOption>(this) {}
        .also { org.anti_ad.mc.sbt.common.Log.error("unknown config option $this") }
}

//endregion

private val WIDGETS_TEXTURE = IdentifierHolder("smallbuildtweaks",
                                               "textures/gui/widgets.png")

private val PATTERN_INTEGER = Regex("-?[0-9]*")
private val PATTERN_DOUBLE = Regex("^-?([0-9]+(\\.[0-9]*)?)?")

class ConfigNumericWidget(configOption: IConfigOptionNumeric<*>) :
    ConfigWidgetBase<IConfigOptionNumeric<*>>(configOption) {
    val pattern = if (configOption.defaultValue is Double) PATTERN_DOUBLE else PATTERN_INTEGER

    var useSlider = true
    val slider = SliderWidget(configOption.minValue.toDouble(),
                              configOption.maxValue.toDouble()).apply {
        value = configOption.value.toDouble()
        valueChangedEvent = {
            setNumericValue(value)
        }
    }
    val textField = TextFieldWidget(18).apply {
        textPredicate = { it.isEmpty() || pattern.matches(it) }
        changedEvent = {
            if (editing()) try { // try set config value to text
                setNumericValue(if (vanillaText.isEmpty()) 0 else vanillaText.toDouble())
            } catch (e: NumberFormatException) {
            }
        }
    }

    fun setNumericValue(value: Number) {
        configOption.setNumericValue(value)
        if (useSlider) {
            textField.vanillaText = value.toString()
        } else {
            slider.value = value.toDouble()
        }
    }

    val toggleButton = object : ButtonWidget({ -> useSlider = !useSlider }) {
        override fun renderButton(hovered: Boolean) {
            val textureX = if (hovered) 32 else 16
            val textureY = if (useSlider) 16 else 0
            val sprite = Sprite(WIDGETS_TEXTURE,
                                Rectangle(textureX,
                                          textureY,
                                          16,
                                          16))
            rDrawSprite(sprite,
                        screenX,
                        screenY)
        }
    }

    override fun render(mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        slider.vanillaMessage = configOption.value.toString()
        slider.visible = useSlider
        textField.visible = !useSlider
        if (useSlider) {
            slider.value = configOption.value.toDouble()
            textField.vanillaFocused = false
        }
        if (!textField.editing() && !useSlider) { // is editing
            textField.vanillaText = configOption.value.toString()
        }
        super.render(mouseX,
                     mouseY,
                     partialTicks)
    }

    init {
        flex.reverse.add(toggleButton,
                         16,
                         false,
                         16)
        flex.reverse.addSpace(2)
        flex.reverse.offset.let { offset ->
            flex.reverse.addAndFit(slider)
            flex.reverse.offset = offset
            flex.reverse.addSpace(1)
            flex.normal.addSpace(2)
            flex.addAndFit(textField)
            textField.top = 1
        }
    }
}

class ConfigStringWidget(configOption: ConfigString) : ConfigWidgetBase<ConfigString>(configOption) {
    val textField = TextFieldWidget(18).apply {
        changedEvent = {
            configOption.value = vanillaText
        }
    }

    override fun render(mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        if (!textField.editing())
            textField.vanillaText = configOption.value
        super.render(mouseX,
                     mouseY,
                     partialTicks)
    }

    init {
        flex.normal.addSpace(2)
        flex.reverse.addSpace(2)
        flex.addAndFit(textField)
        textField.top = 1
    }
}


