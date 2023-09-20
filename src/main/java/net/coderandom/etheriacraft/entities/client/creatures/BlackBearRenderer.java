package net.coderandom.etheriacraft.entities.client.creatures;

import com.mojang.blaze3d.vertex.PoseStack;
import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.entities.custom.creatures.BlackBearEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Random;

public class BlackBearRenderer extends GeoEntityRenderer<BlackBearEntity> {
    public BlackBearRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BlackBearModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BlackBearEntity animatable) {
        return new ResourceLocation(EtheriaCraft.MOD_ID, "textures/entity/black_bear.png");
    }

    @Override
    public void render(BlackBearEntity entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {

        if (entity.isBaby()) {
            Random random = new Random(entity.getId()); // Use entity ID as seed for consistent scaling
            float randomBabyScale = 0.6f + (1.0f - 0.6f) * random.nextFloat(); // Random scale between 0.2f and 0.5f
            poseStack.scale(randomBabyScale, randomBabyScale, randomBabyScale);
        } else {
            Random random = new Random(entity.getId()); // Use entity ID as seed for consistent scaling
            float randomAdultScale = 1.2f + (1.8f - 1.2f) * random.nextFloat(); // Random scale between 0.2f and 0.5f
            poseStack.scale(randomAdultScale, randomAdultScale, randomAdultScale);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
