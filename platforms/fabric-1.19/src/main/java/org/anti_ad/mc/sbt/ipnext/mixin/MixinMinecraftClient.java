package org.anti_ad.mc.sbt.ipnext.mixin;

import net.minecraft.client.MinecraftClient;
import org.anti_ad.mc.sbt.ipnext.config.Tweaks;
import org.anti_ad.mc.sbt.ipnext.event.ClientInitHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * MixinMinecraftClient
 */
@Mixin(MinecraftClient.class)
public abstract class MixinMinecraftClient {
    @Shadow
    private int itemUseCooldown;

    @Inject(at = @At("HEAD"), method = "tick()V")
    public void tick(CallbackInfo info) {
        ClientInitHandler.INSTANCE.onTickPre();
        if (this.itemUseCooldown > 0 && Tweaks.INSTANCE.getDISABLE_ITEM_USE_COOLDOWN().getBooleanValue()) {
            this.itemUseCooldown = 0;
        }
    }
}
