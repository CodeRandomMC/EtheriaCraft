package net.coderandom.etheriacraft.events;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.items.custom.base_items.HammerItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EtheriaCraft.MOD_ID)
public class ToolEvents {

    /**
     * Called when a player breaks a block with a hammer.
     *
     * @param event The event.
     */
    @SubscribeEvent
    public static void onHammerBreaksBlock(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem && player instanceof ServerPlayer && !player.isCreative()) {
            HammerItem.onHammerBreaksBlock(event);
        }
    }
}
