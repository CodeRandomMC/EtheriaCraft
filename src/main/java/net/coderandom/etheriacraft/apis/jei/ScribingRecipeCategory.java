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

package net.coderandom.etheriacraft.apis.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.coderandom.etheriacraft.init.ModBlocks;
import net.coderandom.etheriacraft.recipes.ScribingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ScribingRecipeCategory implements IRecipeCategory<ScribingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation("etheria_craft", "scribing");
    public static final ResourceLocation TEXTURE = new ResourceLocation("etheria_craft",
            "textures/gui/scribing_table_jei.png");

    public static final RecipeType<ScribingRecipe> SCRIBING_RECIPE_TYPE =
            new RecipeType<>(UID, ScribingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ScribingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 83);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SCRIBING_TABLE.get()));
    }

    @Override
    public @NotNull RecipeType<ScribingRecipe> getRecipeType() {
        return SCRIBING_RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.etheria_craft.scribing_table");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull ScribingRecipe recipe, @NotNull IFocusGroup focuses) {
        List<Ingredient> ingredients = recipe.getIngredients();
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 35).addIngredients(ingredients.get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 79, 8).addIngredients(ingredients.get(1));

        if (ingredients.size() == 3) {
            builder.addSlot(RecipeIngredientRole.INPUT, 79, 62).addIngredients(ingredients.get(2));
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35).addItemStack(recipe.getResultItem(null));
    }
}
