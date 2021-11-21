package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class AttackAimAndShoot implements AttackBehavior {
	private AcrosStarsGame game;
	private EnemyShip ship;
	
	public AttackAimAndShoot() {}
	
	public AttackAimAndShoot(AcrosStarsGame game, EnemyShip ship) {
		this.game = game;
		this.ship = ship;
	}

	@Override
	public void attack() {
		
	}
	
	@Override
	public void setGame(AcrosStarsGame game) {
		this.game = game;
	}

	public EnemyShip getEnemyShip() {
		return ship;
	}

	public void setEnemyShip(EnemyShip ship) {
		this.ship = ship;
	}
	
}
