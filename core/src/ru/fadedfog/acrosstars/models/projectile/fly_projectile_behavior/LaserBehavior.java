package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;


import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.projectile.Projectile;

public class LaserBehavior implements FlyBehaviorProjectile {
	private long startTime;
	
	@Override
	public Polygon flyProjectile(Projectile projectile, float speedY) {
		Polygon areaProjectile = projectile.getAreaObject();
		float heightLaser = GameConfig.getInstance().getHeightWindowGame();
		areaProjectile.getVertices()[3] = heightLaser / 0.5f;
		areaProjectile.getVertices()[5] = heightLaser / 0.5f;
		
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		
		if (System.currentTimeMillis() - startTime > 200l) {
			areaProjectile.setPosition(-1, -1);
		}
		
		return areaProjectile;
	}

}
