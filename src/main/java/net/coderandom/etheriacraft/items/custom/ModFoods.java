package net.coderandom.etheriacraft.items.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHILLI = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(0.3F)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200), 0.1F)
            .build();
    public static final FoodProperties TOMATO = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(0.3F)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200), 0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200), 0.1F)
            .build();
}
