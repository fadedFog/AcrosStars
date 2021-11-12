package ru.fadedfog.acrosstars.models.cannon;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.projectile.TypeProjectile;

public enum TypeCannon {
	ASSAULT_GUN {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.BULLET_ASSAULT;
		}

		@Override
		public Rectangle getAreaCannon() {
			Rectangle areaCannon = new Rectangle();
			areaCannon.height = config.getHeightAssaultGun();
			areaCannon.width = config.getWidthAssaultGun();
			return areaCannon;
		}
	},
	ROCKET_LAUNCHER {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.ROCKET;
		}

		@Override
		public Rectangle getAreaCannon() {
			Rectangle areaCannon = new Rectangle();
			areaCannon.height = config.getHeightRocketLauncher();
			areaCannon.width = config.getWidthRocketLauncher();
			return areaCannon;
		}
	},
	LASER_GUN {
		@Override
		public TypeProjectile getTypeProjectile() {
			return TypeProjectile.LASER;
		}

		@Override
		public Rectangle getAreaCannon() {
			Rectangle areaCannon = new Rectangle();
			areaCannon.height = config.getHeightLaserGun();
			areaCannon.width = config.getWidthLasertGun();
			return areaCannon;
		}
	};
	
	protected GameConfig config = GameConfig.getInstance();
	
	public abstract TypeProjectile getTypeProjectile();
	public abstract Rectangle getAreaCannon();
}
