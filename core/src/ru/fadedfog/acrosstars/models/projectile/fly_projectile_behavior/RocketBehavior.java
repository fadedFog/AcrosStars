package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.models.projectile.Projectile;


public class RocketBehavior implements FlyBehaviorProjectile {
	private long startTime;
	
	@Override
	public Polygon flyProjectile(Projectile projectile, float speed) {
		Polygon areaProjectile = projectile.getAreaObject();
		float x = areaProjectile.getX();
		float y = areaProjectile.getY();
		Vector2 vectorDirection = projectile.getVectorDirection();
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		
		float speedChanged = speed;
		if (System.currentTimeMillis() - startTime < 500l) {
			speedChanged /= 2.5f;
		}
		
		x += vectorDirection.x * speedChanged * Gdx.graphics.getDeltaTime();
		y += vectorDirection.y * speedChanged * Gdx.graphics.getDeltaTime();
		
		areaProjectile.setPosition(x, y);
		return areaProjectile;
	}

}
