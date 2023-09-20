package net.coderandom.etheriacraft.init.itemsInit;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ENDERITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2561, 10.0F, 4.5F, 22,
                    ModTags.Blocks.NEEDS_ENDERITE_TOOL, () -> Ingredient.of(ModItems.ENDERITE_INGOT.get())),
            new ResourceLocation(EtheriaCraft.MOD_ID, "enderite"), List.of(Tiers.NETHERITE), List.of()
    );

    public static final Tier ETHERIAN = TierSortingRegistry.registerTier(
            new ForgeTier(6, 3122, 11f, 5f, 26,
                    ModTags.Blocks.NEEDS_ETHERIAN_TOOL, () -> Ingredient.of(ModItems.ETHERIAN_INGOT.get())),
            new ResourceLocation(EtheriaCraft.MOD_ID, "etherian"), List.of(ModToolTiers.ENDERITE), List.of()
    );
}
