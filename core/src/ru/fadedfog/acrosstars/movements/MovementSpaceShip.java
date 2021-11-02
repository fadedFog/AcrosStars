package ru.fadedfog.acrosstars.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

public class MovementSpaceShip {
	private final int A_KEY = Input.Keys.A;
	private final int D_KEY = Input.Keys.D;
	
	public void move(Rectangle rectangle) {
		moveSpaceShip(rectangle);
	}
	
	private void moveSpaceShip(Rectangle rectangle) { // TODO vars from config file
		if (Gdx.input.isKeyPressed(A_KEY)) {
			rectangle.x -= 10f;
		}
		if (Gdx.input.isKeyPressed(D_KEY)) {
			rectangle.x += 10f;
		}
	}
}
