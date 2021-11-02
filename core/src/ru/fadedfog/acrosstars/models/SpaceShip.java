package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.movements.MovementSpaceShip;

public class SpaceShip {
	private Rectangle areaObject;
	private MovementSpaceShip movement;

	public SpaceShip() { // TODO vars get from config file
		areaObject = new Rectangle();
		areaObject.height = 32f;
		areaObject.width = 32f;
		areaObject.x = 700f / 2f;
		areaObject.y = (600f * 2f) / 100f;
		
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
