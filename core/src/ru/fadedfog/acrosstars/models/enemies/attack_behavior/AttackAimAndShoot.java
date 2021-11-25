package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import com.badlogic.gdx.math.MathUtils;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class AttackAimAndShoot implements AttackBehavior {
	private final float STRAIGHT_CORNE = 90f;
	private AcrosStarsGame game;
	private EnemyShip ship;
	
	public AttackAimAndShoot() {}
	
	public AttackAimAndShoot(AcrosStarsGame game, EnemyShip ship) {
		this.game = game;
		this.ship = ship;
	}

	@Override
	public void attack() {
		aiming();
	}
	
	private void aiming() {
		SpaceShip spaceShip = game.getSpaceShip();
		Cannon cannon = ship.getCannon();
		float xShip = spaceShip.getCenterPosition().x;
		float yShip = spaceShip.getCenterPosition().y;
		float xCannon = cannon.getX();
		float yCannon = cannon.getY();
		
		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(yShip - yCannon, xShip - xCannon);
		angle -= STRAIGHT_CORNE;
		
		cannon.getAreaObject().setRotation(angle);
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
