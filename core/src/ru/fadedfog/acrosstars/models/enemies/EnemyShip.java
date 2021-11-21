package ru.fadedfog.acrosstars.models.enemies;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.Ship;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackBehavior;

public class EnemyShip implements Ship {
	private TypeEShip typeShip;
	private AttackBehavior attackBehavior;
	private GameConfig config;
	private Rectangle areaObject;
	
	public EnemyShip(TypeEShip typeEShip, AttackBehavior attackBehavior,
			GameConfig config, Rectangle areaObject) {
		this.typeShip = typeEShip;
		this.attackBehavior = attackBehavior;
		this.config = config;
		this.areaObject = areaObject;
		attackBehavior.setShip(this);
	}

	public void attack() {
		attackBehavior.attack();
	}
	
	public Rectangle getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Rectangle areaObject) {
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
	
}
