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

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
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