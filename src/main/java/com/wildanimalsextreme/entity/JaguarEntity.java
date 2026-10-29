package com.wildanimalsextreme.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class JaguarEntity extends Animal implements GeoEntity {

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	// Animation names must match the ones in your jaguar.animation.json
	private static final RawAnimation IDLE   = RawAnimation.begin().thenLoop("animation.jaguar.idle");
	private static final RawAnimation WALK   = RawAnimation.begin().thenLoop("animation.jaguar.walk");
	private static final RawAnimation RUN    = RawAnimation.begin().thenLoop("animation.jaguar.run");
	private static final RawAnimation ATTACK = RawAnimation.begin().thenPlay("animation.jaguar.attack");

	public JaguarEntity(EntityType<? extends Animal> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 28.0)
				.add(Attributes.MOVEMENT_SPEED, 0.28)
				.add(Attributes.ATTACK_DAMAGE, 7.0)
				.add(Attributes.FOLLOW_RANGE, 20.0)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.25);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.35, true));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "main", 5, state -> {
			if (this.swinging) {
				return state.setAndContinue(ATTACK);
			}
			if (state.isMoving()) {
				// simple speed check for run vs walk
				if (this.getDeltaMovement().horizontalDistanceSqr() > 0.04) {
					return state.setAndContinue(RUN);
				}
				return state.setAndContinue(WALK);
			}
			return state.setAndContinue(IDLE);
		}));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	// No breeding for now (can be added later)
	@Override
	public boolean isFood(net.minecraft.world.item.ItemStack stack) {
		return false;
	}
}
