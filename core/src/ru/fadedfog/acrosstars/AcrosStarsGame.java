package ru.fadedfog.acrosstars;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.enemies.FactorySpaceShip;
import ru.fadedfog.acrosstars.models.enemies.TypeEShip;
import ru.fadedfog.acrosstars.models.projectile.Projectile;
import ru.fadedfog.acrosstars.screens.GameScreen;

public class AcrosStarsGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private Viewport viewport;
	private GameConfig config;
	private GameScreen gameScreen;
	private FactorySpaceShip factorySpaceShip;
	private SpaceShip spaceShip;
	private List<EnemyShip> enemyShips;
	
	@Override
	public void create () {
		config = GameConfig.getInstance();
		createCameraViewport();
		factorySpaceShip = FactorySpaceShip.getInstance();
		spaceShip = new SpaceShip();
		enemyShips = new ArrayList<EnemyShip>();
		createEnemyShips();
		gameScreen = new GameScreen(this);
	}

	private void createCameraViewport() {
		camera = new OrthographicCamera();
		float widthWindow = config.getWidthWindowGame();
		float heightWindow = config.getHeightWindowGame();
		camera.position.set(widthWindow / 2, heightWindow / 2, 0);
		viewport = new FitViewport(widthWindow, heightWindow, camera);
		viewport.apply();
	}
	
	private void createEnemyShips() { // TODO get map of ships for game
		EnemyShip pawnDemo = factorySpaceShip.createEnemyShip(TypeEShip.PAWN);
		pawnDemo.getAreaObject().x = (700f / 2f);
		pawnDemo.getAreaObject().y = 550f;
		pawnDemo.getAttackBehavior().setGame(this);
		
		EnemyShip kamikazeDemo = factorySpaceShip.createEnemyShip(TypeEShip.KAMIKAZA);
		kamikazeDemo.getAreaObject().x = (700f / 2f) - 100f;
		kamikazeDemo.getAreaObject().y = 550f;
		kamikazeDemo.getAttackBehavior().setGame(this);
		
		EnemyShip bastionDemo = factorySpaceShip.createEnemyShip(TypeEShip.BASTION);
		bastionDemo.getAreaObject().x = (700f / 2f) + 100f;
		bastionDemo.getAreaObject().y = 550f;
		bastionDemo.getAttackBehavior().setGame(this);
		
		enemyShips.add(pawnDemo);
		enemyShips.add(kamikazeDemo);
		enemyShips.add(bastionDemo);
	}
	
	@Override
	public void render () {
		camera.update();
		gameScreen.render(1);
		update();
	}
	
	public void update() {
		spaceShip.move();
		spaceShip.getCannon().rotate();
		spaceShip.shoot();
		updateProjectiles();
		collisionShapeOfBounds();
	}
	private void updateProjectiles() {
		List<Projectile> projectilesOfSpaceShip = spaceShip.getCannon().getProjectilesOut();
		for (Projectile projectile: projectilesOfSpaceShip) {
			projectile.fly();
		}
		removeProjectiles(projectilesOfSpaceShip);
	}
	
	private void removeProjectiles(List<Projectile> projectiles) {
		List<Projectile> projectileToRemove = new ArrayList<>();
		for (Projectile projectile: projectiles) {
			if (!isPolygonContainsGameFiled(projectile.getAreaObject())) {
				projectileToRemove.add(projectile);
			}
		}
		projectiles.removeAll(projectileToRemove);
	}
	
	private boolean isPolygonContainsGameFiled(Polygon polygon) {
		Vector2 posPolygon = new Vector2(polygon.getX(), polygon.getY());
		float width = config.getWidthWindowGame(); 
		float height = config.getHeightWindowGame();
		Rectangle areaWindow = new Rectangle(0, 0, width, height);

		boolean isContains = areaWindow.contains(posPolygon);
		
		return isContains;
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
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
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

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}

	public Viewport getViewport() {
		return viewport;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

}
