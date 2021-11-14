package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;

public class RocketBehavior implements FlyBehaviorProjectile {
	private long startTime;
	
	@Override
	public Polygon flyProjectile(Polygon areaProjectile, float speedY) {
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		
		float speedChanged = speedY;
		if (System.currentTimeMillis() - startTime < 500l) {
			speedChanged /= 2.5f;
		}
		
		float x = areaProjectile.getX();
		float y = areaProjectile.getY();
		y += speedChanged * Gdx.graphics.getDeltaTime();
		areaProjectile.setPosition(x, y);
		
		return areaProjectile;
	}

}
