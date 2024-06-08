package com.lthoerner.betteranvilsreloaded.mixin;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.lthoerner.betteranvilsreloaded.BetterAnvilsReloaded.CONFIG;

@Mixin(Registry.class)
public interface RegistryMixin {
    @Inject(
            method = "register(Lnet/minecraft/registry/Registry;Lnet/minecraft/registry/RegistryKey;Ljava/lang/Object;)Ljava/lang/Object;",
            at = @At("HEAD")
    )
    private static <V, T extends V> void modifyMaxLevels(Registry<V> registry, RegistryKey<V> key, T entry, CallbackInfoReturnable<T> cir) {
        if (!CONFIG.enableLevelOverrides()) return;
        if (!registry.getKey().equals(RegistryKeys.ENCHANTMENT)) return;

        String enchantmentName = key.getValue().toString();
        switch (enchantmentName) {
            case "minecraft:protection":
                setEnchantmentMaxLevel(entry, CONFIG.protectionMaxLevel());
                break;
            case "minecraft:fire_protection":
                setEnchantmentMaxLevel(entry, CONFIG.fireProtectionMaxLevel());
                break;
            case "minecraft:feather_falling":
                setEnchantmentMaxLevel(entry, CONFIG.featherFallingMaxLevel());
                break;
            case "minecraft:blast_protection":
                setEnchantmentMaxLevel(entry, CONFIG.blastProtectionMaxLevel());
                break;
            case "minecraft:projectile_protection":
                setEnchantmentMaxLevel(entry, CONFIG.projectileProtectionMaxLevel());
                break;
            case "minecraft:respiration":
                setEnchantmentMaxLevel(entry, CONFIG.respirationMaxLevel());
                break;
            case "minecraft:aqua_affinity":
                setEnchantmentMaxLevel(entry, CONFIG.aquaAffinityMaxLevel());
                break;
            case "minecraft:thorns":
                setEnchantmentMaxLevel(entry, CONFIG.thornsMaxLevel());
                break;
            case "minecraft:depth_strider":
                setEnchantmentMaxLevel(entry, CONFIG.depthStriderMaxLevel());
                break;
            case "minecraft:frost_walker":
                setEnchantmentMaxLevel(entry, CONFIG.frostWalkerMaxLevel());
                break;
            case "minecraft:binding_curse":
                setEnchantmentMaxLevel(entry, CONFIG.bindingCurseMaxLevel());
                break;
            case "minecraft:soul_speed":
                setEnchantmentMaxLevel(entry, CONFIG.soulSpeedMaxLevel());
                break;
            case "minecraft:swift_sneak":
                setEnchantmentMaxLevel(entry, CONFIG.swiftSneakMaxLevel());
                break;
            case "minecraft:sharpness":
                setEnchantmentMaxLevel(entry, CONFIG.sharpnessMaxLevel());
                break;
            case "minecraft:smite":
                setEnchantmentMaxLevel(entry, CONFIG.smiteMaxLevel());
                break;
            case "minecraft:bane_of_arthropods":
                setEnchantmentMaxLevel(entry, CONFIG.baneOfArthropodsMaxLevel());
                break;
            case "minecraft:knockback":
                setEnchantmentMaxLevel(entry, CONFIG.knockbackMaxLevel());
                break;
            case "minecraft:fire_aspect":
                setEnchantmentMaxLevel(entry, CONFIG.fireAspectMaxLevel());
                break;
            case "minecraft:looting":
                setEnchantmentMaxLevel(entry, CONFIG.lootingMaxLevel());
                break;
            case "minecraft:sweeping_edge":
                setEnchantmentMaxLevel(entry, CONFIG.sweepingEdgeMaxLevel());
                break;
            case "minecraft:efficiency":
                setEnchantmentMaxLevel(entry, CONFIG.efficiencyMaxLevel());
                break;
            case "minecraft:silk_touch":
                setEnchantmentMaxLevel(entry, CONFIG.silkTouchMaxLevel());
                break;
            case "minecraft:unbreaking":
                setEnchantmentMaxLevel(entry, CONFIG.unbreakingMaxLevel());
                break;
            case "minecraft:fortune":
                setEnchantmentMaxLevel(entry, CONFIG.fortuneMaxLevel());
                break;
            case "minecraft:power":
                setEnchantmentMaxLevel(entry, CONFIG.powerMaxLevel());
                break;
            case "minecraft:punch":
                setEnchantmentMaxLevel(entry, CONFIG.punchMaxLevel());
                break;
            case "minecraft:flame":
                setEnchantmentMaxLevel(entry, CONFIG.flameMaxLevel());
                break;
            case "minecraft:infinity":
                setEnchantmentMaxLevel(entry, CONFIG.infinityMaxLevel());
                break;
            case "minecraft:luck_of_the_sea":
                setEnchantmentMaxLevel(entry, CONFIG.luckOfTheSeaMaxLevel());
                break;
            case "minecraft:lure":
                setEnchantmentMaxLevel(entry, CONFIG.lureMaxLevel());
                break;
            case "minecraft:loyalty":
                setEnchantmentMaxLevel(entry, CONFIG.loyaltyMaxLevel());
                break;
            case "minecraft:impaling":
                setEnchantmentMaxLevel(entry, CONFIG.impalingMaxLevel());
                break;
            case "minecraft:riptide":
                setEnchantmentMaxLevel(entry, CONFIG.riptideMaxLevel());
                break;
            case "minecraft:channeling":
                setEnchantmentMaxLevel(entry, CONFIG.channelingMaxLevel());
                break;
            case "minecraft:multishot":
                setEnchantmentMaxLevel(entry, CONFIG.multishotMaxLevel());
                break;
            case "minecraft:quick_charge":
                setEnchantmentMaxLevel(entry, CONFIG.quickChargeMaxLevel());
                break;
            case "minecraft:piercing":
                setEnchantmentMaxLevel(entry, CONFIG.piercingMaxLevel());
                break;
            case "minecraft:density":
                setEnchantmentMaxLevel(entry, CONFIG.densityMaxLevel());
                break;
            case "minecraft:breach":
                setEnchantmentMaxLevel(entry, CONFIG.breachMaxLevel());
                break;
            case "minecraft:wind_burst":
                setEnchantmentMaxLevel(entry, CONFIG.windBurstMaxLevel());
                break;
            case "minecraft:mending":
                setEnchantmentMaxLevel(entry, CONFIG.mendingMaxLevel());
                break;
            case "minecraft:vanishing_curse":
                setEnchantmentMaxLevel(entry, CONFIG.vanishingCurseMaxLevel());
                break;
            default:
                break;
        }
    }

    @Unique
    private static <V, T extends V> void setEnchantmentMaxLevel(T entry, int maxLevel) {
        ((PropertiesAccessor) (Object) ((EnchantmentAccessor) entry).getProperties()).setMaxLevel(maxLevel);
    }
}
