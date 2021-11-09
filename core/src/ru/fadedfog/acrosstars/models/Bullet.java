package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;

public class Bullet {
	private GameConfig config;
	private Rectangle areaObject;
	private float speedY;
	
	public Bullet() { // TODO vars from config file
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = 10f;
		areaObject.width = 3f;
		speedY = 500f;
	}

	public void fly() {
		areaObject.y += speedY * Gdx.graphics.getDeltaTime();
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

	public float getSpeedY() {
		return speedY;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
}
