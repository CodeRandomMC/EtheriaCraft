/*
 * // This code and associated files are protected by the Creative Commons Attribution-NonCommercial-NoDerivatives (CC BY-NC-ND) 4.0 International License.
 * // You are not allowed to use this code or associated files for commercial purposes.
 * // You may not modify or create derivative works based on this code.
 * // Attribution must be given to the original author (DARKJ0K3R/CodeRandom Studios) if you use this code for non-commercial purposes.
 *
 * Copyright (c) 2023. All rights reserved.
 *
 * For more details about the license, please visit:
 * https://creativecommons.org/licenses/by-nc-nd/4.0/legalcode
 *
 */

package net.coderandom.etheriacraft.init.itemsInit;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.items.custom.base_items.CustomArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModArmor {
    public static final Item.Properties item = new Item.Properties().stacksTo(1);
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
            registerHelmet("etherian_helmet", ModArmorMaterials.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_CHESTPLATE =
            registerChestplate("etherian_chestplate", ModArmorMaterials.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_LEGGINGS =
            registerLeggings("etherian_leggings", ModArmorMaterials.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_BOOTS =
            registerBoots("etherian_boots", ModArmorMaterials.ETHERIAN, Rarity.EPIC);
    public static final RegistryObject<Item> ETHERIAN_HORSE_ARMOR =
            registerHorseArmor("etherian_horse_armor", 12, "horse_armor_etherian.png", Rarity.EPIC);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> registerHelmet(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () ->
                new CustomArmorItem(material, ArmorItem.Type.HELMET, item.rarity(rarity)));
    }

    private static RegistryObject<Item> registerChestplate(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () ->
                new CustomArmorItem(material, ArmorItem.Type.CHESTPLATE, item.rarity(rarity)));
    }

    private static RegistryObject<Item> registerLeggings(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () ->
                new CustomArmorItem(material, ArmorItem.Type.LEGGINGS, item.rarity(rarity)));
    }

    private static RegistryObject<Item> registerBoots(String name, ArmorMaterial material, Rarity rarity) {
        return ITEMS.register(name, () ->
                new CustomArmorItem(material, ArmorItem.Type.BOOTS, item.rarity(rarity)));
    }

    private static RegistryObject<Item> registerHorseArmor(String name, int protection, String armorTextureFileName, Rarity rarity) {
        return ITEMS.register(name, () -> // Stacks to error
                new HorseArmorItem(protection,
                        new ResourceLocation(EtheriaCraft.MOD_ID, "textures/entity/horse/armor/" + armorTextureFileName),
                        item.rarity(rarity)));
    }
}
