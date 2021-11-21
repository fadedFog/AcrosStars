package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public interface AttackBehavior {
	
	public void attack();

	public void setShip(EnemyShip ship);
	
	public EnemyShip getShip();
	
	public void setGame(AcrosStarsGame game);
	
}
