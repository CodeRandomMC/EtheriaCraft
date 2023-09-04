package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.coderandom.etheriacraft.items.custom.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> SILVER_SMELTABLES = List.of(
            ModItems.RAW_SILVER.get(),
            ModBlocks.SILVER_ORE.get(),
            ModBlocks.DEEPSLATE_SILVER_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, SILVER_SMELTABLES, ModItems.SILVER_INGOT.get(), 0.25f , 100, "silver");
        oreBlasting(pWriter, SILVER_SMELTABLES, ModItems.SILVER_INGOT.get(), 0.50f , 75, "silver");

        oreSmelting(pWriter, List.of(ModBlocks.SAPPHIRE_ORE.get()), ModItems.SAPPHIRE.get(), 0.25f , 75, "sapphire");
        oreBlasting(pWriter, List.of(ModBlocks.SAPPHIRE_ORE.get()), ModItems.SAPPHIRE.get(), 0.50f , 50, "sapphitre");
        oreSmelting(pWriter, List.of(ModBlocks.RUBY_ORE.get()), ModItems.RUBY.get(), 0.25f , 75, "ruby");
        oreBlasting(pWriter, List.of(ModBlocks.RUBY_ORE.get()), ModItems.RUBY.get(), 0.50f , 50, "ruby");
        oreSmelting(pWriter, List.of(ModBlocks.TOPAZ_ORE.get()), ModItems.TOPAZ.get(), 0.25f , 75, "topaz");
        oreBlasting(pWriter, List.of(ModBlocks.TOPAZ_ORE.get()), ModItems.TOPAZ.get(), 0.50f , 50, "topaz");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SILVER_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_SILVER.get())
                .unlockedBy(getHasName(ModItems.RAW_SILVER.get()), has(ModItems.RAW_SILVER.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SILVER_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILVER_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SILVER_NUGGET.get())
                .unlockedBy(getHasName(ModItems.SILVER_NUGGET.get()), has(ModItems.SILVER_NUGGET.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TOPAZ_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TOPAZ.get())
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_NUGGET.get(), 9)
                .requires(ModItems.SILVER_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_BLOCK.get()), has(ModBlocks.SILVER_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SILVER.get(), 9)
                .requires(ModBlocks.RAW_SILVER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_SILVER_BLOCK.get()), has(ModBlocks.RAW_SILVER_BLOCK.get()))
                .save(pWriter);


    ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TOPAZ.get(), 9)
                .requires(ModBlocks.TOPAZ_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TOPAZ_BLOCK.get()), has(ModBlocks.TOPAZ_BLOCK.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLANK_SCROLL.get(), 1)
                .requires(Items.PAPER)
                .requires(Items.STICK, 2)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GEM_DOWSING_ROD.get(), 1)
                .requires(Items.STICK)
                .requires(ModItems.SAPPHIRE.get())
                .requires(ModItems.RUBY.get())
                .requires(ModItems.TOPAZ.get())
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.METAL_DOWSING_ROD.get(), 1)
                .requires(Items.STICK)
                .requires(ModItems.RAW_SILVER.get())
                .requires(Items.RAW_GOLD)
                .requires(Items.RAW_COPPER)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, RecipeCategory.MISC, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, RecipeCategory.MISC, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), RecipeCategory.MISC, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, EtheriaCraft.MOD_ID + ':' + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
