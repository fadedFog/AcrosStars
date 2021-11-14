package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.math.Polygon;

public interface FlyBehaviorProjectile {
	
	public Polygon flyProjectile(Polygon areaProjectile, float speedY);
	
}
