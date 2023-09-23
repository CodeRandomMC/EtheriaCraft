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

package net.coderandom.etheriacraft.init;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.custom.GemEmpoweringStationBlock;
import net.coderandom.etheriacraft.blocks.custom.InfusionTableBlock;
import net.coderandom.etheriacraft.blocks.custom.QuickSandBlock;
import net.coderandom.etheriacraft.blocks.custom.ScribingTableBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.CilliCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.CornCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.LettuceCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.TomatoCropBlock;
import net.coderandom.etheriacraft.blocks.custom.crops.essence_crops.EmeraldEssenceCropBlock;
import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EtheriaCraft.MOD_ID);
    public static final RegistryObject<Block> END_GOLD_ORE =
            dropExperienceBlock("end_gold_ore", Blocks.END_STONE, 6, 8);
    public static final RegistryObject<Block> END_SILVER_ORE =
            dropExperienceBlock("end_silver_ore", Blocks.END_STONE, 6, 8);
    public static final RegistryObject<Block> ENDERITE_SCRAP_ORE =
            dropExperienceBlock("enderite_scrap_ore", Blocks.END_STONE, 8, 12);
    public static final RegistryObject<Block> SILVER_ORE =
            dropExperienceBlock("silver_ore", Blocks.GOLD_ORE, 3, 4);
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE =
            dropExperienceBlock("deepslate_silver_ore", Blocks.DEEPSLATE_GOLD_ORE, 4, 6);
    public static final RegistryObject<Block> NETHER_SILVER_ORE =
            dropExperienceBlock("nether_silver_ore", Blocks.NETHER_GOLD_ORE, 4, 7);
    public static final RegistryObject<Block> SILVER_BLOCK =
            registerBasicBlock("silver_block", Blocks.GOLD_BLOCK);
    public static final RegistryObject<Block> RAW_SILVER_BLOCK =
            registerBasicBlock("raw_silver_block", Blocks.RAW_GOLD_BLOCK);
    public static final RegistryObject<Block> SAPPHIRE_ORE =
            dropExperienceBlock("sapphire_ore", Blocks.EMERALD_ORE, 5, 10);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK =
            registerBasicBlock("sapphire_block", Blocks.EMERALD_BLOCK);
    public static final RegistryObject<Block> RUBY_ORE =
            dropExperienceBlock("ruby_ore", Blocks.EMERALD_ORE, 5, 10);
    public static final RegistryObject<Block> RUBY_BLOCK =
            registerBasicBlock("ruby_block", Blocks.EMERALD_BLOCK);
    public static final RegistryObject<Block> TOPAZ_ORE =
            dropExperienceBlock("topaz_ore", Blocks.EMERALD_ORE, 5, 10);
    public static final RegistryObject<Block> TOPAZ_BLOCK =
            registerBasicBlock("topaz_block", Blocks.EMERALD_BLOCK);

    public static final RegistryObject<Block> QUICK_SAND = registerBlock("quick_sand",
            () -> new QuickSandBlock(1, BlockBehaviour.Properties.copy(Blocks.SAND).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MOSSY_BRICK =
            registerBasicBlock("mossy_brick", Blocks.BRICKS);
    public static final RegistryObject<Block> MOSSY_BRICK_STAIRS = registerBlock("mossy_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.MOSSY_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)));
    public static final RegistryObject<Block> MOSSY_BRICK_SLAB = registerBlock("mossy_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)));
    public static final RegistryObject<Block> MOSSY_BRICK_PRESSURE_PLATE = registerBlock("mossy_brick_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE), BlockSetType.STONE));
    public static final RegistryObject<Block> MOSSY_BRICK_WALL = registerBlock("mossy_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)));

    public static final RegistryObject<Block> GILDED_BLACKSTONE_BRICK =
            registerBasicBlock("gilded_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final RegistryObject<Block> GILDED_BLACKSTONE_BRICK_STAIRS = registerBlock("gilded_blackstone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GILDED_BLACKSTONE_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> GILDED_BLACKSTONE_BRICK_SLAB = registerBlock("gilded_blackstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)));
    public static final RegistryObject<Block> GILDED_BLACKSTONE_BRICK_WALL = registerBlock("gilded_blackstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICK_WALL)));

    public static final RegistryObject<Block> INFUSED_END_BRICK =
            registerBasicBlock("infused_end_stone_brick", Blocks.END_STONE_BRICKS);
    public static final RegistryObject<Block> INFUSED_END_BRICK_STAIRS = registerBlock("infused_end_stone_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.INFUSED_END_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> INFUSED_END_BRICK_SLAB = registerBlock("infused_end_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> INFUSED_END_BRICK_WALL = registerBlock("infused_end_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICK_WALL)));

    public static final RegistryObject<Block> ENRICHED_NETHER_BRICK =
            registerBasicBlock("enriched_nether_brick", Blocks.NETHER_BRICKS);
    public static final RegistryObject<Block> ENRICHED_NETHER_BRICK_STAIRS = registerBlock("enriched_nether_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ENRICHED_NETHER_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_STAIRS)));
    public static final RegistryObject<Block> ENRICHED_NETHER_BRICK_SLAB = registerBlock("enriched_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_SLAB)));
    public static final RegistryObject<Block> ENRICHED_NETHER_BRICK_WALL = registerBlock("enriched_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_WALL)));
    public static final RegistryObject<Block> ENRICHED_NETHER_BRICK_FENCE = registerBlock("enriched_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE)));
    public static final RegistryObject<Block> ENRICHED_NETHER_BRICK_FENCE_GATE = registerBlock("enriched_nether_brick_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> ENRICHED_RED_NETHER_BRICK =
            registerBasicBlock("enriched_red_nether_brick", Blocks.RED_NETHER_BRICKS);
    public static final RegistryObject<Block> ENRICHED_RED_NETHER_BRICK_STAIRS = registerBlock("enriched_red_nether_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.ENRICHED_NETHER_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICK_STAIRS)));
    public static final RegistryObject<Block> ENRICHED_RED_NETHER_BRICK_SLAB = registerBlock("enriched_red_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICK_SLAB)));
    public static final RegistryObject<Block> ENRICHED_RED_NETHER_BRICK_WALL = registerBlock("enriched_red_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICK_WALL)));
    public static final RegistryObject<Block> ENRICHED_RED_NETHER_BRICK_FENCE = registerBlock("enriched_red_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE)));
    public static final RegistryObject<Block> ENRICHED_RED_NETHER_BRICK_FENCE_GATE = registerBlock("enriched_red_nether_brick_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> PACKED_ICE_STAIRS = registerBlock("packed_ice_stairs",
            () -> new StairBlock(() -> Blocks.PACKED_ICE.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final RegistryObject<Block> PACKED_ICE_SLAB = registerBlock("packed_ice_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));
    public static final RegistryObject<Block> PACKED_ICE_WALL = registerBlock("packed_ice_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE)));

    public static final RegistryObject<Block> CHANNELLED_STONEBRICK =
            registerBasicBlock("channelled_stonebrick", Blocks.STONE_BRICKS);
    public static final RegistryObject<Block> CHANNELLED_STONEBRICK_STAIRS = registerBlock("channelled_stonebrick_stairs",
            () -> new StairBlock(() -> ModBlocks.CHANNELLED_STONEBRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> CHANNELLED_STONEBRICK_SLAB = registerBlock("channelled_stonebrick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> CHANNELLED_STONEBRICK_WALL = registerBlock("channelled_stonebrick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CHANNELLED_MOSSY_STONEBRICK =
            registerBasicBlock("channelled_mossy_stonebrick", Blocks.STONE_BRICKS);
    public static final RegistryObject<Block> CHANNELLED_MOSSY_STONEBRICK_STAIRS = registerBlock("channelled_mossy_stonebrick_stairs",
            () -> new StairBlock(() -> ModBlocks.CHANNELLED_MOSSY_STONEBRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_STAIRS)));
    public static final RegistryObject<Block> CHANNELLED_MOSSY_STONEBRICK_SLAB = registerBlock("channelled_mossy_stonebrick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> CHANNELLED_MOSSY_STONEBRICK_WALL = registerBlock("channelled_mossy_stonebrick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CHANNELLED_STONEBRICK_CARVED =
            registerBasicBlock("channelled_stonebrick_carved", Blocks.CHISELED_STONE_BRICKS);
    public static final RegistryObject<Block> CHANNELLED_STONEBRICK_CARVED_STAIRS = registerBlock("channelled_stonebrick_carved_stairs",
            () -> new StairBlock(() -> ModBlocks.CHANNELLED_STONEBRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));
    public static final RegistryObject<Block> CHANNELLED_STONEBRICK_CARVED_SLAB = registerBlock("channelled_stonebrick_carved_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));
    public static final RegistryObject<Block> CHANNELLED_STONEBRICK_CARVED_WALL = registerBlock("channelled_stonebrick_carved_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));

    // Crops
    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new TomatoCropBlock());
    public static final RegistryObject<Block> CHILLI_CROP = BLOCKS.register("chilli_crop",
            () -> new CilliCropBlock());
    public static final RegistryObject<Block> LETTUCE_CROP = BLOCKS.register("lettuce_crop",
            () -> new LettuceCropBlock());
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock());
    public static final RegistryObject<Block> EMERALD_ESSENCE_CROP = BLOCKS.register("emerald_essence_crop",
            () -> new EmeraldEssenceCropBlock());


    // Block Entities
    public static final RegistryObject<Block> INFUSION_TABLE = registerBlock("infusion_table",
            InfusionTableBlock::new);

    public static final RegistryObject<Block> SCRIBING_TABLE = registerBlock("scribing_table",
            () -> new ScribingTableBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> GEM_EMPOWERING_STATION = registerBlock("gem_empowering_station",
            () -> new GemEmpoweringStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static RegistryObject<Block> registerBasicBlock(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new Block(BlockBehaviour.Properties.copy(copyProperties)));
    }

    private static RegistryObject<Block> dropExperienceBlock(String registry_name, Block copyProperties, int xpMIN, int xpMAX) {
        return registerBlock(registry_name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(copyProperties).requiresCorrectToolForDrops(), UniformInt.of(xpMIN, xpMAX)));
    }

    private static RegistryObject<Block> registerButton(String registryName, Block copyProperties, BlockSetType blockSetType, int tickToStayPressed, boolean arrowsCanPress) {
        return registerBlock(registryName,
                () -> new ButtonBlock(BlockBehaviour.Properties.copy(copyProperties),
                        blockSetType, 10, true));
    }

    private static RegistryObject<Block> registerPressurePlate(String registryName, Block copyProperties, BlockSetType blockSetType, PressurePlateBlock.Sensitivity sensitivity) {
        return registerBlock(registryName,
                () -> new PressurePlateBlock(sensitivity, BlockBehaviour.Properties.copy(copyProperties),
                        blockSetType));
    }

    private static RegistryObject<Block> registerDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new DoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.STONE));
    }

    private static RegistryObject<Block> registerRedstoneDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new DoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.IRON));
    }

    private static RegistryObject<Block> registerTrapDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.STONE));
    }

    private static RegistryObject<Block> registerRedstoneTrapDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.IRON));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
