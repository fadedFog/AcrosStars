package ru.fadedfog.acrosstars.models.projectile;


import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.projectile.fly_projectile_behavior.FlyBehaviorProjectile;

public class Projectile {
	private GameConfig config;
	private Polygon areaObject;
	private float[] widthHeight;
	private float speedProjectile;
	private TypeProjectile typeProjectile;
	private FlyBehaviorProjectile flyBehaviorProjectile;
	
	public Projectile(TypeProjectile typeProjectile) { // TODO vars from config or load file
		config = GameConfig.getInstance();
		this.typeProjectile = typeProjectile;
		flyBehaviorProjectile = typeProjectile.getFlyBehaviorProjectile();
		widthHeight = typeProjectile.getAreaCannon();
		areaObject = new Polygon();
		speedProjectile = 500f; // if BulletAssault
//		speedProjectile = 400f; // if Rocket
	}
	
	public void fly() {
		flyBehaviorProjectile.flyProjectile(areaObject, speedProjectile);
		updateWidthAndHeight();
	}
	
	private void updateWidthAndHeight() {
		int lastY = areaObject.getVertices().length - 1;
		float width = areaObject.getVertices()[lastY - 1] - areaObject.getVertices()[0];
		float height = areaObject.getVertices()[5] - areaObject.getVertices()[1];
		widthHeight = new float[] {width, height};
	}
	
	public float getX() {
		return areaObject.getX();
	}

	public float getY() {
		return areaObject.getY();
	}
	
	public void setXY(float x, float y) {
		areaObject.setPosition(x, y);
	}
	
	public float getWidth() {
		return widthHeight[0];
	}
	
	public void setWidth(float width) {
		widthHeight[0] = width;
	}
	
	public float getHeight() {
		return widthHeight[1];
	}
	
	public void setHeight(float height) {
		widthHeight[1] = height;
	}
	
	public Polygon getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Polygon areaObject) {
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
