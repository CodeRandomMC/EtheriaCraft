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

package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.coderandom.etheriacraft.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, EtheriaCraft.MOD_ID);
    }

    @Override
    protected void start() {
//        add("corn_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
//                LootItemRandomChanceCondition.randomChance(0.35f).build()},
//                ModItems.CORN_SEEDS.get()));

        add("corn_seeds_from_sniffer", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ModItems.CORN_SEEDS.get()));

        add("lettuce_seeds_from_sniffer", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ModItems.LETTUCE_SEEDS.get()));

        add("tomato_seeds_from_sniffer", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ModItems.TOMATO_SEEDS.get()));

        add("chilli_seeds_from_sniffer", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ModItems.CHILLI_SEEDS.get()));
    }
}