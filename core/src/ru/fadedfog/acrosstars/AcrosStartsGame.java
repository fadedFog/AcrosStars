package ru.fadedfog.acrosstars;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.enemies.FactorySpaceShip;
import ru.fadedfog.acrosstars.models.enemies.TypeEShip;
import ru.fadedfog.acrosstars.models.projectile.Projectile;
import ru.fadedfog.acrosstars.screens.GameScreen;

public class AcrosStartsGame extends ApplicationAdapter {
	private GameConfig config;
	private GameScreen gameScreen;
	private FactorySpaceShip factorySpaceShip;
	private SpaceShip spaceShip;
	private List<EnemyShip> enemyShips;
	
	@Override
	public void create () {
		config = GameConfig.getInstance();
		factorySpaceShip = FactorySpaceShip.getInstance();
		spaceShip = new SpaceShip();
		enemyShips = new ArrayList<EnemyShip>();
		createEnemyShips();
		gameScreen = new GameScreen(this);
	}

	private void createEnemyShips() { // TODO get map of ships for game
		EnemyShip pawnDemo = factorySpaceShip.createEnemyShip(TypeEShip.PAWN);
		pawnDemo.getAreaObject().x = (700f / 2f);
		pawnDemo.getAreaObject().y = 550f;
		
		EnemyShip kamikazeDemo = factorySpaceShip.createEnemyShip(TypeEShip.KAMIKAZA);
		kamikazeDemo.getAreaObject().x = (700f / 2f) - 100f;
		kamikazeDemo.getAreaObject().y = 550f;
		
		EnemyShip bastionDemo = factorySpaceShip.createEnemyShip(TypeEShip.BASTION);
		bastionDemo.getAreaObject().x = (700f / 2f) + 100f;
		bastionDemo.getAreaObject().y = 550f;
		
		enemyShips.add(pawnDemo);
		enemyShips.add(kamikazeDemo);
		enemyShips.add(bastionDemo);
	}
	
	@Override
	public void render () {
		gameScreen.render(1);
		update();
	}
	
	public void update() {
		spaceShip.move();
		spaceShip.getCannon().rotate();
		spaceShip.shoot();
		updateBullets();
		collisionShapeOfBounds();
	}
	private void updateBullets() {
		List<Projectile> projectilesOfSpaceShip = spaceShip.getCannon().getProjectilesOut();
		for (Projectile projectile: projectilesOfSpaceShip) {
			projectile.fly();
		}
		removeBullets(projectilesOfSpaceShip);
	}
	
	private void removeBullets(List<Projectile> projectiles) {
		List<Projectile> projectileToRemove = new ArrayList<>();
		for (Projectile bullet: projectiles) {
			if (bullet.getY() > config.getHeightWindowGame()) {
				projectileToRemove.add(bullet);
			}
		}
		projectiles.removeAll(projectileToRemove);
	}
	
	
	private void collisionShapeOfBounds() {
		if (spaceShip.getAreaObject().x < 0) {
			spaceShip.getAreaObject().x = 0;
		}
		
		float widthShip = spaceShip.getAreaObject().width;	
		if (spaceShip.getAreaObject().x + widthShip > config.getWidthWindowGame()) {
			spaceShip.getAreaObject().x = config.getWidthWindowGame() - spaceShip.getAreaObject().width;
		}
		spaceShip.positioningGun();
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
