package ru.fadedfog.acrosstars.movements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.cannon.Cannon;

public class MovementSpaceShip {
	private GameConfig config;
	private final int A_KEY = Input.Keys.A;
	private final int D_KEY = Input.Keys.D;
	private final int L_SHIFT_KEY = Input.Keys.SHIFT_LEFT;
	private final int R_KEY = Input.Keys.R;
	
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
	
	public void shift(Rectangle rectangle) {
		shiftSpaceShip(rectangle);
	}
	
	private void shiftSpaceShip(Rectangle rectangle) {
		if (Gdx.input.isKeyPressed(L_SHIFT_KEY)) {
			if (Gdx.input.isKeyJustPressed(A_KEY)) {
				rectangle.x -= 80f;
			}
			if (Gdx.input.isKeyJustPressed(D_KEY)) {
				rectangle.x += 80f;
			}
		}
	}
	
	public void shoot(Cannon cannon) {
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
			cannon.shoot();
		}
	}
	
	public int reload(Cannon cannon) {
		int ammo = -1;
		if (Gdx.input.isKeyJustPressed(R_KEY)) {
			ammo = cannon.getTypeCannon().getStandartAmmo();
		}
		return ammo;
	}
	
}
