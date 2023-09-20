package net.coderandom.etheriacraft.init.itemsInit;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.items.custom.GemDowsingRodItem;
import net.coderandom.etheriacraft.items.custom.MetalDowsingRodItem;
import net.coderandom.etheriacraft.items.custom.base_items.ExcavatorItem;
import net.coderandom.etheriacraft.items.custom.base_items.HarvesterItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModTools {
    public static final Item.Properties item = new Item.Properties();
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EtheriaCraft.MOD_ID);

    public static final RegistryObject<Item> METAL_DOWSING_ROD = ITEMS.register("metal_dowsing_rod",
            MetalDowsingRodItem::new);
    public static final RegistryObject<Item> GEM_DOWSING_ROD = ITEMS.register("gem_dowsing_rod",
            GemDowsingRodItem::new);

    //Enderite Tools
//    public static final RegistryObject<Item> ENDERITE_SWORD =
//            registerSword("enderite_sword", ModToolTiers.ENDERITE, 3F, -2.4F, Rarity.RARE);
//    public static final RegistryObject<Item> ENDERITE_AXE =
//            registerAxe("enderite_axe", ModToolTiers.ENDERITE, 5.5F, -2.8F, Rarity.RARE);
//    public static final RegistryObject<Item> ENDERITE_HOE =
//            registerHoe("enderite_hoe", ModToolTiers.ENDERITE, -4, Rarity.RARE);
//    public static final RegistryObject<Item> ENDERITE_PICKAXE =
//            registerPickaxe("enderite_pickaxe", ModToolTiers.ENDERITE, Rarity.RARE);
//    public static final RegistryObject<Item> ENDERITE_SHOVEL =
//            registerShovel("enderite_shovel", ModToolTiers.ENDERITE, Rarity.RARE);

    //Etherian Tools
    public static final RegistryObject<Item> ETHERIAN_SWORD =
            registerSword("etherian_sword", ModToolTiers.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_AXE =
            registerAxe("etherian_axe", ModToolTiers.ETHERIAN, 6.0F, -2.8F, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_HOE =
            registerHoe("etherian_hoe", ModToolTiers.ETHERIAN, -5, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_PICKAXE =
            registerPickaxe("etherian_pickaxe", ModToolTiers.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_SHOVEL =
            registerShovel("etherian_shovel", ModToolTiers.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_EXCAVATOR =
            registerExcavator("etherian_excavator", ModToolTiers.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_HARVESTER =
            registerHarvester("etherian_harvester", ModToolTiers.ETHERIAN, Rarity.EPIC);


    //Register functions
    //Swords
    private static RegistryObject<Item> registerSword(final String name, Tier tier, Rarity rarity) {
        return ITEMS.register(name,
                () -> new SwordItem(
                        tier,
                        3, -2.4F, new Item.Properties().rarity(rarity)));
    }

    //Axes
    private static RegistryObject<Item> registerAxe(final String name, Tier tier, float damageModifier, float speedModifier, Rarity rarity) {
        return ITEMS.register(name,
                () -> new AxeItem(
                        tier,
                        damageModifier, speedModifier, new Item.Properties().rarity(rarity)));
    }

    //Pickaxes
    private static RegistryObject<Item> registerPickaxe(final String name, Tier tier, Rarity rarity) {
        return ITEMS.register(name,
                () -> new PickaxeItem(
                        tier,
                        1, -2.8F, new Item.Properties().rarity(rarity)));
    }

    //Shovels
    private static RegistryObject<Item> registerShovel(final String name, Tier tier, Rarity rarity) {
        return ITEMS.register(name,
                () -> new ShovelItem(
                        tier,
                        1.5F, -3.0F, new Item.Properties().rarity(rarity)));
    }

    //Hoes
    private static RegistryObject<Item> registerHoe(final String name, Tier tier, int damageModifier, Rarity rarity) {
        return ITEMS.register(name,
                () -> new HoeItem(
                        tier,
                        damageModifier, 0.0F, new Item.Properties().rarity(rarity)));
    }

    //Excavators
    private static RegistryObject<Item> registerExcavator(final String name, Tier tier, Rarity rarity) {
        return ITEMS.register(name,
                () -> new ExcavatorItem(
                        tier,
                        1.25F, -2.9F, new Item.Properties().rarity(rarity)));
    }

    //Harvester
    private static RegistryObject<Item> registerHarvester(final String name, Tier tier, Rarity rarity) {
        return ITEMS.register(name,
                () -> new HarvesterItem(
                        tier,
                        0.0F, 0.0F, new Item.Properties().rarity(rarity)));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
