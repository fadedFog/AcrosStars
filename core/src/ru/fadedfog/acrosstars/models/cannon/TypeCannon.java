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

		@Override
		public int getStandartAmmo() {
			return 10;
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

		@Override
		public int getStandartAmmo() {
			return 5;
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

		@Override
		public int getStandartAmmo() {
			return 5;
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

		@Override
		public int getStandartAmmo() {
			return 0;
		}
	};
	
	protected GameConfig config = GameConfig.getInstance();
	
	public abstract TypeProjectile getTypeProjectile();
	public abstract float[] getAreaCannon();
	public abstract int getStandartAmmo();
}
