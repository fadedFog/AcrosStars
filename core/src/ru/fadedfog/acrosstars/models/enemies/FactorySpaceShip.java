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
	
	public EnemyShip createEnemyShip(TypeEShip typeEShip) {
		EnemyShip enemyShip;
		Rectangle areaPawn = new Rectangle();
		switch (typeEShip) {
			case PAWN:
				areaPawn.height = config.getHeightEPawn();
				areaPawn.width = config.getWidthEPawn();
				break;
			case BASTION:
				areaPawn.height = config.getHeightEBastion();
				areaPawn.width = config.getWidthEBastion(); 
				break;
			case KAMIKAZA:
				areaPawn.height = config.getHeightEKamikaza();
				areaPawn.width = config.getWidthEKamikaza();
				break;
			default:
				enemyShip = null;
				break;
		}
		
		enemyShip = new EnemyShip(typeEShip, config, areaPawn);		
		return enemyShip;
	}

}
