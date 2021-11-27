package ru.fadedfog.acrosstars.models.enemies.move_behavior;

import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public interface MoveBehavior {

	public void move();
	
	public void setEnemyShip(EnemyShip ship);
	
	public EnemyShip getEnemyShip();
	
}
