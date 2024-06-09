package com.lthoerner.betteranvilsreloaded.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.lthoerner.betteranvilsreloaded.BetterAnvilsReloaded.CONFIG;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilLogicMixin {
    @ModifyExpressionValue(
            method = "method_24922(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V",
            at = @At(value = "INVOKE", target = "net/minecraft/util/math/random/Random.nextFloat ()F")
    )
    private static float preventAnvilDamage(float original) {
        // Each anvil operation is given a 12% chance to damage the anvil, and the way this is checked is in the typical
        // "random float is less than <chance>" fashion, so anything over 0.12 would work here.
        if (CONFIG.disableDamageFromRepairs()) return 1F;
        else return original;
    }
}
