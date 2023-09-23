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

package net.coderandom.etheriacraft.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.coderandom.etheriacraft.EtheriaCraft;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class ScribingRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack result;

    public ScribingRecipe(ResourceLocation id, NonNullList<Ingredient> ingredients, ItemStack result) {
        this.id = id;
        this.ingredients = ingredients;
        this.result = result;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if (!pLevel.isClientSide && !pContainer.getItem(0).isEmpty()) {
            if (ingredients.size() == 2) {
                return (ingredients.get(1).test(pContainer.getItem(1)) && pContainer.getItem(2).isEmpty()) ||
                        (ingredients.get(1).test(pContainer.getItem(2)) && pContainer.getItem(1).isEmpty());
            }
            Ingredient ingredient1 = ingredients.get(1);
            Ingredient ingredient2 = ingredients.get(2);

            ItemStack item1 = pContainer.getItem(1);
            ItemStack item2 = pContainer.getItem(2);
            // Check if ingredients 1 and 2 match slots 1 and 2, or if they are swapped.
            return (ingredient1.test(item1) && ingredient2.test(item2)) ||
                    (ingredient1.test(item2) && ingredient2.test(item1));
        }
        return false; // Client-side check or no match, return false.
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return result.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return result.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    public static class Serializer implements RecipeSerializer<ScribingRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(EtheriaCraft.MOD_ID, "scribing");

        @Override
        public ScribingRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));

            JsonArray ingredientsArray = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> ingredients = NonNullList.withSize(ingredientsArray.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromJson(ingredientsArray.get(i)));
            }

            return new ScribingRecipe(id, ingredients, result);
        }

        @Override
        public ScribingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> ingredients = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                ingredients.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack result = buf.readItem();
            return new ScribingRecipe(id, ingredients, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, ScribingRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(null), false);
        }
    }

    public static class Type implements RecipeType<ScribingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "scribing";
    }
}
