package net.coderandom.etheriacraft.capabilities;

import net.coderandom.etheriacraft.EtheriaCraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class PlayerMana {
    // Private fields to store mana-related information
    private int mana;         // Current mana level
    private int minMana = 0;  // Minimum mana level
    private int maxMana = 100; // Maximum mana level
    private int manaRegen = 1; // Mana regeneration rate

    // Getter method to retrieve the current mana level
    public int getMana() {
        return mana;
    }

    // Method to add mana with a specified amount, clamped to the maximum mana level
    public void addMana(int mana) {
        this.mana = Math.min(this.mana + mana, maxMana);
    }

    // Method to remove mana with a specified amount, clamped to the minimum mana level
    public void removeMana(int mana) {
        this.mana = Math.max(this.mana - mana, minMana);
    }

    // Method to copy the mana from another PlayerMana instance
    public void copyMana(PlayerMana source) {
        this.mana = source.getMana();
    }

    // Method to save mana-related data to an NBT (Named Binary Tag) compound
    public void saveNBTDATA(CompoundTag compound) {
        compound.putInt("mana", mana);
    }

    // Method to load mana-related data from an NBT compound
    public void loadNBTDATA(CompoundTag compound) {
        mana = compound.getInt("mana");
    }

    public void tick(Player player) {
        addMana(manaRegen);
        player.sendSystemMessage(Component.literal("Mana: " + mana));
        EtheriaCraft.LOGGER.info("Mana: " + mana);
    }

    public void blockBreakEvent(Player player) {
        removeMana(10);
        // message player
        player.sendSystemMessage(Component.literal("Mana: " + mana));
        EtheriaCraft.LOGGER.info("Mana: " + mana);
    }
}
