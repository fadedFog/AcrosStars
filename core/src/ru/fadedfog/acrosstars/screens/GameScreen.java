package ru.fadedfog.acrosstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.fadedfog.acrosstars.AcrosStartsGame;
import ru.fadedfog.acrosstars.models.SpaceShip;

public class GameScreen implements Screen {
	private SpriteBatch batch;
	private AcrosStartsGame game;
	private Texture spriteSpaceShip;
	
	public GameScreen(AcrosStartsGame game) {
		batch = new SpriteBatch();
		this.game = game;
		createSprites();
	}
	
	private void createSprites() {
		spriteSpaceShip = new Texture(Gdx.files.internal("rect_spaceship.png"));
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) { // TODO vars to config file
		ScreenUtils.clear(0.1f, 0.1f, 0.1f, 1);
		renderSpaceShip();
	}
	
	private void renderSpaceShip() {
		batch.begin();
		
		SpaceShip spaceShip = game.getSpaceShip();
		float xShape = spaceShip.getAreaObject().x;
		float yShape = spaceShip.getAreaObject().y;
		float widthShape = spaceShip.getAreaObject().width;
		float heigthShape = spaceShip.getAreaObject().height;
		
		batch.draw(spriteSpaceShip, xShape, yShape, widthShape, heigthShape);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	
}
