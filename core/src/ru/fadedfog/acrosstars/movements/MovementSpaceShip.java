package ru.fadedfog.acrosstars.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.Gun;

public class MovementSpaceShip {
	private GameConfig config;
	private final int A_KEY = Input.Keys.A;
	private final int D_KEY = Input.Keys.D;
	
	public MovementSpaceShip() {
		config = GameConfig.getInstance();
	}
	
	public void move(Rectangle rectangle) {
		moveSpaceShip(rectangle);
	}
	
	private void moveSpaceShip(Rectangle rectangle) {
		if (Gdx.input.isKeyPressed(A_KEY)) {
			rectangle.x -= config.getStartingSpeedSpaceShip();
		}
		if (Gdx.input.isKeyPressed(D_KEY)) {
			rectangle.x += config.getStartingSpeedSpaceShip();
		}
	}
	
	public void shoot(Gun gun) {
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			gun.shoot();
		}
	}
	
}
