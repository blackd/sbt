package org.anti_ad.mc.sbt.common.gui.widgets

import org.anti_ad.mc.sbt.common.config.CategorizedMultiConfig
import org.anti_ad.mc.sbt.common.config.IConfigOption
import org.anti_ad.mc.sbt.common.gui.Tooltips
import org.anti_ad.mc.sbt.common.gui.widget.AnchorStyles
import org.anti_ad.mc.sbt.common.vanilla.render.glue.glue_rScreenWidth
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rDrawCenteredText

private const val COLOR_WHITE = -0x1
private const val textY = 6

fun CategorizedMultiConfig.toListWidget(
    displayNameOf: (String) -> String,
    descriptionOf: (String) -> String,
    categoryNameOf: (String) -> String
): ConfigListWidget =
    ConfigListWidget(displayNameOf,
                     descriptionOf).apply {
        for ((categoryName, configOptions) in categories) {
            val name = categoryNameOf(categoryName)
            when {
                name.isEmpty() -> Unit
                name.isBlank() -> addEntry(CategoryEntry(name))
                name.startsWith("§§vgap:") -> addHeight(name.substring(7).toIntOrNull() ?: 0)
                name.startsWith("§§hide") -> continue
                else -> addCategory(name)
            }
            configOptions.forEach { addConfigOption(it) }
        }
    }

class ConfigListWidget(private val displayNameOf: (String) -> String,
                       private val descriptionOf: (String) -> String) :
    AnchoredListWidget() {

    override fun render(mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        super.render(mouseX,
                     mouseY,
                     partialTicks)
        Tooltips.renderAll()
    }

    fun addCategory(categoryName: String) {
        addAnchor(categoryName)
        addEntry(CategoryEntry(categoryName))
    }

    fun addConfigOption(configOption: IConfigOption) {
        addEntry(ConfigOptionEntry(configOption))
    }

    fun addHeight(height: Int) {
        addEntry(Entry().apply { this.height = height })
    }

    // ============
    // inner classes
    // ============
    inner class ConfigOptionEntry(val configOption: IConfigOption) : Entry() {
        val displayName
            get() = displayNameOf(configOption.key)
        val description
            get() = descriptionOf(configOption.key)

        val configWidget: ConfigWidgetBase<*> = configOption.toConfigWidget().apply {
            anchor = AnchorStyles.all
            this@ConfigOptionEntry.addChild(this)
            top = 0
            left = this@ConfigOptionEntry.width / 2
            right = 0
            bottom = 0
        }

        val displayNameTextWidget = TextButtonWidget(displayName).apply {
            clickThrough = true
            this@ConfigOptionEntry.addChild(this)
            top = textY
            left = 2
            zIndex = 1
        }

        override fun render(mouseX: Int,
                            mouseY: Int,
                            partialTicks: Float) {
            if (outOfContainer) return
            super.render(mouseX,
                         mouseY,
                         partialTicks)
            if (description.isNotEmpty()
                && displayNameTextWidget.contains(mouseX,
                                                  mouseY)
                && !anchorHeader.contains(mouseX,
                                          mouseY)
            ) {
                Tooltips.addTooltip(description,
                                    mouseX,
                                    mouseY,
                                    glue_rScreenWidth * 2 / 3)
            }
        }

        init {
            sizeChanged += {
                configWidget.left = width / 2
            }
        }
    }

    inner class CategoryEntry(private val categoryName: String) : Entry() {
        override fun render(mouseX: Int,
                            mouseY: Int,
                            partialTicks: Float) {
            if (outOfContainer) return
            rDrawCenteredText(categoryName,
                              absoluteBounds,
                              COLOR_WHITE)
        }
    }

    open inner class Entry : Widget() {
        init {
            height = 20
        }

        val outOfContainer: Boolean
            get() = isOutOfContainer(this)
    }
}