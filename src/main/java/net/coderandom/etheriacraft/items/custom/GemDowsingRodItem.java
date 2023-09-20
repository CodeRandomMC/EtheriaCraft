package net.coderandom.etheriacraft.items.custom;

import net.coderandom.etheriacraft.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class GemDowsingRodItem extends Item {
    public GemDowsingRodItem() {
        super(new Properties().durability(150));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide){
            BlockPos blockPos = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= blockPos.getY() + 64; i++) {
                BlockState state = context.getLevel().getBlockState(blockPos.below(i));
                if (isValuableBlock(state)) {
                    assert player != null;
                    outputFoundBlock(blockPos.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                assert player != null;
                player.sendSystemMessage(Component.literal("No Gems Detected!"));
            }
            context.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(context.getPlayer()), player1 ->
                    player.broadcastBreakEvent(player.getUsedItemHand()));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.etheria_craft.gem_dowsing_rod"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputFoundBlock(BlockPos pos, Player player, Block block) {
        player.sendSystemMessage(Component.literal(
                I18n.get(block.getDescriptionId())
                        + " at ("+ pos.getX() + ", " + pos.getY()+ ", " + pos.getZ()+ ')'));
    }

    private boolean isValuableBlock(BlockState state) {

        return state.is(ModTags.Blocks.ORES_GEM);
    }
}
