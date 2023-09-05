package net.coderandom.etheriacraft.blocks;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.blocks.custom.QuickSandBlock;
import net.coderandom.etheriacraft.items.custom.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EtheriaCraft.MOD_ID);
    public static final RegistryObject<Block> END_GOLD_ORE =
            dropExperienceBlock("end_gold_ore", Blocks.END_STONE,6, 8);
    public static final RegistryObject<Block> END_SILVER_ORE =
            dropExperienceBlock("end_silver_ore", Blocks.END_STONE,6, 8);
    public static final RegistryObject<Block> SILVER_ORE =
            dropExperienceBlock("silver_ore", Blocks.GOLD_ORE,3, 4);
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE =
            dropExperienceBlock("deepslate_silver_ore", Blocks.DEEPSLATE_GOLD_ORE,4, 6);
    public static final RegistryObject<Block> NETHER_SILVER_ORE =
            dropExperienceBlock("nether_silver_ore", Blocks.NETHER_GOLD_ORE,4, 7);
    public static final RegistryObject<Block> SILVER_BLOCK =
            registerBasicBlock("silver_block", Blocks.GOLD_BLOCK);
    public static final RegistryObject<Block> RAW_SILVER_BLOCK =
            registerBasicBlock("raw_silver_block", Blocks.RAW_GOLD_BLOCK);
    public static final RegistryObject<Block> SAPPHIRE_ORE =
            dropExperienceBlock("sapphire_ore", Blocks.EMERALD_ORE,5, 10);
    public static final RegistryObject<Block> SAPPHIRE_BLOCK =
            registerBasicBlock("sapphire_block", Blocks.EMERALD_BLOCK);
    public static final RegistryObject<Block> RUBY_ORE =
            dropExperienceBlock("ruby_ore", Blocks.EMERALD_ORE,5, 10);
    public static final RegistryObject<Block> RUBY_BLOCK =
            registerBasicBlock("ruby_block", Blocks.EMERALD_BLOCK);
    public static final RegistryObject<Block> TOPAZ_ORE =
            dropExperienceBlock("topaz_ore", Blocks.EMERALD_ORE,5, 10);
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
                () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING ,BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE), BlockSetType.STONE));

    public static final RegistryObject<Block> MOSSY_BRICK_WALL = registerBlock("mossy_brick_wall",
                () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)));





    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static RegistryObject<Block> registerBasicBlock(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new Block(BlockBehaviour.Properties.copy(copyProperties)));
    }
    public static RegistryObject<Block> dropExperienceBlock(String registry_name, Block copyProperties, int xpMIN, int xpMAX) {
        return registerBlock(registry_name,
                () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(copyProperties).requiresCorrectToolForDrops(), UniformInt.of(xpMIN, xpMAX)));
    }
    public static RegistryObject<Block> registerButton(String registryName, Block copyProperties, BlockSetType blockSetType, int tickToStayPressed, boolean arrowsCanPress) {
        return registerBlock(registryName,
                () -> new ButtonBlock(BlockBehaviour.Properties.copy(copyProperties),
                        blockSetType, 10, true));
    }
    public static RegistryObject<Block> registerPressurePlate(String registryName, Block copyProperties, BlockSetType blockSetType, PressurePlateBlock.Sensitivity sensitivity) {
        return registerBlock(registryName,
                () -> new PressurePlateBlock(sensitivity ,BlockBehaviour.Properties.copy(copyProperties),
                blockSetType));
    }
    public static RegistryObject<Block> registerFence(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new FenceBlock(BlockBehaviour.Properties.copy(copyProperties)));
    }
    public static RegistryObject<Block> registerFenceGate(String registry_name, Block copyProperties) {
        return registerFenceGate(registry_name, copyProperties, SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE);
    }
    public static RegistryObject<Block> registerFenceGate(String registry_name, Block copyProperties, SoundEvent openSound, SoundEvent closeSound) {
        return registerBlock(registry_name,
                () -> new FenceGateBlock(BlockBehaviour.Properties.copy(copyProperties), openSound, closeSound));
    }
    public static RegistryObject<Block> registerWall(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new WallBlock(BlockBehaviour.Properties.copy(copyProperties)));
    }
    public static RegistryObject<Block> registerDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new DoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.STONE));
    }
    public static RegistryObject<Block> registerRedstoneDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new DoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.IRON));
    }
    public static RegistryObject<Block> registerTrapDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.STONE));
    }
    public static RegistryObject<Block> registerRedstoneTrapDoor(String registry_name, Block copyProperties) {
        return registerBlock(registry_name,
                () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(copyProperties).noOcclusion(), BlockSetType.IRON));
    }
    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
