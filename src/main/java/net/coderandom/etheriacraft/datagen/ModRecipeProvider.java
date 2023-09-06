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
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
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
        oreSmelting(pWriter, SILVER_SMELTABLES, ModItems.SILVER_INGOT.get(), 0.25f , 100, "silver");
        oreBlasting(pWriter, SILVER_SMELTABLES, ModItems.SILVER_INGOT.get(), 0.50f , 75, "silver");
        oreSmelting(pWriter, List.of(ModBlocks.ENDERITE_SCRAP_ORE.get()), ModItems.ENDERITE_SCRAP.get(), 1.5f , 150, "enderite");
        oreBlasting(pWriter, List.of(ModBlocks.ENDERITE_SCRAP_ORE.get()), ModItems.ENDERITE_SCRAP.get(), 2.0f , 100, "enderite");

        oreSmelting(pWriter, List.of(ModBlocks.SAPPHIRE_ORE.get()), ModItems.SAPPHIRE.get(), 0.25f , 100, "sapphire");
        oreBlasting(pWriter, List.of(ModBlocks.SAPPHIRE_ORE.get()), ModItems.SAPPHIRE.get(), 0.50f , 75, "sapphitre");
        oreSmelting(pWriter, List.of(ModBlocks.RUBY_ORE.get()), ModItems.RUBY.get(), 0.25f , 100, "ruby");
        oreBlasting(pWriter, List.of(ModBlocks.RUBY_ORE.get()), ModItems.RUBY.get(), 0.50f , 75, "ruby");
        oreSmelting(pWriter, List.of(ModBlocks.TOPAZ_ORE.get()), ModItems.TOPAZ.get(), 0.25f , 100, "topaz");
        oreBlasting(pWriter, List.of(ModBlocks.TOPAZ_ORE.get()), ModItems.TOPAZ.get(), 0.50f , 75, "topaz");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_SILVER_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_SILVER.get())
                .unlockedBy(getHasName(ModItems.RAW_SILVER.get()), has(ModItems.RAW_SILVER.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILVER_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SILVER_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get()));


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOPAZ_BLOCK.get())
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.GEM_DOWSING_ROD.get(), 1)
                .requires(Items.STICK)
                .requires(ModItems.SAPPHIRE.get())
                .requires(ModItems.RUBY.get())
                .requires(ModItems.TOPAZ.get())
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.METAL_DOWSING_ROD.get(), 1)
                .requires(Items.STICK)
                .requires(ModItems.RAW_SILVER.get())
                .requires(Items.RAW_GOLD)
                .requires(Items.RAW_COPPER)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK.get(), 1)
                .requires(Blocks.BRICKS)
                .requires(Items.VINE)
                .unlockedBy(getHasName(Blocks.BRICKS), has(Items.BRICKS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.MOSSY_BRICK.get())
            .unlockedBy(getHasName(Blocks.BRICKS), has(ModBlocks.MOSSY_BRICK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.MOSSY_BRICK.get())
                .unlockedBy(getHasName(Blocks.BRICKS), has(ModBlocks.MOSSY_BRICK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOSSY_BRICK_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.MOSSY_BRICK.get())
                .unlockedBy(getHasName(Blocks.BRICKS), has(ModBlocks.MOSSY_BRICK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.MOSSY_BRICK_PRESSURE_PLATE.get())
                .pattern("##")
                .define('#', ModBlocks.MOSSY_BRICK.get())
                .unlockedBy(getHasName(Blocks.BRICKS), has(ModBlocks.MOSSY_BRICK.get()))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_BLACKSTONE_BRICK.get(), 4)
                .requires(Blocks.GILDED_BLACKSTONE)
                .requires(Blocks.GILDED_BLACKSTONE)
                .requires(Blocks.GILDED_BLACKSTONE)
                .requires(Blocks.GILDED_BLACKSTONE)
                .unlockedBy(getHasName(Blocks.GILDED_BLACKSTONE), has(Items.GILDED_BLACKSTONE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.GILDED_BLACKSTONE_BRICK.get())
                .unlockedBy(getHasName(ModBlocks.GILDED_BLACKSTONE_BRICK.get()), has(ModBlocks.GILDED_BLACKSTONE_BRICK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.GILDED_BLACKSTONE_BRICK.get())
                .unlockedBy(getHasName(ModBlocks.GILDED_BLACKSTONE_BRICK.get()), has(ModBlocks.GILDED_BLACKSTONE_BRICK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GILDED_BLACKSTONE_BRICK_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.GILDED_BLACKSTONE_BRICK.get())
                .unlockedBy(getHasName(ModBlocks.GILDED_BLACKSTONE_BRICK.get()), has(ModBlocks.GILDED_BLACKSTONE_BRICK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFUSED_END_BRICK.get(), 4)
                .requires(Blocks.END_STONE_BRICKS, 4)
                .requires(Items.ENDER_PEARL)
                .unlockedBy(getHasName(Blocks.END_STONE), has(Items.END_STONE_BRICKS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFUSED_END_BRICK_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.INFUSED_END_BRICK.get())
                .unlockedBy(getHasName(ModBlocks.INFUSED_END_BRICK.get()), has(ModBlocks.INFUSED_END_BRICK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INFUSED_END_BRICK_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.INFUSED_END_BRICK.get())
                .unlockedBy(getHasName(ModBlocks.INFUSED_END_BRICK.get()), has(ModBlocks.INFUSED_END_BRICK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.INFUSED_END_BRICK_WALL.get(), 6)
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.INFUSED_END_BRICK.get())
                .unlockedBy(getHasName(ModBlocks.INFUSED_END_BRICK.get()), has(ModBlocks.INFUSED_END_BRICK.get()))
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
