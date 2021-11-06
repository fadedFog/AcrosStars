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
		Rectangle areaPawn = new Rectangle();
		switch (typeEShip) {
			case PAWN:
				areaPawn.height = 32f;
				areaPawn.width = 32f;
				break;
			case BASTION:
				areaPawn.height = 32f;
				areaPawn.width = 32f;
				break;
			case KAMIKAZA:
				areaPawn.height = 32f;
				areaPawn.width = 16f;
				break;
			default:
				enemyShip = null;
				break;
		}
		
		enemyShip = new EnemyShip(typeEShip, config, areaPawn);		
		return enemyShip;
	}

}
