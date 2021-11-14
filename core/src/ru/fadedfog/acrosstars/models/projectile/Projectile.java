package ru.fadedfog.acrosstars.models.projectile;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior.FlyBehaviorProjectile;

public class Projectile {
	private GameConfig config;
	private Rectangle areaObject;
	private float speedProjectile;
	private TypeProjectile typeProjectile;
	private FlyBehaviorProjectile flyBehaviorProjectile;
	
	public Projectile(TypeProjectile typeProjectile) { // TODO vars from config or load file
		this.typeProjectile = typeProjectile;
		flyBehaviorProjectile = typeProjectile.getFlyBehaviorProjectile();
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = 10f;
		areaObject.width = 3f;
		speedProjectile = 500f; // if BulletAssault
//		speedProjectile = 400f; // if Rocket
	}
	
	public void fly() {
		flyBehaviorProjectile.flyProjectile(areaObject, speedProjectile);
	}
	
	public float getX() {
		return areaObject.x;
	}
	
	public void setX(float x) {
		areaObject.x = x;
	}
	
	public float getY() {
		return areaObject.y;
	}
	
	public void setY(float y) {
		areaObject.y = y;
	}
	
	public float getWidth() {
		return areaObject.width;
	}
	
	public void setWidth(float width) {
		areaObject.width = width;
	}
	
	public float getHeight() {
		return areaObject.height;
	}
	
	public void setHeight(float height) {
		areaObject.height = height;
	}

	public Rectangle getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Rectangle areaObject) {
		this.areaObject = areaObject;
	}

	public float getSpeedProjectile() {
		return speedProjectile;
	}

	public void setSpeedProjectile(float speedProjectile) {
		this.speedProjectile = speedProjectile;
	}

	public TypeProjectile getTypeProjectile() {
		return typeProjectile;
	}

	public void setTypeProjectile(TypeProjectile typeProjectile) {
		this.typeProjectile = typeProjectile;
	}
	
}
