package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.projectile.Projectile;

public class LaserBehavior implements FlyBehaviorProjectile {

	@Override
	public Polygon flyProjectile(Projectile projectile, float speedY) {
		Polygon areaProjectile = projectile.getAreaObject();
		float heightLaser = GameConfig.getInstance().getHeightWindowGame();
		areaProjectile.getVertices()[3] = heightLaser;
		areaProjectile.getVertices()[5] = heightLaser;
		return areaProjectile;
	}

}
