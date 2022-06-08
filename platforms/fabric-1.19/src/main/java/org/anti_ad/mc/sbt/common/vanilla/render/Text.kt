@file:Suppress("NOTHING_TO_INLINE")

package org.anti_ad.mc.sbt.common.vanilla.render

import net.minecraft.text.Style
import net.minecraft.text.Text
import org.anti_ad.mc.sbt.common.vanilla.Vanilla
import org.anti_ad.mc.sbt.common.vanilla.render.glue.__glue_Vanilla_textRenderer_draw
import org.anti_ad.mc.sbt.common.vanilla.render.glue.__glue_Vanilla_textRenderer_drawWithShadow
import org.anti_ad.mc.sbt.common.vanilla.render.glue.__glue_Vanilla_textRenderer_getWidth
import org.anti_ad.mc.sbt.common.vanilla.render.glue.__glue_Vanilla_textRenderer_textHandler_wrapLines

fun initTextGlue() {
    __glue_Vanilla_textRenderer_textHandler_wrapLines = { s: String, i: Int ->
        // wrapStringToWidth() = wrapLines() // trimToWidth() is not!!!!!!!!!!
        Vanilla.textRenderer().textHandler.wrapLines(Text.literal(s),
                                                     i,
                                                     Style.EMPTY).joinToString("\n") { it.string }
    }
    __glue_Vanilla_textRenderer_getWidth = {s: String ->
        Vanilla.textRenderer().getWidth(s) // getStringWidth() = getWidth()
    }

    __glue_Vanilla_textRenderer_drawWithShadow = {string: String, x: Double, y: Double, color: Int ->
        Vanilla.textRenderer().drawWithShadow(rMatrixStack,
                                              string,
                                              x.toFloat(),
                                              y.toFloat(),
                                              color)
    }

    __glue_Vanilla_textRenderer_draw = {string: String, x: Double, y: Double, color: Int ->
        Vanilla.textRenderer().draw(rMatrixStack,
                                    string,
                                    x.toFloat(),
                                    y.toFloat(),
                                    color)
    }
}
