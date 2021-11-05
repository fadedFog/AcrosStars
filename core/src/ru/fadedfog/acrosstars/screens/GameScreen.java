package ru.fadedfog.acrosstars.screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.fadedfog.acrosstars.AcrosStartsGame;
import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.enemies.TypeEShip;

public class GameScreen implements Screen {
	private GameConfig config;
	private SpriteBatch batch;
	private AcrosStartsGame game;
	private Texture spriteSpaceShip;
	private Texture spriteEPawn;
	private float[] RGB;
	private float alpha;
	
	public GameScreen(AcrosStartsGame game) {
		config = GameConfig.getInstance();
		RGB = config.getStartingColorBG();
		alpha = config.getStartingAlfaBG();
		batch = new SpriteBatch();
		this.game = game;
		createSprites();
	}
	
	private void createSprites() {
		spriteSpaceShip = new Texture(Gdx.files.internal("rect_spaceship.png"));
		createSpriteEnemyShips();
	}
	
	private void createSpriteEnemyShips() {
		spriteEPawn = new Texture(Gdx.files.internal("e_pawn.png"));
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(RGB[0], RGB[1], RGB[2], alpha);
		renderSpaceShip();
		renderEnemyShips();
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
	
	private void renderEnemyShips() {
		ArrayList<EnemyShip> eShips = (ArrayList<EnemyShip>) game.getEnemyShips();
		batch.begin();
		
		for (EnemyShip eShip: eShips) {
			float xShape = eShip.getAreaObject().x;
			float yShape = eShip.getAreaObject().y;
			float widthShape = eShip.getAreaObject().width;
			float heigthShape = eShip.getAreaObject().height;
			
			Texture spriteEnemyShip = getSpriteEnemyShip(eShip.getTypeShip());
			batch.draw(spriteEnemyShip, xShape, yShape, widthShape, heigthShape);
		}
		
		batch.end();
	}
	
	private Texture getSpriteEnemyShip(TypeEShip typeEShip) { 
		Texture spriteEShip;
		
		switch (typeEShip) {
			case PAWN:
				spriteEShip = spriteEPawn;
				break;
			default:
				spriteEShip = null;
				break;
		}
		
		return spriteEShip;
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
