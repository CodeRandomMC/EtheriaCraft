package net.coderandom.etheriacraft.items.custom;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EtheriaCraft.MOD_ID);
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> METAL_DOWSING_ROD = ITEMS.register("metal_dowsing_rod",
            MetalDowsingRodItem::new);
    public static final RegistryObject<Item> GEM_DOWSING_ROD = ITEMS.register("gem_dowsing_rod",
            GemDowsingRodItem::new);

    // Food
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoods.TOMATO)));
    public static final RegistryObject<Item> CHILLI = ITEMS.register("chilli",
            () -> new Item(new Item.Properties().food(ModFoods.CHILLI)));


    public static final RegistryObject<Item> BLANK_SCROLL = ITEMS.register("blank_scroll",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMBUSTION_SCROLL = ITEMS.register("combustion_scroll",
            () -> new CombustionScrollItem(new Item.Properties().rarity(Rarity.COMMON), 64000)); // x4 coal block burntime




    //TODO Fix portable crafting table
//    public static final RegistryObject<Item> PORTABLE_CRAFTING_TABLE = ITEMS.register("portable_crafting_table",
//            PortableCraftingTableItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
