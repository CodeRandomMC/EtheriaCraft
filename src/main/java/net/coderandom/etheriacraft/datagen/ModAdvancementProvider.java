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
import net.coderandom.etheriacraft.init.itemsInit.ModTools;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.ETHERIAN_INGOT.get()),
                        Component.literal("MC Course"), Component.literal("The Journey"),
                        new ResourceLocation(EtheriaCraft.MOD_ID, "textures/block/infused_end_stone_brick.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_dirt", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIRT))
                .save(saver, new ResourceLocation(EtheriaCraft.MOD_ID, "etheria_craft"), existingFileHelper);


        Advancement metalDowsingRod = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModTools.METAL_DOWSING_ROD.get()),
                        Component.literal("Metal Detector"), Component.literal("Batteries not included! (Actually doesn't need batteries)"),
                        null, FrameType.TASK,
                        true, true, false))
                .parent(rootAdvancement)
                .addCriterion("has_metal_detector", InventoryChangeTrigger.TriggerInstance.hasItems(ModTools.METAL_DOWSING_ROD.get()))
                .save(saver, new ResourceLocation(EtheriaCraft.MOD_ID, "metal_dowsing_rod"), existingFileHelper);


    }
}
