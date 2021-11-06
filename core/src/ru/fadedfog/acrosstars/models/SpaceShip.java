package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.movements.MovementSpaceShip;

public class SpaceShip implements Ship{
	private GameConfig config;
	private Rectangle areaObject;
	private MovementSpaceShip movement;

	public SpaceShip() {
		config = GameConfig.getInstance();
		areaObject = new Rectangle();
		areaObject.height = config.getHeightSpaceShip();
		areaObject.width = config.getWidthSpaceShip();
		areaObject.x = config.getXSpaceShip();
		areaObject.y = config.getYSpaceShip();
		
		movement = new MovementSpaceShip();
	}
	
	public void move() {
		movement.move(areaObject);
	}
	
	public Rectangle getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Rectangle areaObject) {
		this.areaObject = areaObject;
	}
	
}
