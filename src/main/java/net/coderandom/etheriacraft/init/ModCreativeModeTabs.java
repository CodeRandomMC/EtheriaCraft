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

package net.coderandom.etheriacraft.init;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.init.itemsInit.ModArmor;
import net.coderandom.etheriacraft.init.itemsInit.ModFoods;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.coderandom.etheriacraft.init.itemsInit.ModTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EtheriaCraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_INGREDIENTS = CREATIVE_MODE_TABS.register("mod_ingredients_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("tab.mod_ingredients_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_SILVER.get());
                        output.accept(ModItems.SILVER_INGOT.get());
                        output.accept(ModItems.SILVER_NUGGET.get());

                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.TOPAZ.get());

                        output.accept(ModItems.ENDERITE_SCRAP.get());
                        output.accept(ModItems.ENDERITE_INGOT.get());

                        output.accept(ModItems.ETHERIAN_SCRAP.get());
                        output.accept(ModItems.ETHERIAN_INGOT.get());
                        // Essence
                        output.accept(ModItems.EMERALD_ESSENCE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MOD_TOOLSANDUTILITIES = CREATIVE_MODE_TABS.register("mod_tools_and_utilities_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModTools.GEM_DOWSING_ROD.get()))
                    .title(Component.translatable("tab.mod_tools_and_utilities_tab"))
                    .displayItems((parameters, output) -> {
                        //Etherian Tools
                        output.accept(ModTools.ETHERIAN_AXE.get());
                        output.accept(ModTools.ETHERIAN_PICKAXE.get());
                        output.accept(ModTools.ETHERIAN_SHOVEL.get());
                        output.accept(ModTools.ETHERIAN_HOE.get());
                        output.accept(ModTools.ETHERIAN_EXCAVATOR.get());
                        output.accept(ModTools.ETHERIAN_HARVESTER.get());
                        output.accept(ModTools.ETHERIAN_HAMMER.get());
                        //Dowsing Rods
                        output.accept(ModTools.METAL_DOWSING_ROD.get());
                        output.accept(ModTools.GEM_DOWSING_ROD.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOD_BLOCKS = CREATIVE_MODE_TABS.register("mod_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.SAPPHIRE_ORE.get()))
                    .title(Component.translatable("tab.mod_blocks_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.SILVER_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SILVER_ORE.get());
                        output.accept(ModBlocks.NETHER_SILVER_ORE.get());
                        output.accept(ModBlocks.END_SILVER_ORE.get());
                        output.accept(ModBlocks.END_GOLD_ORE.get());
                        output.accept(ModBlocks.ENDERITE_SCRAP_ORE.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.TOPAZ_ORE.get());

                        output.accept(ModBlocks.RAW_SILVER_BLOCK.get());
                        output.accept(ModBlocks.SILVER_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.TOPAZ_BLOCK.get());

                        output.accept(ModBlocks.MOSSY_BRICK.get());
                        output.accept(ModBlocks.MOSSY_BRICK_SLAB.get());
                        output.accept(ModBlocks.MOSSY_BRICK_STAIRS.get());
                        output.accept(ModBlocks.MOSSY_BRICK_WALL.get());

                        output.accept(ModBlocks.GILDED_BLACKSTONE_BRICK.get());
                        output.accept(ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GILDED_BLACKSTONE_BRICK_WALL.get());

                        output.accept(ModBlocks.INFUSED_END_BRICK.get());
                        output.accept(ModBlocks.INFUSED_END_BRICK_SLAB.get());
                        output.accept(ModBlocks.INFUSED_END_BRICK_STAIRS.get());
                        output.accept(ModBlocks.INFUSED_END_BRICK_WALL.get());

                        output.accept(ModBlocks.ENRICHED_NETHER_BRICK.get());
                        output.accept(ModBlocks.ENRICHED_NETHER_BRICK_SLAB.get());
                        output.accept(ModBlocks.ENRICHED_NETHER_BRICK_STAIRS.get());
                        output.accept(ModBlocks.ENRICHED_NETHER_BRICK_WALL.get());
                        output.accept(ModBlocks.ENRICHED_NETHER_BRICK_FENCE.get());
                        output.accept(ModBlocks.ENRICHED_NETHER_BRICK_FENCE_GATE.get());

                        output.accept(ModBlocks.ENRICHED_RED_NETHER_BRICK.get());
                        output.accept(ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB.get());
                        output.accept(ModBlocks.ENRICHED_RED_NETHER_BRICK_STAIRS.get());
                        output.accept(ModBlocks.ENRICHED_RED_NETHER_BRICK_WALL.get());
                        output.accept(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE.get());
                        output.accept(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE_GATE.get());

                        output.accept(ModBlocks.CHANNELLED_STONEBRICK.get());
                        output.accept(ModBlocks.CHANNELLED_STONEBRICK_SLAB.get());
                        output.accept(ModBlocks.CHANNELLED_STONEBRICK_STAIRS.get());
                        output.accept(ModBlocks.CHANNELLED_STONEBRICK_WALL.get());

                        output.accept(ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get());
                        output.accept(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB.get());
                        output.accept(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_STAIRS.get());
                        output.accept(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_WALL.get());

                        output.accept(ModBlocks.CHANNELLED_STONEBRICK_CARVED.get());
                        output.accept(ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB.get());
                        output.accept(ModBlocks.CHANNELLED_STONEBRICK_CARVED_STAIRS.get());
                        output.accept(ModBlocks.CHANNELLED_STONEBRICK_CARVED_WALL.get());

                        output.accept(ModBlocks.PACKED_ICE_SLAB.get());
                        output.accept(ModBlocks.PACKED_ICE_STAIRS.get());
                        output.accept(ModBlocks.PACKED_ICE_WALL.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOD_COMBAT = CREATIVE_MODE_TABS.register("mod_combat_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModArmor.ETHERIAN_HELMET.get()))
                    .title(Component.translatable("tab.mod_combat_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModTools.ETHERIAN_SWORD.get());
                        output.accept(ModArmor.ETHERIAN_HELMET.get());
                        output.accept(ModArmor.ETHERIAN_CHESTPLATE.get());
                        output.accept(ModArmor.ETHERIAN_LEGGINGS.get());
                        output.accept(ModArmor.ETHERIAN_BOOTS.get());
                        output.accept(ModArmor.ETHERIAN_HORSE_ARMOR.get());

                        output.accept(ModArmor.TURTLE_CHESTPLATE.get());
                        output.accept(ModArmor.TURTLE_LEGGINGS.get());
                        output.accept(ModArmor.TURTLE_BOOTS.get());

                        output.accept(ModArmor.VILLAGE_CHESTPLATE.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOD_MISC = CREATIVE_MODE_TABS.register("mod_misc_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModFoods.TOMATO.get()))
                    .title(Component.translatable("tab.mod_misc_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.INFUSION_TABLE.get());
                        output.accept(ModBlocks.MOSSY_BRICK_PRESSURE_PLATE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MOD_CROPS = CREATIVE_MODE_TABS.register("mod_crops",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModFoods.TOMATO.get()))
                    .title(Component.translatable("tab.mod_crops")) // Crops and Seeds
                    .displayItems((parameters, output) -> {
                        output.accept(ModFoods.TOMATO.get());
                        output.accept(ModItems.TOMATO_SEEDS.get());
                        output.accept(ModFoods.CHILLI.get());
                        output.accept(ModItems.CHILLI_SEEDS.get());
                        output.accept(ModFoods.LETTUCE.get());
                        output.accept(ModItems.LETTUCE_SEEDS.get());
                        output.accept(ModFoods.CORN.get());
                        output.accept(ModItems.CORN_SEEDS.get());
                        output.accept(ModItems.EMERALD_ESSENCE_SEEDS.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOD_SCROLLS = CREATIVE_MODE_TABS.register("mod_scrolls_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.COMBUSTION_SCROLL.get()))
                    .title(Component.translatable("tab.mod_scrolls_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BLANK_SCROLL.get());
                        output.accept(ModItems.COMBUSTION_SCROLL.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> MOD_MOBS = CREATIVE_MODE_TABS.register("mod_mobs_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BLACK_BEAR_SPAWN_EGG.get()))
                    .title(Component.translatable("tab.mod_mobs_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BLACK_BEAR_SPAWN_EGG.get());
                        output.accept(ModItems.BISON_SPAWN_EGG.get());
                        output.accept(ModItems.OSTRICH_SPAWN_EGG.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
