package ru.fadedfog.acrosstars;

import com.badlogic.gdx.ApplicationAdapter;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.screens.GameScreen;

public class AcrosStartsGame extends ApplicationAdapter {
	private GameConfig config;
	private GameScreen gameScreen;
	private SpaceShip spaceShip;
	
	@Override
	public void create () {
		config = GameConfig.getInstance();
		spaceShip = new SpaceShip();
		gameScreen = new GameScreen(this);
	}

	@Override
	public void render () {
		gameScreen.render(1);
		update();
	}
	
	public void update() {
		spaceShip.move();
		collisionShapeOfBounds();
	}
	
	private void collisionShapeOfBounds() {
		if (spaceShip.getAreaObject().x < 0) {
			spaceShip.getAreaObject().x = 0;
		}
		
		float widthShip = spaceShip.getAreaObject().width;	
		if (spaceShip.getAreaObject().x + widthShip > config.getWidthWindowGame()) {
			spaceShip.getAreaObject().x = config.getWidthWindowGame() - spaceShip.getAreaObject().width;
		}
	}
	
	@Override
	public void dispose () {
	}

	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	public void setSpaceShip(SpaceShip spaceShip) {
		this.spaceShip = spaceShip;
	}
}
