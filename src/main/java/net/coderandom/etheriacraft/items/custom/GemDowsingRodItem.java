package net.coderandom.etheriacraft.items.custom;

import net.coderandom.etheriacraft.blocks.ModBlocks;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;

public class GemDowsingRodItem extends Item {
    public GemDowsingRodItem() {
        super(new Properties().durability(150));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (!context.getLevel().isClientSide){
            BlockPos blockPos = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= blockPos.getY() + 64; i++) {
                BlockState state = context.getLevel().getBlockState(blockPos.below(i));
                if (isValuableBlock(state)) {
                    outputFoundBlock(blockPos.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No Gems Detected!"));
            }
            context.getItemInHand().hurtAndBreak(1, context.getPlayer(), player1 ->
                    player.broadcastBreakEvent(player.getUsedItemHand()));
        }
        return InteractionResult.SUCCESS;
    }

    private void outputFoundBlock(BlockPos pos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found "
                + I18n.get(block.getDescriptionId())
                + " at " + pos.getY()));
    }

    private boolean isValuableBlock(BlockState state) {

        return state.is(Tags.Blocks.ORES_COAL)
                || state.is(Tags.Blocks.ORES_REDSTONE)
                || state.is(Tags.Blocks.ORES_LAPIS)
                || state.is(Tags.Blocks.ORES_EMERALD)
                || state.is(Tags.Blocks.ORES_DIAMOND)
                || state.is(Tags.Blocks.ORES_QUARTZ)
                || state.is(Tags.Blocks.ORES_NETHERITE_SCRAP)
                || state.is(ModBlocks.SAPPHIRE_ORE.get())
                || state.is(ModBlocks.TOPAZ_ORE.get())
                || state.is(ModBlocks.RUBY_ORE.get());
    }
}
