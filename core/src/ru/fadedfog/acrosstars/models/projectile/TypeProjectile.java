package ru.fadedfog.acrosstars.models.projectile;

import ru.fadedfog.acrosstars.config.GameConfig;
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
		public float[] getAreaCannon() {
			return new float[] {config.getWidthBulletAssault(),
								config.getHeightBulletAssault()};
		}
	},
	ROCKET {
		@Override
		public FlyBehaviorProjectile getFlyBehaviorProjectile() {
			return new RocketBehavior();
		}

		@Override
		public float[] getAreaCannon() {
			return new float[] {config.getWidthRocket(),
								config.getHeightRocket()};
		}
	},
	LASER {
		@Override
		public FlyBehaviorProjectile getFlyBehaviorProjectile() {
			return new LaserBehavior();
		}

		@Override
		public float[] getAreaCannon() {
			return new float[] {config.getWidthLaser(),
								config.getHeightLaser()};
		}
	};
	
	protected GameConfig config = GameConfig.getInstance();
	
	public abstract FlyBehaviorProjectile getFlyBehaviorProjectile();
	public abstract float[] getAreaCannon();
} 
