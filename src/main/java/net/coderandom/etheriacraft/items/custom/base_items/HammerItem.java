package net.coderandom.etheriacraft.items.custom.base_items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.level.BlockEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HammerItem extends DiggerItem implements Vanishable {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    public HammerItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pAttackDamageModifier, pAttackSpeedModifier, pTier, BlockTags.MINEABLE_WITH_PICKAXE, pProperties);
    }

    /**
     * Get a list of block positions to be destroyed within a given range around the player's cursor position.
     *
     * @param range           The range around the cursor position.
     * @param initialBlockPos The initial block position.
     * @param player          The server player using the hammer.
     * @return A list of block positions to be destroyed.
     */
    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();

        // Perform a raycast from the player's cursor position
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        // If the raycast misses, return an empty list
        if (traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        // Calculate block positions based on the direction of the cursor
        if (traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + y));
                }
            }
        }

        if (traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ()));
                }
            }
        }

        if (traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    positions.add(new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + x));
                }
            }
        }

        return positions;
    }

    /**
     * Handle the breaking of blocks by the hammer.
     *
     * @param event The BlockEvent.BreakEvent for the block being broken.
     */
    public static void onHammerBreaksBlock(BlockEvent.BreakEvent event) {
        ServerPlayer player = (ServerPlayer) event.getPlayer();
        HammerItem hammer = (HammerItem) player.getMainHandItem().getItem();

        BlockPos initialBlockPos = event.getPos();
        if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
            return;
        }

        for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, player)) {
            if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(player.getMainHandItem(), event.getLevel().getBlockState(pos))) {
                continue;
            }

            // Add positions to the set to prevent multiple breaks
            HARVESTED_BLOCKS.add(pos);
            player.gameMode.destroyBlock(pos);
            HARVESTED_BLOCKS.remove(pos);
        }
    }
}
