package ru.fadedfog.acrosstars.models.enemies;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.Ship;

public class EnemyShip implements Ship {
	private TypeEShip typeShip;
	private GameConfig config;
	private Rectangle areaObject;
	
	public EnemyShip(TypeEShip typeEShip, GameConfig config, Rectangle areaObject) {
		this.setTypeShip(typeEShip);
		this.config = config;
		this.areaObject = areaObject;
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
	
}
