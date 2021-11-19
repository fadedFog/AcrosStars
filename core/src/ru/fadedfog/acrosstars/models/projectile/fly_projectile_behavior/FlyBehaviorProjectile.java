package ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior;

import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.models.projectile.Projectile;


public interface FlyBehaviorProjectile {
	
	public Polygon flyProjectile(Projectile projectile, float speedY);
	
}
