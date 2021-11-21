package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class AttackKamikaze implements AttackBehavior {
	private AcrosStarsGame game;
	private EnemyShip eShip;
	
	public AttackKamikaze() {}
	
	public AttackKamikaze(AcrosStarsGame game, EnemyShip eShip) {
		this.game = game;
		this.eShip = eShip;
	}

	@Override
	public void attack() {
		float xEShip = eShip.getAreaObject().getX();
		float yEShip = eShip.getAreaObject().getX();
		float xShip = game.getSpaceShip().getCenterPosition().x;
		float yShip = game.getSpaceShip().getCenterPosition().y;
		
		System.out.println(xEShip + " " + yEShip);
		System.out.println(xShip + " " + yShip + " \n");
	}
	
	@Override
	public void setGame(AcrosStarsGame game) {
		this.game = game;
	}

	public EnemyShip getEnemyShip() {
		return eShip;
	}

	public void setEnemyShip(EnemyShip eShip) {
		this.eShip = eShip;
	}

	
}
