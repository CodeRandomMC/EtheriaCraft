package net.coderandom.etheriacraft.entities.client.creatures;

import com.mojang.blaze3d.vertex.PoseStack;
import net.coderandom.etheriacraft.EtheriaCraft;
import net.coderandom.etheriacraft.entities.custom.creatures.BisonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Random;

public class BisonRenderer extends GeoEntityRenderer<BisonEntity> {
    public BisonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BisonModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BisonEntity animatable) {
        return new ResourceLocation(EtheriaCraft.MOD_ID, "textures/entity/bison.png");
    }

    @Override
    public void render(BisonEntity entity, float entityYaw, float partialTick, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight) {

        if (entity.isBaby()) {
            Random random = new Random(entity.getId()); // Use entity ID as seed for consistent scaling
            float randomBabyScale = 0.4f + (0.6f - 0.4f) * random.nextFloat(); // Random scale for baby
            poseStack.scale(randomBabyScale, randomBabyScale, randomBabyScale);
        } else {
            Random random = new Random(entity.getId()); // Use entity ID as seed for consistent scaling
            float randomAdultScale = 0.8f + (1.2f - 0.9f) * random.nextFloat(); // Random scale for adult
            poseStack.scale(randomAdultScale, randomAdultScale, randomAdultScale);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
