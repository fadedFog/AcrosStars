package ru.fadedfog.acrosstars.models;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.cannon.TypeCannon;
import ru.fadedfog.acrosstars.movements.MovementSpaceShip;

public class SpaceShip implements Ship {
	private GameConfig config;
	private float hp;
	private Rectangle areaObject;
	private MovementSpaceShip movement;
	private Cannon cannon;

	public SpaceShip() {
		config = GameConfig.getInstance();
		hp = config.getHpSpaceShip();
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
	}
	
	public void shift() {
		movement.shift(areaObject);
	}

	public void positioningGun() { // TODO Add some vars to config file
		Polygon areaCannon = cannon.getAreaObject();
		float x = areaObject.x + areaObject.width / 2.5f;
		float y = areaObject.y + areaObject.height / 2.5f;
		float width = cannon.getWidth();
		float height = cannon.getHeight();
		float xOrigin = cannon.getWidth() / 2;
		float yOrigin = 0f;
		float[] areaVertices = new float[] {
			x, y,
			x, y + height,
			x + width, y + height,
			x + width, y
		};
		areaCannon.setOrigin(xOrigin, yOrigin);
		areaCannon.setPosition(x, y);
		areaCannon.setVertices(areaVertices);
	}
	
	public Vector2 getCenterPosition() {
		float centerX = areaObject.getX() + areaObject.width / 2;
		float centerY = areaObject.getY() + areaObject.height / 2;
		
		Vector2 result = new Vector2(centerX, centerY);		
		return result;
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

	@Override
	public float getHP() {
		return hp;
	}

	@Override
	public void setHP(float hp) {
		this.hp = hp;
	}
	
}
