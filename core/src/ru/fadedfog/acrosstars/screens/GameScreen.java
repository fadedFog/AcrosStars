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
import ru.fadedfog.acrosstars.models.cannon.Cannon;
import ru.fadedfog.acrosstars.models.cannon.TypeCannon;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.enemies.TypeEShip;
import ru.fadedfog.acrosstars.models.projectile.Projectile;
import ru.fadedfog.acrosstars.models.projectile.TypeProjectile;

public class GameScreen implements Screen {
	private GameConfig config;
	private SpriteBatch batch;
	private AcrosStartsGame game;
	private Texture spriteSpaceShip;
	private Texture spriteAssaultGun;
	private Texture spriteRocketLauncher;
	private Texture spriteLaserGun;
	private Texture spriteBullet;
	private Texture spriteRocket;
	private Texture spriteLaser;
	private Texture spriteEPawn;
	private Texture spriteEBastion;
	private Texture spriteEKamikaze;
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
		createSpritesWeapons();
		createSpriteEnemyShips();
	}
	
	private void createSpritesWeapons() {
		spriteAssaultGun = new Texture(Gdx.files.internal("assault_gun.png"));
		spriteRocketLauncher = new Texture(Gdx.files.internal("rocket_launcher.png"));
		spriteLaserGun = new Texture(Gdx.files.internal("laser_gun.png"));
		spriteBullet = new Texture(Gdx.files.internal("bullet.png"));
		spriteRocket = new Texture(Gdx.files.internal("rocket.png"));
		spriteLaser = new Texture(Gdx.files.internal("laser.png"));
	}
	
	private void createSpriteEnemyShips() {
		spriteEPawn = new Texture(Gdx.files.internal("e_pawn.png"));
		spriteEBastion = new Texture(Gdx.files.internal("e_bastion.png"));
		spriteEKamikaze= new Texture(Gdx.files.internal("e_kamikaze.png"));
	}
	
	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(RGB[0], RGB[1], RGB[2], alpha);
		renderSpaceShip();
		renderWeapons();
		renderEnemyShips();
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
		batch.begin();
		
		Cannon cannon = game.getSpaceShip().getCannon();
		float xGun = cannon.getX();
		float yGun = cannon.getY();
		float widthGun = cannon.getAreaObject().width;
		float heigthGun = cannon.getAreaObject().height; 
		Texture spriteCannon = getSpriteCannon(cannon.getTypeCannon());
		batch.draw(spriteCannon, xGun, yGun, widthGun, heigthGun);
		
		for (Projectile projectile: cannon.getProjectilesOut()) {
			float xProjectile = projectile.getX();
			float yProjectile = projectile.getY();
			float widthProjectile = projectile.getAreaObject().width;
			float heigthProjectile = projectile.getAreaObject().height; 
			
			Texture spritePorjectile = getSpriteProjectileByTypeCannon(projectile.getTypeProjectile());
			batch.draw(spritePorjectile, xProjectile, yProjectile, widthProjectile, heigthProjectile);
		}
		
		batch.end();
	}
	
	private Texture getSpriteCannon(TypeCannon typeCannon) {
		Texture spriteCannon;
		
		switch (typeCannon) {
			case ROCKET_LAUNCHER:
				spriteCannon = spriteRocketLauncher;
				break;
			case LASER_GUN:
				spriteCannon = spriteLaserGun;
				break;
			default:
				spriteCannon = spriteAssaultGun;
				break;
		}
		
		return spriteCannon;
	}
	
	
	private Texture getSpriteProjectileByTypeCannon(TypeProjectile typeProjectile) {
		Texture spriteProjectile;
		
		switch (typeProjectile) {
			case ROCKET:
				spriteProjectile = spriteRocket;
				break;
			case LASER:
				spriteProjectile = spriteLaser;
				break;
			default:
				spriteProjectile = spriteBullet;
				break;
		}
		
		return spriteProjectile;
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
