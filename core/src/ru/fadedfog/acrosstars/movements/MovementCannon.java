package ru.fadedfog.acrosstars.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;

public class MovementCannon {
	
	public void rotate(Polygon areaObject) {
		float xMouse = Gdx.input.getX();
		float yMouse = Gdx.input.getY();
		//TODO Demo
		float rotation = areaObject.getRotation();
		rotation += 50 * Gdx.graphics.getDeltaTime(); 
		areaObject.setRotation(rotation);
	}

}
