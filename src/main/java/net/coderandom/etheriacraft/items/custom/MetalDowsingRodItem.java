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

public class MetalDowsingRodItem extends Item {
    public MetalDowsingRodItem() {
        super(new Item.Properties().durability(100));
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
                player.sendSystemMessage(Component.literal("No Metal Ore Detected!"));
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

        return state.is(Tags.Blocks.ORES_COPPER)
                || state.is(Tags.Blocks.ORES_IRON)
                || state.is(Tags.Blocks.ORES_GOLD)
                || state.is(ModBlocks.SILVER_ORE.get())
                || state.is(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                || state.is(ModBlocks.NETHER_SILVER_ORE.get())
                || state.is(ModBlocks.END_SILVER_ORE.get())
                || state.is(ModBlocks.END_GOLD_ORE.get());
    }
}
