package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.math.Polygon;
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
//		cannon = new Cannon(TypeCannon.ROCKET_LAUNCHER); //TODO var from config-file and load-file
//		cannon = new Cannon(TypeCannon.LASER_GUN); //TODO var from config-file and load-file
		positioningGun();
		movement = new MovementSpaceShip();
	}
	
	public void move() {
		movement.move(areaObject);
		positioningGun();
	}
	

	private void positioningGun() {
		Polygon areaCannon = cannon.getAreaObject();
		float x = areaObject.x + areaObject.width / 2.5f;
		float y = areaObject.y + areaObject.height / 2.5f;
		float width = cannon.getWidth();
		float height = cannon.getHeight();
		float[] areaVertices = new float[] {
			x, y,
			x, y + height,
			x + width, y + height,
			x + width, y
		};
		
		areaCannon.setPosition(x, y);
		areaCannon.setVertices(areaVertices);
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
