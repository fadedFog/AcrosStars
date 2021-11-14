package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;

public class BulletBehavior implements FlyBehaviorProjectile {

	@Override
	public Polygon flyProjectile(Polygon areaProjectile, float speedY) {
		float x = areaProjectile.getX();
		float y = areaProjectile.getY();
		y += speedY * Gdx.graphics.getDeltaTime();
		areaProjectile.setPosition(x, y);
		return areaProjectile;
	}
	
}
