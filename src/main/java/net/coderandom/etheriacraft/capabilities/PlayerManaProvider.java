package net.coderandom.etheriacraft.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides the capability for managing player mana within the mod.
 */
public class PlayerManaProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    // Define the PlayerMana capability.
    public static Capability<PlayerMana> PLAYER_MANA =
            CapabilityManager.get(new CapabilityToken<PlayerMana>() {
            });

    private PlayerMana instance = null;
    private LazyOptional<PlayerMana> lazyOptional = LazyOptional.of(this::createInstance);

    /**
     * Creates a new instance of the PlayerMana capability.
     *
     * @return The PlayerMana capability instance.
     */
    private PlayerMana createInstance() {
        if (instance == null) {
            instance = new PlayerMana();
        }
        return instance;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        // Check if the requested capability is PLAYER_MANA and return it if so.
        if (cap == PLAYER_MANA) {
            return lazyOptional.cast();
        }
        // Return an empty LazyOptional for other capabilities.
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        // Serialize the PlayerMana capability data to NBT.
        CompoundTag nbt = new CompoundTag();
        createInstance().saveNBTDATA(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        // Deserialize the PlayerMana capability data from NBT.
        createInstance().loadNBTDATA(nbt);
    }
}
