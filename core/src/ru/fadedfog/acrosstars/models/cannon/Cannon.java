package ru.fadedfog.acrosstars.models.cannon;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.Bullet;

public class Cannon {
	private GameConfig config;
	private Rectangle areaObject;
	private TypeCannon typeCannon;
	private List<Bullet> bulletsOut;
	
	public Cannon(TypeCannon typeCannon) { //TODO vars from config file
		this.typeCannon = typeCannon;
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = 9f;
		areaObject.width = 8f;
		bulletsOut = new ArrayList<>();
	}
	
	public void shoot() {
		Bullet bullet = new Bullet();
		positioningBullet(bullet);
		bulletsOut.add(bullet);
	}
	
	private void positioningBullet(Bullet bullet) {
		bullet.setX(areaObject.x + areaObject.width / 2.5f);
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

	public TypeCannon getTypeCannon() {
		return typeCannon;
	}

	public void setTypeCannon(TypeCannon typeCannon) {
		this.typeCannon = typeCannon;
	}

	public List<Bullet> getBulletsOut() {
		return bulletsOut;
	}

	public void setBulletsOut(List<Bullet> bulletsOut) {
		this.bulletsOut = bulletsOut;
	}
	
}
