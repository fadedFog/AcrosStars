package ru.fadedfog.acrosstars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.fadedfog.acrosstars.screens.GameScreen;

public class AcrosStartsGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private GameScreen gameScreen;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gameScreen = new GameScreen();
	}

	@Override
	public void render () {
		gameScreen.render(1);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
