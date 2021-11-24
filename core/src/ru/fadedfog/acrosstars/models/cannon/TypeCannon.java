package ru.fadedfog.acrosstars.models.cannon;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.projectile.TypeProjectile;

public enum TypeCannon {
	ASSAULT_GUN {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.BULLET_ASSAULT;
		}

		@Override
		public float[] getAreaCannon() {
			return new float[] {config.getWidthAssaultGun(), 
								config.getHeightAssaultGun()};
		}

	},
	ROCKET_LAUNCHER {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.ROCKET;
		}

		@Override
		public float[] getAreaCannon() {
			return new float[] {config.getWidthRocketLauncher(),
								config.getHeightRocketLauncher()};
		}
	},
	LASER_GUN {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.LASER;
		}

		@Override
		public float[] getAreaCannon() {
			return new float[] {config.getWidthLasertGun(),
								config.getHeightLaserGun()};
		}
	},
	NONE {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.NONE_PROJECTILE;
		}

		@Override
		public float[] getAreaCannon() {
			return new float[] {config.getWidthLasertGun(),
								config.getHeightLaserGun()};
		}
	};
	
	protected GameConfig config = GameConfig.getInstance();
	
	public abstract TypeProjectile getTypeProjectile();
	public abstract float[] getAreaCannon();
}
