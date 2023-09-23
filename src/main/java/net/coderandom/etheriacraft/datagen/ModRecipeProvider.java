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
import net.coderandom.etheriacraft.init.ModBlocks;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.coderandom.etheriacraft.init.itemsInit.ModTools;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static Consumer<FinishedRecipe> writer;
    public static final List<ItemLike> SILVER_SMELTABLES = List.of(
            ModItems.RAW_SILVER.get(),
            ModBlocks.SILVER_ORE.get(),
            ModBlocks.DEEPSLATE_SILVER_ORE.get(),
            ModBlocks.NETHER_SILVER_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        writer = pWriter;

        // Scribing Table Recipes
//        new ScribingRecipeBuilder(ModItems.BLANK_SCROLL.get(), ModItems.SILVER_INGOT.get(), 1)
//                .unlockedBy(getHasName(ModItems.BLANK_SCROLL.get()), has(ModItems.BLANK_SCROLL.get()))
//                .save(pWriter);

//        new ScribingRecipeBuilder(Items.PAPER, Items.COPPER_INGOT, 1)
//                .group("etheriacraft:scribing_table")
//                .unlockedBy("has_paper", has(Items.PAPER))
//                .save(pWriter);

//        new GemEmpoweringRecipeBuilder(Items.PAPER, Items.PAPER, 3)
//                .unlockedBy("has_paper", has(Items.PAPER)).save(pWriter);

        // Smelting and Cooking
        oreSmelting(writer, SILVER_SMELTABLES, ModItems.SILVER_INGOT.get(), 0.25f, 100, "silver");
        oreBlasting(pWriter, SILVER_SMELTABLES, ModItems.SILVER_INGOT.get(), 0.50f, 75, "silver");
        oreSmelting(pWriter, List.of(ModBlocks.ENDERITE_SCRAP_ORE.get()), ModItems.ENDERITE_SCRAP.get(), 1.5f, 150, "enderite");
        oreBlasting(pWriter, List.of(ModBlocks.ENDERITE_SCRAP_ORE.get()), ModItems.ENDERITE_SCRAP.get(), 2.0f, 100, "enderite");

        oreSmelting(pWriter, List.of(ModBlocks.SAPPHIRE_ORE.get()), ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreBlasting(pWriter, List.of(ModBlocks.SAPPHIRE_ORE.get()), ModItems.SAPPHIRE.get(), 0.50f, 75, "sapphire");
        oreSmelting(pWriter, List.of(ModBlocks.RUBY_ORE.get()), ModItems.RUBY.get(), 0.25f, 100, "ruby");
        oreBlasting(pWriter, List.of(ModBlocks.RUBY_ORE.get()), ModItems.RUBY.get(), 0.50f, 75, "ruby");
        oreSmelting(pWriter, List.of(ModBlocks.TOPAZ_ORE.get()), ModItems.TOPAZ.get(), 0.25f, 100, "topaz");
        oreBlasting(pWriter, List.of(ModBlocks.TOPAZ_ORE.get()), ModItems.TOPAZ.get(), 0.50f, 75, "topaz");

        // Ingredient Blocks reverse recipe also made
        solidBlockRecipe(ModBlocks.RAW_SILVER_BLOCK.get(), ModItems.RAW_SILVER.get());
        solidBlockRecipe(ModBlocks.SILVER_BLOCK.get(), ModItems.SILVER_INGOT.get());
        solidBlockRecipe(ModBlocks.SAPPHIRE_BLOCK.get(), ModItems.SAPPHIRE.get());
        solidBlockRecipe(ModBlocks.RUBY_BLOCK.get(), ModItems.RUBY.get());
        solidBlockRecipe(ModBlocks.TOPAZ_BLOCK.get(), ModItems.TOPAZ.get());

        // Nuggets handle ingot manually
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(), 9)
                .requires(ModItems.SILVER_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                .save(pWriter);

        // Tools and Utilities
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModTools.GEM_DOWSING_ROD.get(), 1)
                .requires(Items.STICK)
                .requires(ModItems.SAPPHIRE.get())
                .requires(ModItems.RUBY.get())
                .requires(ModItems.TOPAZ.get())
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModTools.METAL_DOWSING_ROD.get(), 1)
                .requires(Items.STICK)
                .requires(ModItems.RAW_SILVER.get())
                .requires(Items.RAW_GOLD)
                .requires(Items.RAW_COPPER)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);

        // Building Blocks
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK.get(), 1)
                .requires(Blocks.BRICKS)
                .requires(Items.VINE)
                .unlockedBy(getHasName(Blocks.BRICKS), has(Items.BRICKS))
                .save(pWriter);
        buildingSetRecipes(
                ModBlocks.MOSSY_BRICK_SLAB.get(),
                ModBlocks.MOSSY_BRICK_STAIRS.get(),
                ModBlocks.MOSSY_BRICK_WALL.get(),
                ModBlocks.MOSSY_BRICK.get()
        );
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.MOSSY_BRICK_PRESSURE_PLATE.get())
                .pattern("##")
                .define('#', ModBlocks.MOSSY_BRICK.get())
                .unlockedBy(getHasName(Blocks.BRICKS), has(ModBlocks.MOSSY_BRICK.get()))
                .save(pWriter);
        buildingSetRecipes(
                ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get(),
                ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS.get(),
                ModBlocks.GILDED_BLACKSTONE_BRICK_WALL.get(),
                ModBlocks.GILDED_BLACKSTONE_BRICK.get()
        );
        buildingSetRecipes(
                ModBlocks.INFUSED_END_BRICK_SLAB.get(),
                ModBlocks.INFUSED_END_BRICK_STAIRS.get(),
                ModBlocks.INFUSED_END_BRICK_WALL.get(),
                ModBlocks.INFUSED_END_BRICK.get()
        );
        buildingSetAndFenceRecipes(
                ModBlocks.ENRICHED_NETHER_BRICK_FENCE.get(),
                ModBlocks.ENRICHED_NETHER_BRICK_FENCE_GATE.get(),
                ModBlocks.ENRICHED_NETHER_BRICK_SLAB.get(),
                ModBlocks.ENRICHED_NETHER_BRICK_STAIRS.get(),
                ModBlocks.ENRICHED_NETHER_BRICK_WALL.get(),
                ModBlocks.ENRICHED_NETHER_BRICK.get()
        );
        buildingSetAndFenceRecipes(
                ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE.get(),
                ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE_GATE.get(),
                ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB.get(),
                ModBlocks.ENRICHED_RED_NETHER_BRICK_STAIRS.get(),
                ModBlocks.ENRICHED_RED_NETHER_BRICK_WALL.get(),
                ModBlocks.ENRICHED_RED_NETHER_BRICK.get()
        );
        buildingSetRecipes(
                ModBlocks.PACKED_ICE_SLAB.get(),
                ModBlocks.PACKED_ICE_STAIRS.get(),
                ModBlocks.PACKED_ICE_WALL.get(),
                Blocks.PACKED_ICE
        );
        buildingSetRecipes(
                ModBlocks.CHANNELLED_STONEBRICK_SLAB.get(),
                ModBlocks.CHANNELLED_STONEBRICK_STAIRS.get(),
                ModBlocks.CHANNELLED_STONEBRICK_WALL.get(),
                ModBlocks.CHANNELLED_STONEBRICK.get()
        );
        buildingSetRecipes(
                ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB.get(),
                ModBlocks.CHANNELLED_MOSSY_STONEBRICK_STAIRS.get(),
                ModBlocks.CHANNELLED_MOSSY_STONEBRICK_WALL.get(),
                ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get()
        );
        buildingSetRecipes(
                ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB.get(),
                ModBlocks.CHANNELLED_STONEBRICK_CARVED_STAIRS.get(),
                ModBlocks.CHANNELLED_STONEBRICK_CARVED_WALL.get(),
                ModBlocks.CHANNELLED_STONEBRICK_CARVED.get()
        );


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, RecipeCategory.MISC, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, RecipeCategory.MISC, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EtheriaCraft.MOD_ID + ':' + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void solidBlockRecipe(Block block, ItemLike recipeItem) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, block, 1)
                .requires(recipeItem, 9)
                .unlockedBy(getHasName(recipeItem), has(recipeItem))
                .save(writer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, recipeItem, 9)
                .requires(ModBlocks.TOPAZ_BLOCK.get())
                .unlockedBy(getHasName(block), has(block))
                .save(writer);
    }

    protected static void buildingSetAndFenceRecipes(Block fence, Block fenceGate, Block slab, Block stairs, Block wall, Block recipeBlock) {
        buildingSetRecipes(slab, stairs, wall, recipeBlock);
        fenceRecipe(fence, recipeBlock, slab);
        fenceGateRecipe(fenceGate, recipeBlock, slab);
    }

    protected static void buildingSetRecipes(Block slab, Block stairs, Block wall, ItemLike recipeItem) {
        slab(slab, recipeItem);
        stairs(stairs, recipeItem);
        wall(wall, recipeItem);
    }

    protected static void fenceRecipe(Block fence, Block solid, Block slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fence, 6)
                .pattern("#$#")
                .pattern("#$#")
                .define('#', solid)
                .define('$', slab)
                .unlockedBy(getHasName(solid), has(solid))
                .save(writer);
    }

    protected static void fenceGateRecipe(Block fenceGate, Block solid, Block slab) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fenceGate, 6)
                .pattern("#$#")
                .pattern("#$#")
                .define('$', solid)
                .define('#', slab)
                .unlockedBy(getHasName(solid), has(solid))
                .save(writer);
    }

    protected static void slab(Block slab, ItemLike recipeItem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6)
                .pattern("###")
                .define('#', recipeItem)
                .unlockedBy(getHasName(recipeItem), has(recipeItem))
                .save(writer);
    }

    protected static void stairs(Block stairs, ItemLike recipeItem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', recipeItem)
                .unlockedBy(getHasName(recipeItem), has(recipeItem))
                .save(writer);
    }

    protected static void wall(Block wall, ItemLike recipeItem) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, wall, 6)
                .pattern("###")
                .pattern("###")
                .define('#', recipeItem)
                .unlockedBy(getHasName(recipeItem), has(recipeItem))
                .save(writer);
    }
}
