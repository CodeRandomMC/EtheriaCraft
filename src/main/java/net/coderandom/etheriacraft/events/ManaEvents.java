package net.coderandom.etheriacraft.events;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.capabilities.PlayerManaProvider;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EtheriaCraft.MOD_ID)
public class ManaEvents {
    // Tick counter to update manaRegen every 200 ticks
    private static int tickCounter = 0;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER && event.phase == TickEvent.Phase.END) {
            // Only update mana once every 100 ticks
            if (tickCounter >= 100) {
                event.player.getCapability(PlayerManaProvider.PLAYER_MANA).orElseThrow(
                        () -> new IllegalArgumentException("LazyOptional must not be empty!")
                ).tick(event.player);
                // Reset the tick counter
                tickCounter = 0;
            } else {
                // Increment the tick counter
                tickCounter++;
            }
        }
    }

    @SubscribeEvent
    public static void onRightClick(BlockEvent.BreakEvent event) {
        if (event.getPlayer() != null) {
            event.getPlayer().getCapability(PlayerManaProvider.PLAYER_MANA).orElseThrow(
                    () -> new IllegalArgumentException("LazyOptional must not be empty!")
            ).blockBreakEvent(event.getPlayer());
        }
    }
}
