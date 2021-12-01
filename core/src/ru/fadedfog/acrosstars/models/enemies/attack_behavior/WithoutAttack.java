package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class WithoutAttack implements AttackBehavior{
	private EnemyShip enemyShip;
	
	@Override
	public void attack() {
	}

	@Override
	public void setEnemyShip(EnemyShip enemyShip) {
		this.enemyShip = enemyShip;
	}

	@Override
	public EnemyShip getEnemyShip() {
		return enemyShip;
	}

	@Override
	public void setGame(AcrosStarsGame game) {
		
	}

	@Override
	public void setTimeAim(float time) {
	}

	@Override
	public void setTimeToShoot(float time) {
	}

}
