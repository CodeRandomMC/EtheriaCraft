package net.coderandom.etheriacraft.datagen.loot;

import net.coderandom.etheriacraft.blocks.custom.crops.CornCropBlock;
import net.coderandom.etheriacraft.init.ModBlocks;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());

        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());

        this.dropSelf(ModBlocks.QUICK_SAND.get());
        this.dropSelf(ModBlocks.INFUSION_TABLE.get());

        this.dropSelf(ModBlocks.MOSSY_BRICK.get());
        this.dropSelf(ModBlocks.MOSSY_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.MOSSY_BRICK_WALL.get());
        this.dropSelf(ModBlocks.MOSSY_BRICK_PRESSURE_PLATE.get());
        this.add(ModBlocks.MOSSY_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MOSSY_BRICK_SLAB.get()));

        this.dropSelf(ModBlocks.GILDED_BLACKSTONE_BRICK.get());
        this.dropSelf(ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.GILDED_BLACKSTONE_BRICK_WALL.get());
        this.add(ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get()));

        this.dropSelf(ModBlocks.INFUSED_END_BRICK.get());
        this.dropSelf(ModBlocks.INFUSED_END_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.INFUSED_END_BRICK_WALL.get());
        this.add(ModBlocks.INFUSED_END_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.INFUSED_END_BRICK_SLAB.get()));

        this.dropSelf(ModBlocks.ENRICHED_NETHER_BRICK.get());
        this.dropSelf(ModBlocks.ENRICHED_NETHER_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ENRICHED_NETHER_BRICK_WALL.get());
        this.add(ModBlocks.ENRICHED_NETHER_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ENRICHED_NETHER_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.ENRICHED_NETHER_BRICK_FENCE.get());
        this.dropSelf(ModBlocks.ENRICHED_NETHER_BRICK_FENCE_GATE.get());

        this.dropSelf(ModBlocks.ENRICHED_RED_NETHER_BRICK.get());
        this.dropSelf(ModBlocks.ENRICHED_RED_NETHER_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.ENRICHED_RED_NETHER_BRICK_WALL.get());
        this.add(ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE.get());
        this.dropSelf(ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE_GATE.get());

        this.dropSelf(ModBlocks.PACKED_ICE_STAIRS.get());
        this.dropSelf(ModBlocks.PACKED_ICE_WALL.get());
        this.add(ModBlocks.PACKED_ICE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PACKED_ICE_SLAB.get()));

        this.dropSelf(ModBlocks.CHANNELLED_STONEBRICK.get());
        this.dropSelf(ModBlocks.CHANNELLED_STONEBRICK_STAIRS.get());
        this.dropSelf(ModBlocks.CHANNELLED_STONEBRICK_WALL.get());
        this.add(ModBlocks.CHANNELLED_STONEBRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHANNELLED_STONEBRICK_SLAB.get()));

        this.dropSelf(ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get());
        this.dropSelf(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_STAIRS.get());
        this.dropSelf(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_WALL.get());
        this.add(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB.get()));

        this.dropSelf(ModBlocks.CHANNELLED_STONEBRICK_CARVED.get());
        this.dropSelf(ModBlocks.CHANNELLED_STONEBRICK_CARVED_STAIRS.get());
        this.dropSelf(ModBlocks.CHANNELLED_STONEBRICK_CARVED_WALL.get());
        this.add(ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB.get()));

        // Ore
        this.add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get(), 1.00F, 3.00F));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get(), 2.00F, 6.00F));
        this.add(ModBlocks.NETHER_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.NETHER_SILVER_ORE.get(), ModItems.SILVER_NUGGET.get(), 2.00F, 6.00F));
        this.add(ModBlocks.END_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.END_SILVER_ORE.get(), ModItems.SILVER_INGOT.get(), 1.00F, 2.00F));
        this.add(ModBlocks.END_GOLD_ORE.get(),
                block -> createOreDrops(ModBlocks.END_GOLD_ORE.get(), Items.GOLD_INGOT, 1.00F, 2.00F));
        this.add(ModBlocks.ENDERITE_SCRAP_ORE.get(),
                block -> createOreDrops(ModBlocks.ENDERITE_SCRAP_ORE.get(), ModItems.ENDERITE_SCRAP.get(), 1.00F, 2.00F));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrops(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get(), 2.00F, 6.00F));
        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get(), 1.00F, 3.00F));
        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get(), 1.00F, 3.00F));
        this.add(ModBlocks.TOPAZ_ORE.get(),
                block -> createOreDrops(ModBlocks.TOPAZ_ORE.get(), ModItems.TOPAZ.get(), 1.00F, 3.00F));

        // Crops
        LootItemCondition.Builder tomatoLootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7));
        this.add(ModBlocks.TOMATO_CROP.get(), createCropDrops(ModBlocks.TOMATO_CROP.get(), ModItems.TOMATO.get(),
                ModItems.TOMATO_SEEDS.get(), tomatoLootitemcondition$builder));

        LootItemCondition.Builder chilliLootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CHILLI_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7));
        this.add(ModBlocks.CHILLI_CROP.get(), createCropDrops(ModBlocks.CHILLI_CROP.get(), ModItems.CHILLI.get(),
                ModItems.CHILLI_SEEDS.get(), chilliLootitemcondition$builder));

        LootItemCondition.Builder lettuceLootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LETTUCE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_3, 3));
        this.add(ModBlocks.LETTUCE_CROP.get(), createCropDrops(ModBlocks.LETTUCE_CROP.get(), ModItems.LETTUCE.get(),
                ModItems.LETTUCE_SEEDS.get(), lettuceLootitemcondition$builder));

        LootItemCondition.Builder cornLootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8)));
        this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(),
                ModItems.CORN_SEEDS.get(), cornLootitemcondition$builder));

        LootItemCondition.Builder EmeraldEssenceLootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.EMERALD_ESSENCE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7));
        this.add(ModBlocks.EMERALD_ESSENCE_CROP.get(), createCropDrops(ModBlocks.EMERALD_ESSENCE_CROP.get(), ModItems.EMERALD_ESSENCE.get(),
                ModItems.EMERALD_ESSENCE_SEEDS.get(), EmeraldEssenceLootitemcondition$builder));
    }

    protected LootTable.Builder createOreDrops(Block block, Item item, Float min, Float max) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
