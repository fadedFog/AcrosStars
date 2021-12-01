package ru.fadedfog.acrosstars.models.enemies.move_behavior;

import com.badlogic.gdx.Gdx;

import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class MoveDown implements MoveBehavior {
	private EnemyShip enemyShip;
	
	@Override
	public void move() {
		float xEShip = enemyShip.getAreaObject().getX();
		float yEShip = enemyShip.getAreaObject().getY();
		yEShip -=  enemyShip.getSpeed() * Gdx.graphics.getDeltaTime(); 
		
		enemyShip.getAreaObject().setPosition(xEShip, yEShip);
	}

	@Override
	public void setEnemyShip(EnemyShip ship) {
		this.enemyShip = ship;
	}

	@Override
	public EnemyShip getEnemyShip() {
		return enemyShip;
	}
	
}
