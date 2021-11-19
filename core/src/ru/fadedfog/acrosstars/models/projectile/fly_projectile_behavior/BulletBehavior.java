package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.models.projectile.Projectile;

public class BulletBehavior implements FlyBehaviorProjectile {

	@Override
	public Polygon flyProjectile(Projectile projectile, float speed) {
		Polygon areaProjectile = projectile.getAreaObject();
		float x = areaProjectile.getX();
		float y = areaProjectile.getY();
		Vector2 vectorDirection = projectile.getVectorDirection();
		
		x += vectorDirection.x * speed * Gdx.graphics.getDeltaTime();
		y += vectorDirection.y * speed * Gdx.graphics.getDeltaTime();
		
		areaProjectile.setPosition(x, y);
		return areaProjectile;
	}
	
}
