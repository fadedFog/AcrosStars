package ru.fadedfog.acrosstars.models;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;

public class Gun {
	private GameConfig config;
	private Rectangle areaObject;
	private List<Bullet> bulletsOut;
	
	public Gun() { //TODO vars from config file
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = 9f;
		areaObject.width = 8f;
		
		bulletsOut = new LinkedList<>();
	}
	
	public void shoot() { // TODO add remove when out bounds
		Bullet bullet = new Bullet();
		positioningBullet(bullet);
		bullet.start();
		bulletsOut.add(bullet);
	}
	
	private void positioningBullet(Bullet bullet) {
		bullet.setX(areaObject.x + areaObject.width / 2);
		bullet.setY(areaObject.y + areaObject.height);
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

	public List<Bullet> getBulletsOut() {
		return bulletsOut;
	}

	public void setBulletsOut(List<Bullet> bulletsOut) {
		this.bulletsOut = bulletsOut;
	}

}
