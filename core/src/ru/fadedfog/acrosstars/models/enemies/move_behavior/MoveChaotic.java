package ru.fadedfog.acrosstars.models.enemies.move_behavior;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.models.enemies.EnemyShip;

public class MoveChaotic implements MoveBehavior {
	private EnemyShip enemyShip;
	private Rectangle areaOfMove;
	private Vector2 newPos;
	private Vector2 vectorDirection;
	private long startTime;
	private boolean isMove;
	
	public MoveChaotic() {
		areaOfMove = new Rectangle();
		areaOfMove.x = 0;
		areaOfMove.y = Gdx.graphics.getHeight() / 2;
		areaOfMove.width = Gdx.graphics.getWidth();
		areaOfMove.height = Gdx.graphics.getHeight();
		vectorDirection = new Vector2();
		newPos = new Vector2();
		isMove = false;
	}
	
	@Override
	public void move() {
		if(startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		
		if (System.currentTimeMillis() - startTime > 3000l) {
			if (isMove) {
				moveAnArea();
				if (isAtNewPosition()) {
					isMove = false;
					startTime = System.currentTimeMillis();
				}
			} else {
				updateVecDirection();
				isMove = true;
			}
		}
	}
	
	private void updateVecDirection() {
		float xEShip = enemyShip.getAreaObject().getX();
		float yEShip = enemyShip.getAreaObject().getY();
		float newPosX = (float) (Math.random() * areaOfMove.width);
		float newPosY = areaOfMove.y + (float) (Math.random() *  areaOfMove.y);
		newPos.set(newPosX, newPosY);
		Vector2 newPosClone = new Vector2(newPosX, newPosY);
		
		Vector2 posEShip = new Vector2(xEShip, yEShip);
		vectorDirection.set(newPosClone.sub(posEShip).nor());
	}
	
	private void moveAnArea() {
		float xEShip = enemyShip.getAreaObject().getX();
		float yEShip = enemyShip.getAreaObject().getY();
		xEShip += vectorDirection.x * enemyShip.getSpeed() * Gdx.graphics.getDeltaTime();
		yEShip += vectorDirection.y * enemyShip.getSpeed() * Gdx.graphics.getDeltaTime();
		
		enemyShip.getAreaObject().setPosition(xEShip, yEShip);
	}
	
	private boolean isAtNewPosition() {
		float xEShip = enemyShip.getAreaObject().getX();
		float yEShip = enemyShip.getAreaObject().getY();
		float xNewPos = newPos.x;
		float yNewPos = newPos.y;
		
		Rectangle areaStop = new Rectangle(xNewPos - 5, yNewPos - 5, 10, 10);
		
		boolean isX = xEShip >= areaStop.x && xEShip <= areaStop.x + areaStop.width;
		boolean isY = yEShip >= areaStop.y && yEShip <= areaStop.y + areaStop.height;
		return isX && isY;
	}

	@Override
	public void setEnemyShip(EnemyShip enemyShip) {
		this.enemyShip = enemyShip;
		setMaxPosShip(enemyShip);
	}
	
	private void setMaxPosShip(EnemyShip enemyShip) {
		areaOfMove.y -= enemyShip.getHeight();
		areaOfMove.width -= enemyShip.getWidth();
	}

	@Override
	public EnemyShip getEnemyShip() {
		return enemyShip;
	}

}
