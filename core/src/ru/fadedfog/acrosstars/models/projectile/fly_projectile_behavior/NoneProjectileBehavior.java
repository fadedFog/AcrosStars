package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.models.projectile.Projectile;

public class NoneProjectileBehavior implements FlyBehaviorProjectile {

	@Override
	public Polygon flyProjectile(Projectile projectile, float speedY) {
		return new Polygon(new float[] {0, 0});
	}

}
