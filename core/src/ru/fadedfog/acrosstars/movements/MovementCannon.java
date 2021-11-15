package ru.fadedfog.acrosstars.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;

import ru.fadedfog.acrosstars.config.GameConfig;

public class MovementCannon {
	private final float STRAIGHT_CORNE = 90f;
	private final float DIGITS_BEFORE_DOT = 2;
	
	public void rotate(Polygon areaObject) {
		float xMouse = Gdx.input.getX();
		float yMouse = GameConfig.getInstance().getHeightWindowGame() - Gdx.input.getY();
		float xObject = areaObject.getX() + areaObject.getOriginX();
		float yObject = areaObject.getY() +  areaObject.getOriginY();
		
		float distanceX = xMouse - xObject;
		float distanceY = (float) ( Math.sqrt( Math.pow(xMouse - xObject, 2) 
								+ Math.pow(yMouse - yObject, 2) ));
		float dividedXY = distanceX / distanceY;
		float sinCorner = (float) Math.sin(dividedXY);
		float corner = STRAIGHT_CORNE - 
				sinCorner * (float) (Math.pow(10, DIGITS_BEFORE_DOT));
		
		areaObject.setRotation((corner - STRAIGHT_CORNE));
	}
	
}
