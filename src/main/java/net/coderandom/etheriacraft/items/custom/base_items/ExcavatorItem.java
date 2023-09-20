package net.coderandom.etheriacraft.items.custom.base_items;

import net.coderandom.etheriacraft.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

public class ExcavatorItem extends DiggerItem implements Vanishable {
    public ExcavatorItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, ModTags.Blocks.MINEABLE_WITH_EXCAVATOR, pProperties);
    }

    // Override the useOn method to handle right-clicking with the Excavator
    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);

        // Check if the block can be turned into a path
        if (isPaveable(state, world.getBlockState(pos.above())) || state.is(Blocks.DIRT_PATH)) {
            Player player = context.getPlayer();
            ItemStack stack = context.getItemInHand();

            if (player != null) {
                world.playLocalSound(pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F, true);
                // Damage the Excavator if not in creative mode
                if (!player.isCreative()) {
                    stack.hurtAndBreak(1, player, (p_220040_1_) ->
                            p_220040_1_.broadcastBreakEvent(context.getHand()));
                }

                // Check if the block is already a dirt path block
                if (state.is(Blocks.DIRT_PATH)) {
                    // Replace the dirt path block with a dirt block
                    world.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
                    return InteractionResult.SUCCESS;
                }

                // Replace the dirt block with a dirt path block
                world.setBlockAndUpdate(pos, Blocks.DIRT_PATH.defaultBlockState());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    // Check if a block can be turned into a path (paveable)
    private boolean isPaveable(BlockState state, BlockState aboveState) {
        return state.is(BlockTags.DIRT) && (aboveState.isAir() || aboveState.is(BlockTags.REPLACEABLE_BY_TREES) || aboveState.is(BlockTags.SMALL_FLOWERS));
    }
}
