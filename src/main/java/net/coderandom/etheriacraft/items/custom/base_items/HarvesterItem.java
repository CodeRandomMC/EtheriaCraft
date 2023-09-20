package net.coderandom.etheriacraft.items.custom.base_items;

import net.coderandom.etheriacraft.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class HarvesterItem extends DiggerItem implements Vanishable {
    public HarvesterItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.MINEABLE_WITH_HARVESTER, pProperties);
    }

    // Override the useOn method to handle right-clicking with the Harvester
    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);

        // Check if the block can be tilled
        if (isTillable(state, world.getBlockState(pos.above()))) {
            Player player = context.getPlayer();
            ItemStack stack = context.getItemInHand();

            if (player != null) {
                // Damage the Harvester if not in creative mode
                if (!player.isCreative()) {
                    stack.hurtAndBreak(1, player, (p_220040_1_) ->
                            p_220040_1_.broadcastBreakEvent(context.getHand()));
                }

                // Replace the dirt block with a farmland block
                world.setBlockAndUpdate(pos, Blocks.FARMLAND.defaultBlockState());
                world.setBlockAndUpdate(pos.above(), Blocks.AIR.defaultBlockState());
                return InteractionResult.SUCCESS;
            }
        } else if (isStrippable(state)) {
            Player player = context.getPlayer();
            ItemStack stack = context.getItemInHand();

            if (player != null) {
                // Damage the Harvester if not in creative mode
                if (!player.isCreative()) {
                    stack.hurtAndBreak(1, player, (p_220040_1_) ->
                            p_220040_1_.broadcastBreakEvent(context.getHand()));
                }

                // Replace the log block with a stripped log block
                world.setBlockAndUpdate(pos, getStrippedBlock(state));
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    private BlockState getStrippedBlock(BlockState state) {
        //Check log and return stripped variant
        if (state.is(Blocks.OAK_LOG)) {
            return Blocks.STRIPPED_OAK_LOG.defaultBlockState();
        } else if (state.is(Blocks.SPRUCE_LOG)) {
            return Blocks.STRIPPED_SPRUCE_LOG.defaultBlockState();
        } else if (state.is(Blocks.BIRCH_LOG)) {
            return Blocks.STRIPPED_BIRCH_LOG.defaultBlockState();
        } else if (state.is(Blocks.ACACIA_LOG)) {
            return Blocks.STRIPPED_ACACIA_LOG.defaultBlockState();
        } else if (state.is(Blocks.CHERRY_LOG)) {
            return Blocks.STRIPPED_CHERRY_LOG.defaultBlockState();
        } else if (state.is(Blocks.JUNGLE_LOG)) {
            return Blocks.STRIPPED_JUNGLE_LOG.defaultBlockState();
        } else if (state.is(Blocks.DARK_OAK_LOG)) {
            return Blocks.STRIPPED_DARK_OAK_LOG.defaultBlockState();
        } else if (state.is(Blocks.CRIMSON_STEM)) {
            return Blocks.STRIPPED_CRIMSON_STEM.defaultBlockState();
        } else if (state.is(Blocks.WARPED_STEM)) {
            return Blocks.STRIPPED_WARPED_STEM.defaultBlockState();
        } else if (state.is(Blocks.MANGROVE_LOG)) {
            return Blocks.STRIPPED_MANGROVE_LOG.defaultBlockState();
        } else return state; // If wood type is not recognized, return the input log state
    }

    private boolean isStrippable(BlockState state) {
        return state.is(BlockTags.LOGS);
    }

    // Check if a block can be turned into a path (paveable)
    private boolean isTillable(BlockState state, BlockState aboveState) {
        return state.is(BlockTags.DIRT) && (aboveState.isAir() || aboveState.is(BlockTags.REPLACEABLE_BY_TREES));
    }
}
