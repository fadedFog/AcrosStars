package ru.fadedfog.acrosstars.models.enemies;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackBehavior;
import ru.fadedfog.acrosstars.models.enemies.attack_behavior.AttackKamikaze;

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
		AttackBehavior attackBehavior;
		switch (typeEShip) {
			case PAWN:
				areaPawn.height = config.getHeightEPawn();
				areaPawn.width = config.getWidthEPawn();
				attackBehavior = new AttackKamikaze(); // TODO change to pawn attack behavior
				break;
			case BASTION:
				areaPawn.height = config.getHeightEBastion();
				areaPawn.width = config.getWidthEBastion(); 
				attackBehavior = new AttackKamikaze(); // TODO change to bastion attack behavior
				break;
			case KAMIKAZA:
				areaPawn.height = config.getHeightEKamikaza();
				areaPawn.width = config.getWidthEKamikaza();
				attackBehavior = new AttackKamikaze();
				break;
			default:
				attackBehavior = null;
				enemyShip = null;
				break;
		}
		
		enemyShip = new EnemyShip(typeEShip, attackBehavior, config, areaPawn);		
		
		return enemyShip;
	}

}
