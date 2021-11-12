package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class RocketBehavior implements FlyBehaviorProjectile {
	private long startTime;
	
	@Override
	public Rectangle flyProjectile(Rectangle areaProjectile, float speedY) {
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		
		float speedChanged = speedY;
		if (System.currentTimeMillis() - startTime < 500l) {
			speedChanged /= 2.5f;
		}
		
		areaProjectile.y += speedChanged * Gdx.graphics.getDeltaTime();
		return areaProjectile;
	}

}
