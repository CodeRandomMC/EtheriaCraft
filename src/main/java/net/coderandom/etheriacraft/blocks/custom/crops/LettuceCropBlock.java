package net.coderandom.etheriacraft.blocks.custom.crops;

import net.coderandom.etheriacraft.init.itemsInit.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class LettuceCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    public LettuceCropBlock() {
        super(
                Properties.copy(Blocks.WHEAT)
                        .noOcclusion()
                        .noCollission()
                        .lightLevel((state) -> {
                            int age = state.getValue(AGE);
                            return 2 * age;  // Light level increases with age
                        })
        );
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int chance = random.nextInt(10);  // Adjust this value to control the growth speed

        if (chance == 0) {  // The crop will only grow 1 out of 10 times it gets ticked
            super.randomTick(state, level, pos, random);
        }
        super.randomTick(state, level, pos, random);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.LETTUCE_SEEDS.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
