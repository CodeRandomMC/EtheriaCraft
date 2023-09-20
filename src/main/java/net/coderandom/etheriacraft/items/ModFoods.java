package net.coderandom.etheriacraft.items;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CHILLI = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.15F)
            .fast()
            .build();
    public static final FoodProperties TOMATO = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.15F)
            .fast()
            .build();
    public static final FoodProperties LETTUCE = (new FoodProperties.Builder())
            .nutrition(2)
            .saturationMod(0.15F)
            .fast()
            .build();
    public static final FoodProperties CORN = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(0.3F)
            .fast()
            .build();
}
