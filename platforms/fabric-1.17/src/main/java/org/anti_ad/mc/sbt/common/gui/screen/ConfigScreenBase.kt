package org.anti_ad.mc.sbt.common.gui.screen

import org.anti_ad.mc.sbt.common.config.options.ConfigHotkey
import org.anti_ad.mc.sbt.common.gui.widget.AnchorStyles
import org.anti_ad.mc.sbt.common.gui.widget.Flex
import org.anti_ad.mc.sbt.common.gui.widget.FlexDirection.TOP_DOWN
import org.anti_ad.mc.sbt.common.gui.widgets.ButtonWidget
import org.anti_ad.mc.sbt.common.gui.widgets.ConfigHotkeyWidget
import org.anti_ad.mc.sbt.common.gui.widgets.Widget
import org.anti_ad.mc.sbt.common.gui.widgets.toWidget
import org.anti_ad.mc.sbt.common.input.GlobalInputHandler
import org.anti_ad.mc.sbt.common.math2d.Size
import org.anti_ad.mc.sbt.common.vanilla.alias.Text
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rDrawText
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rMeasureText
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rRenderVanillaScreenBackground
import kotlin.math.max

private const val COLOR_WHITE = 0xFFFFFFFF.toInt()

open class ConfigScreenBase(text: Text) : BaseScreen(text) {

    var openConfigMenuHotkeyWidget: ConfigHotkeyWidget? = null
        private set(value) {
            field?.parent = null
            field = value?.apply {
                anchor = AnchorStyles.topRight
                this@ConfigScreenBase.addWidget(this)
                size = Size(150,
                            20)
                top = 5
                right = 10 // do set right after add
            }
        }

    var openConfigMenuHotkey: ConfigHotkey? = null
        set(value) {
            field = value
            openConfigMenuHotkeyWidget = value?.toWidget()
        }

    val navigationButtonsContainer = Widget().apply {
        anchor = AnchorStyles.noRight
        this@ConfigScreenBase.addWidget(this)
        top = 30
        left = 10
        bottom = 0
    }

    private val navigationButtonsFlowLayout =
        Flex(navigationButtonsContainer,
             TOP_DOWN)

    var currentConfigList: Widget? = null
        set(value) {
            field?.parent = null
            field = value?.apply {
                anchor = AnchorStyles.all
                this@ConfigScreenBase.addWidget(this)
                top = 30
                left = 10 + navigationButtonsContainer.width + 5
                right = 10
                bottom = 10
                zIndex = 1
            }
        }

    private val navigationButtonsInfo = mutableListOf<Pair<String, () -> Unit>>()

    var selectedIndex = -1
        set(value) {
            if (value < 0 || value >= navigationButtonsContainer.childCount) {
                field = -1
                updateButtonsActive()
                selectedIndexChanged()
            } else if (value != field) {
                field = value
                updateButtonsActive()
                navigationButtonsInfo[value].second()
                selectedIndexChanged()
            }
        }

    open fun selectedIndexChanged() {}

    private fun updateButtonsActive() {
        navigationButtonsContainer.children.forEachIndexed { index, child ->
            child.active = selectedIndex != index
        }
    }

    override fun render(mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        rRenderVanillaScreenBackground()
        rDrawText(this.titleString,
                  20,
                  10,
                  COLOR_WHITE)
        super.render(mouseX,
                     mouseY,
                     partialTicks)
    }

    fun addNavigationButton(buttonText: String,
                            action: () -> Unit) {
        val id = navigationButtonsContainer.childCount
        navigationButtonsContainer.apply {
            width = max(width,
                        rMeasureText(buttonText) + 20)
        }
        navigationButtonsInfo.add(Pair(buttonText,
                                       action))
        navigationButtonsFlowLayout.add(ButtonWidget { ->
            selectedIndex = id
        }.apply {
            text = buttonText
        },
                                        20)
        navigationButtonsFlowLayout.addSpace(2)
    }

    fun addNavigationButtonWithWidget(buttonText: String,
                                      widgetSupplier: () -> Widget?) {
        addNavigationButton(buttonText) { currentConfigList = widgetSupplier() }
    }

    fun addNavigationButton(buttonText: String) {
        addNavigationButtonWithWidget(buttonText) { null }
    }

    override fun closeScreen() {
        if (GlobalInputHandler.currentAssigningKeybind != null) return
        super.closeScreen()
    }

}
