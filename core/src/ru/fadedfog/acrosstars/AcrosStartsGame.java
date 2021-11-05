package ru.fadedfog.acrosstars;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.enemies.TypeEShip;
import ru.fadedfog.acrosstars.screens.GameScreen;

public class AcrosStartsGame extends ApplicationAdapter {
	private GameConfig config;
	private GameScreen gameScreen;
	private SpaceShip spaceShip;
	private List<EnemyShip> enemyShips;
	
	@Override
	public void create () {
		config = GameConfig.getInstance();
		spaceShip = new SpaceShip();
		enemyShips = new ArrayList<EnemyShip>();
		createEnemyShips();
		gameScreen = new GameScreen(this);
	}

	private void createEnemyShips() { // TODO get map of ships for game
		Rectangle areaPawn = new Rectangle();
		areaPawn = new Rectangle();
		areaPawn.height = 32f;
		areaPawn.width = 32f;
		areaPawn.x = (700f / 2f);
		areaPawn.y = 550f;
		EnemyShip pawnDemo = new EnemyShip(TypeEShip.PAWN, config, areaPawn);
		
		enemyShips.add(pawnDemo);
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

	public List<EnemyShip> getEnemyShips() {
		return enemyShips;
	}

	public void setEnemyShips(List<EnemyShip> enemyShips) {
		this.enemyShips = enemyShips;
	}

}
