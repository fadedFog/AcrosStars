package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class AttackKamikaze implements AttackBehavior {
	private AcrosStarsGame game;
	private EnemyShip eShip;
	private SpaceShip spaceShip;
	private final float STRAIGHT_CORNE = 90f;
	private Vector2 vectorDirection;
	private long startTime;
	
	public AttackKamikaze() {
		vectorDirection = new Vector2();
	}
	
	public AttackKamikaze(AcrosStarsGame game, EnemyShip eShip) {
		this.game = game;
		this.eShip = eShip;
	}

	@Override
	public void attack() {
		if (spaceShip == null) {
			spaceShip = game.getSpaceShip();
		}
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
	
	private void rotateEShip() {
		Vector2 centerEShip = eShip.getCenterPosition();
		float xCShip = game.getSpaceShip().getCenterPosition().x; 
		float yCShip = spaceShip.getCenterPosition().y;

		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(centerEShip.y - yCShip, centerEShip.x - xCShip);
		angle -= STRAIGHT_CORNE;
		eShip.getAreaObject().setRotation(angle);
	}
	
	private void updateDirecton() {
		float xEShip = eShip.getAreaObject().getX();
		float yEShip = eShip.getAreaObject().getY();
		Vector2 posShip = new Vector2(spaceShip.getAreaObject().x, spaceShip.getAreaObject().y);
		Vector2 posEShip = new Vector2(xEShip, yEShip);
		
		vectorDirection.set(posShip.sub(posEShip).nor());
	}
	
	private void moveEShip() {
		float xEShip = eShip.getAreaObject().getX();
		float yEShip = eShip.getAreaObject().getY();
		xEShip += vectorDirection.x * eShip.getSpeed() * Gdx.graphics.getDeltaTime();
		yEShip += vectorDirection.y * eShip.getSpeed() * Gdx.graphics.getDeltaTime();
		
		eShip.getAreaObject().setPosition(xEShip, yEShip);
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
