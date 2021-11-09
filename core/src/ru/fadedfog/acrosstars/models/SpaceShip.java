package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.cannon.TypeCannon;
import ru.fadedfog.acrosstars.movements.MovementSpaceShip;

public class SpaceShip implements Ship {
	private GameConfig config;
	private Rectangle areaObject;
	private MovementSpaceShip movement;
	private Cannon cannon;

	public SpaceShip() {
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = config.getHeightSpaceShip();
		areaObject.width = config.getWidthSpaceShip();
		areaObject.x = config.getXSpaceShip();
		areaObject.y = config.getYSpaceShip();
		
		cannon = new Cannon(TypeCannon.ASSAULT_GUN); //TODO var from config-file and load-file
		
		movement = new MovementSpaceShip();
	}
	
	public void move() {
		movement.move(areaObject);
		positioningGun();
	}
	

	private void positioningGun() { // TODO demo
		cannon.setX(areaObject.x + areaObject.width / 2.5f);
		cannon.setY(areaObject.y + areaObject.height);
	}
	
	public void shoot() {
		movement.shoot(cannon);
	}
	
	public Rectangle getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Rectangle areaObject) {
		this.areaObject = areaObject;
	}

	public Cannon getCannon() {
		return cannon;
	}

	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
	}
	
}
