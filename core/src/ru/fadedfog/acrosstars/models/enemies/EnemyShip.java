package ru.fadedfog.acrosstars.models.enemies;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.Ship;
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackBehavior;
import ru.fadedfog.acrosstars.models.enemies.move_behavior.MoveBehavior;

public class EnemyShip implements Ship {
	private TypeEShip typeShip;
	private AttackBehavior attackBehavior;
	private MoveBehavior moveBehavior;
	private Cannon cannon;
	private GameConfig config;
	private float[] widthHeight;
	private Polygon areaObject;
	private float speed;
	
	public EnemyShip(TypeEShip typeEShip, Cannon cannon, AttackBehavior attackBehavior,
			MoveBehavior moveBehavior, GameConfig config, Polygon areaObject) {
		this.typeShip = typeEShip;
		this.widthHeight = typeEShip.getAreaEShip();
		this.attackBehavior = attackBehavior;
		this.moveBehavior = moveBehavior;
		this.config = config;
		this.areaObject = areaObject;
		this.cannon = cannon;
		attackBehavior.setEnemyShip(this);
		
		positioningGun();
	}

	public void positioningGun() { // TODO Add some vars to config file
		Polygon areaCannon = cannon.getAreaObject();
		Vector2 posCenterShip = getCenterPosition();
		float x = posCenterShip.x - 4f;
		float y = posCenterShip.y;
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
	
	public void attack() {
		attackBehavior.attack();
	}
	
	public void move() {
		moveBehavior.move();
		positioningGun();
	}
	
	public Vector2 getCenterPosition() {
		float centerX = areaObject.getX() + widthHeight[0] / 2;
		float centerY = areaObject.getY() + widthHeight[1] / 2;
		
		Vector2 result = new Vector2(centerX, centerY);		
		return result;
	}
	
	public Polygon getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Polygon areaObject) {
		this.areaObject = areaObject;
	}

	public TypeEShip getTypeShip() {
		return typeShip;
	}

	public void setTypeShip(TypeEShip typeShip) {
		this.typeShip = typeShip;
	}

	public AttackBehavior getAttackBehavior() {
		return attackBehavior;
	}

	public void setAttackBehavior(AttackBehavior attackBehavior) {
		this.attackBehavior = attackBehavior;
	}

	public float[] getWidthHeight() {
		return widthHeight;
	}

	public void setWidthHeight(float[] widthHeight) {
		this.widthHeight = widthHeight;
	}
	
	public float getWidth() {
		return widthHeight[0];
	}
	
	public void setWidth(float width) {
		widthHeight[0] = width;
	}
	
	public float getHeight() {
		return widthHeight[1];
	}
	
	public void setHeight(float height) {
		widthHeight[1] = height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Cannon getCannon() {
		return cannon;
	}

	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
	}

	public MoveBehavior getMoveBehavior() {
		return moveBehavior;
	}

	public void setMoveBehavior(MoveBehavior moveBehavior) {
		this.moveBehavior = moveBehavior;
	}
	
}
