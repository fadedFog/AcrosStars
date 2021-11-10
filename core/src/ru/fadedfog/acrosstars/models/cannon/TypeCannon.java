package ru.fadedfog.acrosstars.models.cannon;

import ru.fadedfog.acrosstars.models.projectile.TypeProjectile;

public enum TypeCannon {
	ASSAULT_GUN {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.BULLET_ASSAULT;
		}
	},
	ROCKET_LAUNCHER {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.ROCKET;
		}
	},
	LASER_GUN {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.LASER;
		}
	};
	
	public abstract TypeProjectile getTypeProjectile();
}
