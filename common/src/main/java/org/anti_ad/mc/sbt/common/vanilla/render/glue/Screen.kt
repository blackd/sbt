package org.anti_ad.mc.sbt.common.vanilla.render.glue

import org.anti_ad.mc.sbt.common.Log
import org.anti_ad.mc.sbt.common.math2d.Rectangle
import org.anti_ad.mc.sbt.common.math2d.Size

/// Screen.kt

var __glue_rScreenHeight: () -> Int = {
    org.anti_ad.mc.sbt.common.Log.error("__glue_rScreenHeight is not initialized!")
    400
}
val glue_rScreenHeight: Int
    get() = __glue_rScreenHeight.invoke()


var __glue_rScreenWidth: () -> Int = {
    org.anti_ad.mc.sbt.common.Log.error("__glue_rScreenWidth is not initialized!")
    400
}
val glue_rScreenWidth: Int
    get() = __glue_rScreenWidth.invoke()

var __glue_rScreenSize: () -> Size = {
    org.anti_ad.mc.sbt.common.Log.error("__glue_rScreenSize is not initialized!")
    Size(glue_rScreenWidth, glue_rScreenHeight)
}
val glue_rScreenSize: Size
    get() = __glue_rScreenSize.invoke()


fun __glue_rDepthMask__Default(bounds: Rectangle,
                               block: () -> Unit) {
    block()
}

var __glue_rDepthMask: (bounds: Rectangle,
                        block: () -> Unit) -> Unit =  { _: Rectangle,
                                                        block : () -> Unit ->
    org.anti_ad.mc.sbt.common.Log.error("__glue_rDepthMask is not initialized!")
    block()
}

var __glue_rRenderDirtBackground: () -> Unit = {
    org.anti_ad.mc.sbt.common.Log.error("____glue_rRenderDirtBackground is not initialized!")
}

fun rRenderDirtBackground() {
    __glue_rRenderDirtBackground()
}

fun rRenderBlackOverlay() { // Screen.renderBackground
    rFillGradient(0,
                  0,
                  glue_rScreenWidth,
                  glue_rScreenHeight,
                  -1072689136,
                  -804253680)
}

var __glue_VanillaUtil_inGame: () -> Boolean = {
    org.anti_ad.mc.sbt.common.Log.error("__glue_VanillaUtil_inGame is not initialized!")
    false
}


fun rRenderVanillaScreenBackground() { // Screen.renderBackground
    if (__glue_VanillaUtil_inGame()) {
        rRenderBlackOverlay()
    } else {
        rRenderDirtBackground()
    }
}

val rScreenBounds
    get() = Rectangle(0,
                      0,
                      glue_rScreenWidth,
                      glue_rScreenHeight)




