package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.utils.TimeUtils;

import ru.fadedfog.acrosstars.config.GameConfig;

public class Bullet extends Thread {  //TODO demo change to Box2D
	private GameConfig config;
	private Rectangle areaObject;
	private float speedY;
	private long lastFlyTime;
	
	public Bullet() { // TODO vars from config file
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = 10f;
		areaObject.width = 3f;
		lastFlyTime = TimeUtils.nanoTime();
	}
	
	@Override
	public void run() {
		while (!interrupted()) {
			fly();
		}
	}


	public void fly() { //TODO demo change to Box2D
		if (TimeUtils.nanoTime() - lastFlyTime > 400000) {
			areaObject.y += 10f * Gdx.graphics.getDeltaTime();
			lastFlyTime = TimeUtils.nanoTime();
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

	public Rectangle getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Rectangle areaObject) {
		this.areaObject = areaObject;
	}
	
	
}
