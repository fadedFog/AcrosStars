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
	private Vector2 lastPosShip;
	private long startTime;
	
	public AttackAimAndShoot() {
		lastPosShip = new Vector2();
	}
	
	@Override
	public void attack() {
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		
		SpaceShip spaceShip = game.getSpaceShip();
		Cannon enemyCannon = ship.getCannon();
		float xCannon = enemyCannon.getX();
		float yCannon = enemyCannon.getY();
		Vector2 vecShip = positionSpaceShip(spaceShip);
		Vector2 vecCannon = new Vector2(xCannon, yCannon);
		
		
		if (System.currentTimeMillis() - startTime < 1000l) {
			enemyCannon.getAreaObject().setRotation(aiming(vecShip, vecCannon));
		}
		
		if (System.currentTimeMillis() - startTime > 1500l) {
			shoot(vecShip, vecCannon, enemyCannon);
		}
	}
	
	private Vector2 positionSpaceShip(SpaceShip spaceShip) {
		float xShip;
		float yShip;
		if (System.currentTimeMillis() - startTime < 1000l) {
			xShip = spaceShip.getCenterPosition().x;
			yShip = spaceShip.getCenterPosition().y;
			lastPosShip.set(xShip, yShip);
		} else {
			xShip = lastPosShip.x;
			yShip = lastPosShip.y;
		}
		
		return new Vector2(xShip, yShip);
	}
	
	private float aiming(Vector2 vecShip, Vector2 vecCannon) {
		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(vecShip.y - vecCannon.y, vecShip.x - vecCannon.x);
		angle -= STRAIGHT_CORNE;
		return angle;
	}
	
	private void shoot(Vector2 vecShip, Vector2 vecCannon, Cannon enemyCannon) {
		enemyCannon.shoot();
		setVecDirectionProjectile(vecShip, vecCannon, enemyCannon);
		startTime = System.currentTimeMillis();
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
