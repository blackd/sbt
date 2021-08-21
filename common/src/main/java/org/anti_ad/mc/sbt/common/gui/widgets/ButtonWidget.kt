package org.anti_ad.mc.sbt.common.gui.widgets

import org.anti_ad.mc.sbt.common.vanilla.glue.VanillaSound
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rDrawCenteredText
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rDrawDynamicSizeSprite
import org.anti_ad.mc.sbt.common.vanilla.render.glue.rVanillaButtonSprite

open class ButtonWidget : Widget {
    var clickEvent: (Int) -> Unit = { }

    constructor(clickEvent: (button: Int) -> Unit) {
        this.clickEvent = { button ->
            VanillaSound.playClick()
            clickEvent(button)
        }
    }

    constructor(clickEvent: () -> Unit) {
        this.clickEvent = { button ->
            if (button == 0) {
                VanillaSound.playClick()
                clickEvent()
            }
        }
    }

    constructor()

    var clickThrough = false

    open fun onClick(button: Int) {
        clickEvent(button)
    }

    override fun mouseClicked(x: Int,
                              y: Int,
                              button: Int): Boolean {
        super.mouseClicked(x,
                           y,
                           button)
        if (active) onClick(button)
        return !clickThrough
    }

    override fun render(mouseX: Int,
                        mouseY: Int,
                        partialTicks: Float) {
        renderButton(contains(mouseX,
                              mouseY))
        super.render(mouseX,
                     mouseY,
                     partialTicks)
    }

    open fun renderButton(hovered: Boolean) {
        val k = if (active) if (hovered) 2 else 1 else 0
        val sprite = rVanillaButtonSprite.down(k)
        rDrawDynamicSizeSprite(sprite,
                               absoluteBounds)
        val textColor = if (active) if (hovered) 16777120 else 14737632 else 10526880
        rDrawCenteredText(text,
                          screenX + width / 2,
                          screenY + (height - 8) / 2,
                          textColor)
    }

    init {
        height = 20
    }

}