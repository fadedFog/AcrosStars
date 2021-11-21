package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public interface AttackBehavior {
	
	public void attack();

	public void setEnemyShip(EnemyShip ship);
	
	public EnemyShip getEnemyShip();
	
	public void setGame(AcrosStarsGame game);
	
}
