package ru.fadedfog.acrosstars.models.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;

public class Projectile {
	private GameConfig config;
	private Rectangle areaObject;
	private float speedProjectile;
	private TypeProjectile typeProjectile;
	private long startTime;
	
	public Projectile(TypeProjectile typeProjectile) { // TODO vars from config or SQL
		this.typeProjectile = typeProjectile;
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = 10f;
		areaObject.width = 3f;
		speedProjectile = 500f; // if BulletAssault
//		speedProjectile = 400f; // if Rocket
	}
	
	public void fly() { // TODO different fly of projectiles
		// TODO change to simple and better 
		switch (typeProjectile) {
			case BULLET_ASSAULT:
				areaObject.y += speedProjectile * Gdx.graphics.getDeltaTime();
				break;
			case ROCKET:
				if (startTime == 0) {
					startTime = System.currentTimeMillis();
				}
				
				float speedChanged = speedProjectile;
				if (System.currentTimeMillis() - startTime < 500l) {
					speedChanged /= 2.5f;
				}
				
				areaObject.y += speedChanged * Gdx.graphics.getDeltaTime();
				break;
			case LASER:
				float heightLaser = config.getHeightWindowGame();
				areaObject.height = heightLaser;
				
				break;
			default:
				break;
		}
		
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
