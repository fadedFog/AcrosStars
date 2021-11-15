package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.config.GameConfig;

public class LaserBehavior implements FlyBehaviorProjectile {

	@Override
	public Polygon flyProjectile(Polygon areaProjectile, float speedY) {
		float heightLaser = GameConfig.getInstance().getHeightWindowGame();
		areaProjectile.getVertices()[3] = heightLaser + 200;
		areaProjectile.getVertices()[5] = heightLaser + 200;
		return areaProjectile;
	}

}
