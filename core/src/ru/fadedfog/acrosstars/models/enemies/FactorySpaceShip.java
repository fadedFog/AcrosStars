package ru.fadedfog.acrosstars.models.enemies;

import com.badlogic.gdx.math.Polygon;

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
	
	public EnemyShip createEnemyShip(TypeEShip typeEShip, float x, float y) {
		Polygon areaEShip = new Polygon();
		float[] widthHeight = typeEShip.getAreaEShip();
		float xOrigin = widthHeight[0] / 2;
		float yOrigin = widthHeight[1] / 2;
		float[] areaVertices = new float[] {
				x, y,
				x, y + widthHeight[1],
				x + widthHeight[0], y + widthHeight[1],
				x + widthHeight[0], y
		};
		areaEShip.setOrigin(xOrigin, yOrigin);
		areaEShip.setPosition(x, y);
		areaEShip.setVertices(areaVertices);
		areaEShip.setRotation(180);
		
		EnemyShip enemyShip = new EnemyShip(typeEShip, typeEShip.getAttackBehaviorEShip(),
				config, areaEShip);	
		enemyShip.setWidthHeight(widthHeight);
//		enemyShip.setSpeed(300f); //TODO to get from enum 1) Kamikaze
		enemyShip.setSpeed(100f);
		
		return enemyShip;
	}

}
