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
import net.coderandom.etheriacraft.blocks.entities.InfusionTableBlockEntity;
import net.coderandom.etheriacraft.blocks.entities.ScribingTableBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EtheriaCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<?>> INFUSION_TABLE =
            register("infusion_table", ModBlocks.INFUSION_TABLE, InfusionTableBlockEntity::new);

    public static final RegistryObject<BlockEntityType<ScribingTableBlockEntity>> SCRIBING_TABLE =
            BLOCK_ENTITIES.register("scribing_table_block_entity", () ->
                    BlockEntityType.Builder.of(ScribingTableBlockEntity::new,
                            ModBlocks.SCRIBING_TABLE.get()).build(null));

    private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return BLOCK_ENTITIES.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
