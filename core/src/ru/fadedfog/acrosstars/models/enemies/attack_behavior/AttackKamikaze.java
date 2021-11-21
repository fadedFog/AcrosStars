package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class AttackKamikaze implements AttackBehavior {
	private AcrosStarsGame game;
	private EnemyShip ship;
	
	public AttackKamikaze() {}
	
	public AttackKamikaze(AcrosStarsGame game, EnemyShip ship) {
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

	public EnemyShip getShip() {
		return ship;
	}

	public void setShip(EnemyShip ship) {
		this.ship = ship;
	}
	
}
