package ru.fadedfog.acrosstars.models.enemies.move_behavior;

import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class WithoutMove implements MoveBehavior {
	private EnemyShip enemyShip;
	
	@Override
	public void move() {
		
	}

	@Override
	public void setEnemyShip(EnemyShip enemyShip) {
		this.enemyShip = enemyShip;
	}

	@Override
	public EnemyShip getEnemyShip() {
		return enemyShip;
	}

}
