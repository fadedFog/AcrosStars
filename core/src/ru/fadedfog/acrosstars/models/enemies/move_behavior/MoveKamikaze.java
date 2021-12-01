package ru.fadedfog.acrosstars.models.enemies.move_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class MoveKamikaze implements MoveBehavior {
	private final float STRAIGHT_CORNE = 90f;
	private EnemyShip enemyShip;
	private SpaceShip spaceShip;
	private Vector2 vectorDirection;
	private long startTime;
	
	public MoveKamikaze() {
		AcrosStarsGame game = AcrosStarsGame.getInstance();
		spaceShip = game.getSpaceShip();
		vectorDirection = new Vector2();
	}
	
	@Override
	public void move() {
		if(startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		
		if (System.currentTimeMillis() - startTime > 5000l) {
			moveEShip();
		}
		if (System.currentTimeMillis() - startTime < 6000l) {
			rotateEShip();
			updateDirecton();
		}
	}
	
	private void moveEShip() {
		float xEShip = enemyShip.getAreaObject().getX();
		float yEShip = enemyShip.getAreaObject().getY();
		xEShip += vectorDirection.x * enemyShip.getSpeed() * Gdx.graphics.getDeltaTime();
		yEShip += vectorDirection.y * enemyShip.getSpeed() * Gdx.graphics.getDeltaTime();
		
		enemyShip.getAreaObject().setPosition(xEShip, yEShip);
	}
	
	private void rotateEShip() {
		Vector2 centerEShip = enemyShip.getCenterPosition();
		float xCShip = spaceShip.getCenterPosition().x; 
		float yCShip = spaceShip.getCenterPosition().y;

		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(centerEShip.y - yCShip, centerEShip.x - xCShip);
		angle -= STRAIGHT_CORNE;
		enemyShip.getAreaObject().setRotation(angle);
	}

	private void updateDirecton() {
		float xEShip = enemyShip.getAreaObject().getX();
		float yEShip = enemyShip.getAreaObject().getY();
		Vector2 posShip = new Vector2(spaceShip.getAreaObject().x, spaceShip.getAreaObject().y);
		Vector2 posEShip = new Vector2(xEShip, yEShip);
		
		vectorDirection.set(posShip.sub(posEShip).nor());
	}
	
	@Override
	public void setEnemyShip(EnemyShip ship) {
		this.enemyShip = ship;
	}

	@Override
	public EnemyShip getEnemyShip() {
		return enemyShip;
	}
	
}
