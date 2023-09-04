package net.coderandom.etheriacraft.items.custom;

import net.minecraft.world.item.ItemStack;

public class CombustionScrollItem extends FuelItem{

    public CombustionScrollItem(Properties pProperties, int burnTime) {
        super(pProperties, burnTime);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
