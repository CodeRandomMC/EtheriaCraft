package net.coderandom.etheriacraft.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class QuickSandBlock extends FallingBlock implements net.minecraftforge.common.IForgeShearable {
    private final int dustColor;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.00, 16.0D);

    public QuickSandBlock(int pDustColor, BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.dustColor = pDustColor;
    }
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return Shapes.block();
    }

    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        pEntity.makeStuckInBlock(pState, new Vec3(0.25D, (double)0.05F, 0.25D));
    }

    public int getDustColor(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return this.dustColor;
    }
}