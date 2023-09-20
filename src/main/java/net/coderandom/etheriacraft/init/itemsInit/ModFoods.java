package net.coderandom.etheriacraft.init.itemsInit;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoods {
    public static final Item.Properties item = new Item.Properties();
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EtheriaCraft.MOD_ID);

    // Food
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)));
    public static final RegistryObject<Item> CHILLI = ITEMS.register("chilli",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHILLI)));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new Item(new Item.Properties().food(ModFoodProperties.LETTUCE)));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CORN)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

class ModFoodProperties {
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
