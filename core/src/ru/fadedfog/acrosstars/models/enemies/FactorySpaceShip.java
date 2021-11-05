package ru.fadedfog.acrosstars.models.enemies;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;

public class FactorySpaceShip {
	private static FactorySpaceShip factorySpaceShip;
	private GameConfig config;
	
	private FactorySpaceShip() {
		config = GameConfig.getInstance();
	}
	
	public static FactorySpaceShip getInstance() {
		if (factorySpaceShip == null) {
			factorySpaceShip = new FactorySpaceShip();
		}
		return factorySpaceShip;
	}
	
	public EnemyShip createEnemyShip(TypeEShip typeEShip) { //TODO vars from config files
		EnemyShip enemyShip;
		
		switch (typeEShip) {
			case PAWN:
				Rectangle areaPawn = new Rectangle();
				areaPawn = new Rectangle();
				areaPawn.height = 32f;
				areaPawn.width = 32f;
				areaPawn.x = (700f / 2f);
				areaPawn.y = 550f;
				enemyShip = new EnemyShip(typeEShip, config, areaPawn);
				break;
			default:
				enemyShip = null;
				break;
		}
		
		return enemyShip;
	}

}
