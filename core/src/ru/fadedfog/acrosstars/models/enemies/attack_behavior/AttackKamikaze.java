package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class AttackKamikaze implements AttackBehavior {
	private AcrosStarsGame game;
	private EnemyShip eShip;
	private final float STRAIGHT_CORNE = 90f;
	
	public AttackKamikaze() {}
	
	public AttackKamikaze(AcrosStarsGame game, EnemyShip eShip) {
		this.game = game;
		this.eShip = eShip;
	}

	@Override
	public void attack() {
		Vector2 centerEShip = eShip.getCenterPosition();
		float xShip = game.getSpaceShip().getCenterPosition().x;
		float yShip = game.getSpaceShip().getCenterPosition().y;
		
		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(centerEShip.y - yShip, centerEShip.x - xShip);
		angle -= STRAIGHT_CORNE;
		
		eShip.getAreaObject().setRotation(angle);
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
