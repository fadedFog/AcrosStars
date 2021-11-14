package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;

public class LaserBehavior implements FlyBehaviorProjectile {

	@Override
	public Rectangle flyProjectile(Rectangle areaProjectile, float speedY) {
		float heightLaser = GameConfig.getInstance().getHeightWindowGame();
		areaProjectile.height = heightLaser;
		return areaProjectile;
	}

}
