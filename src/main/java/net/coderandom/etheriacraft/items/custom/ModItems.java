package net.coderandom.etheriacraft.items.custom;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.coderandom.etheriacraft.items.custom.armor.CustomArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final Item.Properties item = new Item.Properties();
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
    public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
        () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> METAL_DOWSING_ROD = ITEMS.register("metal_dowsing_rod",
            MetalDowsingRodItem::new);
    public static final RegistryObject<Item> GEM_DOWSING_ROD = ITEMS.register("gem_dowsing_rod",
            GemDowsingRodItem::new);

    // Essence
    public static final RegistryObject<Item> EMERALD_ESSENCE = ITEMS.register("emerald_essence",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    // Food
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoods.TOMATO)));
    public static final RegistryObject<Item> CHILLI = ITEMS.register("chilli",
            () -> new Item(new Item.Properties().food(ModFoods.CHILLI)));
    public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce",
            () -> new Item(new Item.Properties().food(ModFoods.LETTUCE)));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(ModFoods.CORN)));
    // Seeds
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHILLI_SEEDS = ITEMS.register("chilli_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CHILLI_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LETTUCE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_ESSENCE_SEEDS = ITEMS.register("emerald_essence_seeds",
            () -> new ItemNameBlockItem(ModBlocks.EMERALD_ESSENCE_CROP.get(), new Item.Properties()));

    //Scrolls
    public static final RegistryObject<Item> BLANK_SCROLL = ITEMS.register("blank_scroll",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> COMBUSTION_SCROLL = ITEMS.register("combustion_scroll",
            () -> new CombustionScrollItem(new Item.Properties().rarity(Rarity.COMMON), 64000)); // x4 coal block burntime

    // Armor
    public static final RegistryObject<Item> TURTLE_CHESTPLATE = ITEMS.register("turtle_chestplate",
            () -> new CustomArmorItem(ArmorMaterials.TURTLE, ArmorItem.Type.CHESTPLATE, item.rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TURTLE_LEGGINGS = ITEMS.register("turtle_leggings",
            () -> new CustomArmorItem(ArmorMaterials.TURTLE, ArmorItem.Type.LEGGINGS, item.rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TURTLE_BOOTS = ITEMS.register("turtle_boots",
            () -> new CustomArmorItem(ArmorMaterials.TURTLE, ArmorItem.Type.BOOTS, item.rarity(Rarity.RARE)));



    //TODO Fix portable crafting table
//    public static final RegistryObject<Item> PORTABLE_CRAFTING_TABLE = ITEMS.register("portable_crafting_table",
//            PortableCraftingTableItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
