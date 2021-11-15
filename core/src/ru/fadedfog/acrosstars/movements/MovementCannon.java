package ru.fadedfog.acrosstars.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;


public class MovementCannon {
	private final float STRAIGHT_CORNE = 90f;
	
	public void rotate(Polygon areaObject) {
		float xMouse = Gdx.input.getX();
		float yMouse = Gdx.graphics.getHeight() - Gdx.input.getY();
		float xObject = areaObject.getX() + areaObject.getOriginX();
		float yObject = areaObject.getY() +  areaObject.getOriginY();
		
		float angle = MathUtils.radiansToDegrees * MathUtils.atan2(yMouse - yObject, xMouse - xObject);
		angle -= STRAIGHT_CORNE;
		
		areaObject.setRotation(angle);
	}
	
}
