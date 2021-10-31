package ru.fadedfog.acrosstars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class AcrosStartsGame extends ApplicationAdapter {
	private SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
