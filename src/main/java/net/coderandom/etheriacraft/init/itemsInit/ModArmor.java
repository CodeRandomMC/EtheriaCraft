package net.coderandom.etheriacraft.init.itemsInit;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.items.custom.base_items.CustomArmorItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModArmor {
    public static final Item.Properties item = new Item.Properties();
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EtheriaCraft.MOD_ID);
    // Armor
    public static final RegistryObject<Item> TURTLE_CHESTPLATE =
            registerChestplate("turtle_chestplate", ArmorMaterials.TURTLE, Rarity.RARE);
    public static final RegistryObject<Item> TURTLE_LEGGINGS =
            registerLeggings("turtle_leggings", ArmorMaterials.TURTLE, Rarity.RARE);
    public static final RegistryObject<Item> TURTLE_BOOTS =
            registerBoots("turtle_boots", ArmorMaterials.TURTLE, Rarity.RARE);

    public static final RegistryObject<Item> VILLAGE_CHESTPLATE =
            registerChestplate("village_chestplate", ArmorMaterials.GOLD, Rarity.UNCOMMON);

    public static final RegistryObject<Item> ETHERIAN_HELMET =
            registerHelmet("etherian_helmet", ModArmorMaterials.ETHERIAN, Rarity.RARE);
    public static final RegistryObject<Item> ETHERIAN_CHESTPLATE =
            registerChestplate("etherian_chestplate", ModArmorMaterials.ETHERIAN, Rarity.RARE);
    public static final RegistryObject<Item> ETHERIAN_LEGGINGS =
            registerLeggings("etherian_leggings", ModArmorMaterials.ETHERIAN, Rarity.RARE);
    public static final RegistryObject<Item> ETHERIAN_BOOTS =
            registerBoots("etherian_boots", ModArmorMaterials.ETHERIAN, Rarity.RARE);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> registerHelmet(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () -> new CustomArmorItem(material, ArmorItem.Type.HELMET, item.rarity(rarity)));
    }

    private static RegistryObject<Item> registerChestplate(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () -> new CustomArmorItem(material, ArmorItem.Type.CHESTPLATE, item.rarity(rarity)));
    }

    private static RegistryObject<Item> registerLeggings(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () -> new CustomArmorItem(material, ArmorItem.Type.LEGGINGS, item.rarity(rarity)));
    }

    private static RegistryObject<Item> registerBoots(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () -> new CustomArmorItem(material, ArmorItem.Type.BOOTS, item.rarity(rarity)));
    }
}
