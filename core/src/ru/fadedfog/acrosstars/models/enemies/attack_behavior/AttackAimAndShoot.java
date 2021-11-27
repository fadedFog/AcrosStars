package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.projectile.Projectile;

public class AttackAimAndShoot implements AttackBehavior {
	private final float STRAIGHT_CORNE = 90f;
	private AcrosStarsGame game;
	private EnemyShip ship;
	private long startTime;
	
	public AttackAimAndShoot() {}
	
	public AttackAimAndShoot(AcrosStarsGame game, EnemyShip ship) {
		this.game = game;
		this.ship = ship;
	}

	@Override
	public void attack() {
		SpaceShip spaceShip = game.getSpaceShip();
		Cannon enemyCannon = ship.getCannon();
		float xShip = spaceShip.getCenterPosition().x;
		float yShip = spaceShip.getCenterPosition().y;
		float xCannon = enemyCannon.getX();
		float yCannon = enemyCannon.getY();
		Vector2 vecShip = new Vector2(xShip, yShip);
		Vector2 vecCannon = new Vector2(xCannon, yCannon);
		
		enemyCannon.getAreaObject().setRotation(aiming(vecShip, vecCannon));
		shoot(vecShip, vecCannon, enemyCannon);
	}
	
	private float aiming(Vector2 vecShip, Vector2 vecCannon) {
		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(vecShip.y - vecCannon.y, vecShip.x - vecCannon.x);
		angle -= STRAIGHT_CORNE;
		return angle;
	}
	
	private void shoot(Vector2 vecShip, Vector2 vecCannon, Cannon enemyCannon) {
		if (System.currentTimeMillis() - startTime > 700l) {
			enemyCannon.shoot();
			setVecDirectionProjectile(vecShip, vecCannon, enemyCannon);
			startTime = System.currentTimeMillis();
		}
	}
	
	private void setVecDirectionProjectile(Vector2 vecShip, Vector2 vecCannon, Cannon enemyCannon) {
		int lastId = enemyCannon.getProjectilesOut().size() - 1;
		Projectile lastProjectile = enemyCannon.getProjectilesOut().get(lastId);
		Vector2 vecDirection = vecShip.sub(vecCannon).nor();
		lastProjectile.setVectorDirection(vecDirection);
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
