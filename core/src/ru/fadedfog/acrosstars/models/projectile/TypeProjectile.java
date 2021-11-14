package ru.fadedfog.acrosstars.models.projectile;

import ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior.BulletBehavior;
import ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior.FlyBehaviorProjectile;
import ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior.LaserBehavior;
import ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior.RocketBehavior;

public enum TypeProjectile {
	BULLET_ASSAULT {
		@Override
		public FlyBehaviorProjectile getFlyBehaviorProjectile() {
			return new BulletBehavior();
		}

		@Override
		public float[] getAreaCannon() { // TODO From config file
			return new float[] {3, 10};
		}
	},
	ROCKET {
		@Override
		public FlyBehaviorProjectile getFlyBehaviorProjectile() {
			return new RocketBehavior();
		}

		@Override
		public float[] getAreaCannon() { // TODO From config file
			return new float[] {3, 15};
		}
	},
	LASER {
		@Override
		public FlyBehaviorProjectile getFlyBehaviorProjectile() {
			return new LaserBehavior();
		}

		@Override
		public float[] getAreaCannon() { // TODO From config file
			return new float[] {3, 10};
		}
	};
	
	public abstract FlyBehaviorProjectile getFlyBehaviorProjectile();
	public abstract float[] getAreaCannon();
} 
