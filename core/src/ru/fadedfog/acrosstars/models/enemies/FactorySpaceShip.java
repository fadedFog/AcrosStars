package ru.fadedfog.acrosstars.models.enemies;


import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.cannon.TypeCannon;
import ru.fadedfog.acrosstars.models.enemies.move_behavior.MoveBehavior;
import ru.fadedfog.acrosstars.models.enemies.move_behavior.MoveKamikaze;

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
	
	public EnemyShip createEnemyShip(TypeEShip typeEShip, float x, float y) {
		Polygon areaEShip = new Polygon();
		float[] widthHeight = typeEShip.getAreaEShip();
		float xOrigin = widthHeight[0] / 2;
		float yOrigin = widthHeight[1] / 2;
		float[] areaVertices = new float[] {
				0, 0,
				0, widthHeight[1],
				widthHeight[0], widthHeight[1],
				widthHeight[0], 0
		};
		areaEShip.setOrigin(xOrigin, yOrigin);
		areaEShip.setPosition(x, y);
		areaEShip.setVertices(areaVertices);
		
		Cannon cannon = new Cannon(TypeCannon.NONE);
		if (typeEShip == TypeEShip.BASTION) { // TODO get from method's vars
			cannon = new Cannon(TypeCannon.ASSAULT_GUN);
		} 
		
		MoveBehavior moveBehavior = typeEShip.getMoveBehaviorEShip();
		
		EnemyShip enemyShip = new EnemyShip(typeEShip, cannon, typeEShip.getAttackBehaviorEShip(),
				moveBehavior, config, areaEShip);
		moveBehavior.setEnemyShip(enemyShip);
		enemyShip.setWidthHeight(widthHeight);
		enemyShip.setSpeed(100f);
		enemyShip.setHP(typeEShip.getHpEnemyShip());

		return enemyShip;
	}

}
