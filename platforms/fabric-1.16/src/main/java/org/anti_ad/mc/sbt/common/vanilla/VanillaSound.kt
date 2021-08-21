package org.anti_ad.mc.sbt.common.vanilla

import org.anti_ad.mc.sbt.common.vanilla.alias.PositionedSoundInstance
import org.anti_ad.mc.sbt.common.vanilla.alias.SoundEvents
import org.anti_ad.mc.sbt.common.vanilla.glue.IVanillaSound
import org.anti_ad.mc.sbt.common.vanilla.glue.__glue_vanillaSound


fun initVanillaSound() {
    __glue_vanillaSound = VanillaSound
}

object VanillaSound: IVanillaSound {

    override fun playClick() {
        Vanilla.soundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK,
                                                                   1.0f))
    }

}