package ru.fadedfog.acrosstars.models.enemies;

import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.Ship;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackBehavior;

public class EnemyShip implements Ship {
	private TypeEShip typeShip;
	private AttackBehavior attackBehavior;
	private GameConfig config;
	private float[] widthHeight;
	private Polygon areaObject;
	
	public EnemyShip(TypeEShip typeEShip, AttackBehavior attackBehavior,
			GameConfig config, Polygon areaObject) {
		this.typeShip = typeEShip;
		this.attackBehavior = attackBehavior;
		this.config = config;
		this.areaObject = areaObject;
		attackBehavior.setEnemyShip(this);
	}

	public void attack() {
		attackBehavior.attack();
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
	
}
