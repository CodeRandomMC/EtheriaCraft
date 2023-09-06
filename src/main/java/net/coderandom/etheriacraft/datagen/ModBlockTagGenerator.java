package net.coderandom.etheriacraft.datagen;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.coderandom.etheriacraft.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EtheriaCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.END_ORES)
                .add(
                        ModBlocks.END_GOLD_ORE.get(),
                        ModBlocks.END_SILVER_ORE.get(),
                        ModBlocks.ENDERITE_SCRAP_ORE.get()
                );

        this.tag(ModTags.Blocks.ORES_SILVER)
                .add(
                        ModBlocks.SILVER_ORE.get(),
                        ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                        ModBlocks.NETHER_SILVER_ORE.get(),
                        ModBlocks.END_SILVER_ORE.get()
                );


        this.tag(ModTags.Blocks.ORES_GEM)
                .addTag(Tags.Blocks.ORES_COAL)
                .addTag(Tags.Blocks.ORES_LAPIS)
                .addTag(Tags.Blocks.ORES_REDSTONE)
                .addTag(Tags.Blocks.ORES_DIAMOND)
                .addTag(Tags.Blocks.ORES_EMERALD)
                .addTag(Tags.Blocks.ORES_QUARTZ)
                .addTag(Tags.Blocks.ORES_NETHERITE_SCRAP)
                .add(
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.TOPAZ_ORE.get(),
                        ModBlocks.ENDERITE_SCRAP_ORE.get()
                );


        this.tag(ModTags.Blocks.ORES_METAL)
                .addTag(ModTags.Blocks.ORES_SILVER)
                .addTag(Tags.Blocks.ORES_COPPER)
                .addTag(Tags.Blocks.ORES_GOLD)
                .addTag(Tags.Blocks.ORES_IRON)
                .add(
                        ModBlocks.END_GOLD_ORE.get()
                );

        this.tag(ModTags.Blocks.MOSSY_BRICK)
                .add(
                        ModBlocks.MOSSY_BRICK.get(),
                        ModBlocks.MOSSY_BRICK_SLAB.get(),
                        ModBlocks.MOSSY_BRICK_STAIRS.get(),
                        ModBlocks.MOSSY_BRICK_WALL.get(),
                        ModBlocks.MOSSY_BRICK_PRESSURE_PLATE.get()
                );

        this.tag(ModTags.Blocks.GILDED_BLACKSTONE_BRICK)
                .add(
                        ModBlocks.GILDED_BLACKSTONE_BRICK.get(),
                        ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get(),
                        ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS.get(),
                        ModBlocks.GILDED_BLACKSTONE_BRICK_WALL.get()
                );

        this.tag(ModTags.Blocks.INFUSED_END_STONE_BRICK)
                .add(
                        ModBlocks.INFUSED_END_BRICK.get(),
                        ModBlocks.INFUSED_END_BRICK_SLAB.get(),
                        ModBlocks.INFUSED_END_BRICK_STAIRS.get(),
                        ModBlocks.INFUSED_END_BRICK_WALL.get()
                );

        this.tag(ModTags.Blocks.ENRICHED_NETHER_BRICK)
                .add(
                        ModBlocks.ENRICHED_NETHER_BRICK.get(),
                        ModBlocks.ENRICHED_NETHER_BRICK_SLAB.get(),
                        ModBlocks.ENRICHED_NETHER_BRICK_STAIRS.get(),
                        ModBlocks.ENRICHED_NETHER_BRICK_WALL.get(),
                        ModBlocks.ENRICHED_NETHER_BRICK_FENCE.get(),
                        ModBlocks.ENRICHED_NETHER_BRICK_FENCE_GATE.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK_STAIRS.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK_WALL.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE_GATE.get()
                );

        this.tag(ModTags.Blocks.PACKED_ICE)
                .add(
                        Blocks.PACKED_ICE,
                        ModBlocks.PACKED_ICE_SLAB.get(),
                        ModBlocks.PACKED_ICE_SLAB.get(),
                        ModBlocks.PACKED_ICE_WALL.get()
                );

        this.tag(ModTags.Blocks.CHANNELLED_STONEBRICK)
                .add(
                        ModBlocks.CHANNELLED_STONEBRICK.get(),
                        ModBlocks.CHANNELLED_STONEBRICK_STAIRS.get(),
                        ModBlocks.CHANNELLED_STONEBRICK_SLAB.get(),
                        ModBlocks.CHANNELLED_STONEBRICK_WALL.get(),
                        ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get(),
                        ModBlocks.CHANNELLED_MOSSY_STONEBRICK_STAIRS.get(),
                        ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB.get(),
                        ModBlocks.CHANNELLED_MOSSY_STONEBRICK_WALL.get(),
                        ModBlocks.CHANNELLED_STONEBRICK_CARVED.get(),
                        ModBlocks.CHANNELLED_STONEBRICK_CARVED_STAIRS.get(),
                        ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB.get(),
                        ModBlocks.CHANNELLED_STONEBRICK_CARVED_WALL.get()
                );


        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL);

        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .addTag(ModTags.Blocks.MOSSY_BRICK)
                .addTag(ModTags.Blocks.INFUSED_END_STONE_BRICK)
                .addTag(ModTags.Blocks.ENRICHED_NETHER_BRICK)
                .addTag(ModTags.Blocks.PACKED_ICE)
                .addTag(ModTags.Blocks.CHANNELLED_STONEBRICK)
                .add(
                        ModBlocks.QUICK_SAND.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(
                        ModTags.Blocks.ORES_SILVER
                )
                .add(
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.TOPAZ_ORE.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.TOPAZ_BLOCK.get(),
                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.TOPAZ_BLOCK.get()
                );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .addTag(ModTags.Blocks.GILDED_BLACKSTONE_BRICK);


        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .addTag(ModTags.Blocks.END_ORES);
//                .add(
//                        ModBlocks.END_GOLD_ORE.get(),
//                        ModBlocks.END_SILVER_ORE.get()
//                );

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(ModTags.Blocks.ORES_SILVER)
                .addTag(ModTags.Blocks.END_ORES)
                .addTag(ModTags.Blocks.MOSSY_BRICK)
                .addTag(ModTags.Blocks.GILDED_BLACKSTONE_BRICK)
                .addTag(ModTags.Blocks.INFUSED_END_STONE_BRICK)
                .addTag(ModTags.Blocks.ENRICHED_NETHER_BRICK)
                .addTag(ModTags.Blocks.PACKED_ICE)
                .addTag(ModTags.Blocks.CHANNELLED_STONEBRICK)
                .add(
                        ModBlocks.SILVER_BLOCK.get(),
                        ModBlocks.RAW_SILVER_BLOCK.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.TOPAZ_ORE.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.TOPAZ_BLOCK.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        ModBlocks.QUICK_SAND.get()
                );

        this.tag(BlockTags.FENCES)
                .add(
                        ModBlocks.ENRICHED_NETHER_BRICK_FENCE.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE.get()
                );

        this.tag(BlockTags.FENCE_GATES)
                .add(
                        ModBlocks.ENRICHED_NETHER_BRICK_FENCE_GATE.get(),
                        ModBlocks.ENRICHED_RED_NETHER_BRICK_FENCE_GATE.get()
                );

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.MOSSY_BRICK_WALL.get())
                .add(ModBlocks.GILDED_BLACKSTONE_BRICK_WALL.get())
                .add(ModBlocks.INFUSED_END_BRICK_WALL.get())
                .add(ModBlocks.ENRICHED_NETHER_BRICK_WALL.get())
                .add(ModBlocks.ENRICHED_RED_NETHER_BRICK_WALL.get())
                .add(ModBlocks.PACKED_ICE_WALL.get())
                .add(ModBlocks.CHANNELLED_STONEBRICK_WALL.get())
                .add(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_WALL.get())
                .add(ModBlocks.CHANNELLED_STONEBRICK_CARVED_WALL.get());

        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.MOSSY_BRICK_STAIRS.get())
                .add(ModBlocks.GILDED_BLACKSTONE_BRICK_STAIRS.get())
                .add(ModBlocks.INFUSED_END_BRICK_STAIRS.get())
                .add(ModBlocks.ENRICHED_NETHER_BRICK_STAIRS.get())
                .add(ModBlocks.ENRICHED_RED_NETHER_BRICK_STAIRS.get())
                .add(ModBlocks.PACKED_ICE_STAIRS.get())
                .add(ModBlocks.CHANNELLED_STONEBRICK_STAIRS.get())
                .add(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_STAIRS.get())
                .add(ModBlocks.CHANNELLED_STONEBRICK_CARVED_STAIRS.get());;

        this.tag(BlockTags.SLABS)
                .add(ModBlocks.MOSSY_BRICK_SLAB.get())
                .add(ModBlocks.GILDED_BLACKSTONE_BRICK_SLAB.get())
                .add(ModBlocks.INFUSED_END_BRICK_SLAB.get())
                .add(ModBlocks.ENRICHED_NETHER_BRICK_SLAB.get())
                .add(ModBlocks.ENRICHED_RED_NETHER_BRICK_SLAB.get())
                .add(ModBlocks.PACKED_ICE_SLAB.get())
                .add(ModBlocks.CHANNELLED_STONEBRICK_SLAB.get())
                .add(ModBlocks.CHANNELLED_MOSSY_STONEBRICK_SLAB.get())
                .add(ModBlocks.CHANNELLED_STONEBRICK_CARVED_SLAB.get());;

        this.tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.MOSSY_BRICK_PRESSURE_PLATE.get());

        this.tag(BlockTags.DOORS);

        this.tag(BlockTags.TRAPDOORS);
    }
}
