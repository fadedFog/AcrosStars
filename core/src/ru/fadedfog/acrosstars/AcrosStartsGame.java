package ru.fadedfog.acrosstars;

import com.badlogic.gdx.ApplicationAdapter;

import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.screens.GameScreen;

public class AcrosStartsGame extends ApplicationAdapter {
	private GameScreen gameScreen;
	private SpaceShip spaceShip;
	
	@Override
	public void create () {
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
	
	private void collisionShapeOfBounds() { // TODO vars from config files
		if (spaceShip.getAreaObject().x < 0) {
			spaceShip.getAreaObject().x = 0;
		}
		
		float widthShip = spaceShip.getAreaObject().width;	
		if (spaceShip.getAreaObject().x + widthShip > 700) {
			spaceShip.getAreaObject().x = 700 - spaceShip.getAreaObject().width;
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
