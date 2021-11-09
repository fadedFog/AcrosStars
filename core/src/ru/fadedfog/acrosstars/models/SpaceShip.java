package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.movements.MovementSpaceShip;

public class SpaceShip implements Ship{
	private GameConfig config;
	private Rectangle areaObject;
	private MovementSpaceShip movement;
	private Gun gun;

	public SpaceShip() {
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = config.getHeightSpaceShip();
		areaObject.width = config.getWidthSpaceShip();
		areaObject.x = config.getXSpaceShip();
		areaObject.y = config.getYSpaceShip();
		
		gun = new Gun();
		
		movement = new MovementSpaceShip();
	}
	
	public void move() {
		movement.move(areaObject);
		positioningGun();
	}
	

	private void positioningGun() { // TODO demo
		gun.setX(areaObject.x + areaObject.width / 2.5f);
		gun.setY(areaObject.y + areaObject.height);
	}
	
	public void shoot() {
		movement.shoot(gun);
	}
	
	public Rectangle getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Rectangle areaObject) {
		this.areaObject = areaObject;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
}
