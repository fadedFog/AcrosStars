package ru.fadedfog.acrosstars.screens;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.config.GameConfig;
import ru.fadedfog.acrosstars.models.SpaceShip;
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.cannon.TypeCannon;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.enemies.TypeEShip;
import ru.fadedfog.acrosstars.models.projectile.Projectile;
import ru.fadedfog.acrosstars.models.projectile.TypeProjectile;

public class GameScreen implements Screen {
	private GameConfig config;
	private SpriteBatch batch;
	
	private ShapeRenderer shapeRenderer;
	
	private AcrosStarsGame game;
	private Sprite spriteSpaceShip;
	private Sprite spriteAssaultGun;
	private Sprite spriteRocketLauncher;
	private Sprite spriteNoneGun;
	private Sprite spriteLaserGun;
	private Sprite spriteBullet;
	private Sprite spriteRocket;
	private Sprite spriteLaser;
	private Sprite spriteEPawn;
	private Sprite spriteEBastion;
	private Sprite spriteEKamikaze;
	private float[] RGB;
	private float alpha;
	
	public GameScreen(AcrosStarsGame game) {
		config = GameConfig.getInstance();
		RGB = config.getStartingColorBG();
		alpha = config.getStartingAlfaBG();
		batch = new SpriteBatch();
		this.game = game;

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(game.getCamera().combined);
		
		createSprites();
	}
	
	private void createSprites() {
		spriteSpaceShip = new Sprite(new Texture(Gdx.files.internal("rect_spaceship.png")));
		createSpritesWeapons();
		createSpriteEnemyShips();
	}
	
	private void createSpritesWeapons() {
		spriteNoneGun = new Sprite(new Texture(Gdx.files.internal("none_gun.png")));
		spriteAssaultGun = new Sprite(new Texture(Gdx.files.internal("assault_gun.png")));
		spriteRocketLauncher = new Sprite(new Texture(Gdx.files.internal("rocket_launcher.png")));
		spriteLaserGun = new Sprite(new Texture(Gdx.files.internal("laser_gun.png")));
		spriteBullet = new Sprite(new Texture(Gdx.files.internal("bullet.png")));
		spriteRocket = new Sprite(new Texture(Gdx.files.internal("rocket.png")));
		spriteLaser = new Sprite(new Texture(Gdx.files.internal("laser.png")));
	}
	
	private void createSpriteEnemyShips() {
		spriteEPawn = new Sprite(new Texture(Gdx.files.internal("e_pawn.png")));
		spriteEBastion = new Sprite(new Texture(Gdx.files.internal("e_bastion.png")));
		spriteEKamikaze= new Sprite(new Texture(Gdx.files.internal("e_kamikaze.png")));
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		batch.setProjectionMatrix(game.getCamera().combined);
		ScreenUtils.clear(RGB[0], RGB[1], RGB[2], alpha);
		renderSpaceShip();
		renderEnemyShips();
		renderWeapons();
	}
	
	private void renderSpaceShip() {
		batch.begin();
		SpaceShip spaceShip = game.getSpaceShip();
		float xShip = spaceShip.getAreaObject().x;
		float yShip = spaceShip.getAreaObject().y;
		float widthShip = spaceShip.getAreaObject().width;
		float heigthShip = spaceShip.getAreaObject().height;
		
		batch.draw(spriteSpaceShip, xShip, yShip, widthShip, heigthShip);
		
		batch.end();
	}
	
	public void renderWeapons() { //TODO add switch for different cannons and projectiles
		List<Cannon> cannons = new ArrayList<>();
		cannons.add(game.getSpaceShip().getCannon());
		for (EnemyShip eShip: game.getEnemyShips()) {
			cannons.add(eShip.getCannon());
		}
		
		batch.begin();
		
		for (Cannon cannon: cannons) {
			float xGun = cannon.getX();
			float yGun = cannon.getY();
			float xOrigin = cannon.getAreaObject().getOriginX();
			float yOrigin = cannon.getAreaObject().getOriginY();
			float widthGun = cannon.getWidth();
			float heigthGun = cannon.getHeight(); 
			float xScale = cannon.getAreaObject().getScaleX();
			float yScale = cannon.getAreaObject().getScaleY();
			float rotation = cannon.getRotation();
			Sprite spriteCannon = getSpriteCannon(cannon.getTypeCannon());
			batch.draw(spriteCannon, 
					xGun, yGun, 
					xOrigin, yOrigin, 
					widthGun, heigthGun, 
					yScale, xScale, 
					rotation);
		}
		
		List<Projectile> projectiles = game.getSpaceShip().getCannon().getProjectilesOut();
		projectiles.addAll(game.getProjectiles());
		for (Projectile projectile: projectiles) {
			float xProjectile = projectile.getX();
			float yProjectile = projectile.getY();
			float xOriginProjectile = projectile.getAreaObject().getOriginX();
			float yOriginProjectile = projectile.getAreaObject().getOriginY();
			float widthProjectile = projectile.getWidth();
			float heigthProjectile = projectile.getHeight(); 
			float xScaleProjectile = projectile.getAreaObject().getScaleX();
			float yScaleProjectile = projectile.getAreaObject().getScaleY();
			float roataionxProjectile = projectile.getAreaObject().getRotation();
			
			Sprite spritePorjectile = getSpriteProjectileByTypeCannon(projectile.getTypeProjectile());
			batch.draw(spritePorjectile, 
					xProjectile, yProjectile, 
					xOriginProjectile, yOriginProjectile, 
					widthProjectile, heigthProjectile, 
					xScaleProjectile, yScaleProjectile, 
					roataionxProjectile);
		}
		
		batch.end();
	}
	
	private Sprite getSpriteCannon(TypeCannon typeCannon) {
		Sprite spriteCannon;
		
		switch (typeCannon) {
			case ROCKET_LAUNCHER:
				spriteCannon = spriteRocketLauncher;
				break;
			case LASER_GUN:
				spriteCannon = spriteLaserGun;
				break;
			case ASSAULT_GUN:
				spriteCannon = spriteAssaultGun;
				break;
			default:
				spriteCannon = spriteNoneGun;
				break;
		}
		
		return spriteCannon;
	}
	
	
	private Sprite getSpriteProjectileByTypeCannon(TypeProjectile typeProjectile) {
		Sprite spriteProjectile;
		
		switch (typeProjectile) {
			case ROCKET:
				spriteProjectile = spriteRocket;
				break;
			case LASER:
				spriteProjectile = spriteLaser;
				break;
			case BULLET_ASSAULT:
				spriteProjectile = spriteBullet;
				break;
			default:
				spriteProjectile = null; //TODO change null
				break;
		}
		
		return spriteProjectile;
	}
	
	private void renderEnemyShips() { // TODO change to correct
		ArrayList<EnemyShip> eShips = (ArrayList<EnemyShip>) game.getEnemyShips();
		batch.begin();
		
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(0, 1, 0, 1);
		
		for (EnemyShip eShip: eShips) {
			float xShipe = eShip.getAreaObject().getX();
			float yShipe = eShip.getAreaObject().getY();
			float xOriginShip = eShip.getAreaObject().getOriginX();
			float yOriginShip = eShip.getAreaObject().getOriginY();
			float widthShip = eShip.getWidth();
			float heigthShip = eShip.getHeight();
			float xScaleShip = eShip.getAreaObject().getScaleX();
			float yScaleShip = eShip.getAreaObject().getScaleY();
			float roataionShip = eShip.getAreaObject().getRotation();
			
			Sprite spriteEnemyShip = getSpriteEnemyShip(eShip.getTypeShip());
			batch.draw(spriteEnemyShip, 
					xShipe, yShipe, 
					xOriginShip, yOriginShip, 
					widthShip, heigthShip, 
					xScaleShip, yScaleShip, 
					roataionShip);
			
			shapeRenderer.polygon(eShip.getAreaObject().getTransformedVertices());
		}
		
		shapeRenderer.end();
		batch.end();
	}
	
	private Sprite getSpriteEnemyShip(TypeEShip typeEShip) { 
		Sprite spriteEShip;
		
		switch (typeEShip) {
			case PAWN:
				spriteEShip = spriteEPawn;
				break;
			case BASTION:
				spriteEShip = spriteEBastion;
				break;
			case KAMIKAZA:
				spriteEShip = spriteEKamikaze;
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
