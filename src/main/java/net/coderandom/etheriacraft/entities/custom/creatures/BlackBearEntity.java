package net.coderandom.etheriacraft.entities.custom.creatures;

import net.coderandom.etheriacraft.init.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class BlackBearEntity extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public BlackBearEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 14)
                .add(Attributes.ATTACK_DAMAGE, 1.5)
                .add(Attributes.ATTACK_SPEED, 1.5)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FOLLOW_RANGE, 8)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.ATTACK_KNOCKBACK, 2)
                .build();
    }

    @Override
    protected void registerGoals() {
        // Priority 1: Basic necessities like floating in water
        this.goalSelector.addGoal(1, new FloatGoal(this));

        // Priority 2: Defend itself when hurt
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));

        // Priority 3: Avoid enemies
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Wolf.class, 12.0F, 1.0D, 1.2D));

        // Priority 4: Attack when provoked
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));

        // Priority 5: Randomly look around
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        // Priority 6: Look at player if within a certain range
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 5.0F));

        // Priority 7: Follow other mobs
        this.goalSelector.addGoal(7, new FollowMobGoal(this, 1.0D, 10.0F, 5.0F));

        // Priority 8: Random strolling
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1.0D));

        // Priority 9: Goto Bee hives and nests
        this.goalSelector.addGoal(9, new MoveToBlockGoal(this, 1, 16) {
            @Override
            protected boolean isValidTarget(@NotNull LevelReader level, @NotNull BlockPos pos) {
                return (level().getBlockState(pos).getBlock() == Blocks.BEEHIVE ||
                        level().getBlockState(pos).getBlock() == Blocks.BEE_NEST);
            }
        });
        // Priority 10 & 11: Attack Bee hives and nests
        this.goalSelector.addGoal(10, new RemoveBlockGoal(Blocks.BEEHIVE, this, 1, 16));
        this.goalSelector.addGoal(11, new RemoveBlockGoal(Blocks.BEE_NEST, this, 1, 16));

        // Targeting goals
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Bee.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, BisonEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Wolf.class, true));
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob otherParent) {
        return ModEntities.BLACK_BEAR.get().create(level);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::precicate));
    }

    private <T extends GeoAnimatable> PlayState precicate(AnimationState<T> state) {
        if (state.isMoving()) {
            state.getController().setAnimation(RawAnimation.begin().then("animation.black_bear.walk", Animation.LoopType.LOOP));
        } else {
            state.getController().setAnimation(RawAnimation.begin().then("animation.black_bear.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
