package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class BulletBehavior implements FlyBehaviorProjectile {

	@Override
	public Rectangle flyProjectile(Rectangle areaProjectile, float speedY) {
		areaProjectile.y  += speedY * Gdx.graphics.getDeltaTime();
		return areaProjectile;
	}
	
}
