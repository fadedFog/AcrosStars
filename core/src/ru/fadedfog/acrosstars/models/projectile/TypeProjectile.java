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
	},
	ROCKET {
		@Override
		public FlyBehaviorProjectile getFlyBehaviorProjectile() {
			return new RocketBehavior();
		}
	},
	LASER {
		@Override
		public FlyBehaviorProjectile getFlyBehaviorProjectile() {
			return new LaserBehavior();
		}
	};
	
	public abstract FlyBehaviorProjectile getFlyBehaviorProjectile();

} 
