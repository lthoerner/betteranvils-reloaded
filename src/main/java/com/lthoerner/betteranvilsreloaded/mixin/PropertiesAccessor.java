package com.lthoerner.betteranvilsreloaded.mixin;

import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Enchantment.Properties.class)
public interface PropertiesAccessor {
    @Accessor("maxLevel")
    int getMaxLevel();

    @Mutable
    @Accessor("maxLevel")
    void setMaxLevel(int maxLevel);
}
