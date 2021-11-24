package ru.fadedfog.acrosstars.models.enemies.attack_behavior;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.models.enemies.EnemyShip;
import ru.fadedfog.acrosstars.models.projectile.Projectile;
import ru.fadedfog.acrosstars.models.projectile.TypeProjectile;

public class AttackUnidirectional implements AttackBehavior {
	private AcrosStarsGame game;
	private EnemyShip eShip;
	private TypeProjectile typeProjectile;
	private long startTime;
	
	public AttackUnidirectional() {
		typeProjectile = TypeProjectile.BULLET_ASSAULT;
	}
	
	public AttackUnidirectional(AcrosStarsGame game, EnemyShip eShip) {
		this.game = game;
		this.eShip = eShip;
	}

	@Override
	public void attack() {
		moveEShip();
		
		if (isTimeShoot()) {
			shoot();
		}
	}
	
	private boolean isTimeShoot() {
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		}
		return System.currentTimeMillis() - startTime > 1000;
	}
	
	private void moveEShip() {
		float xEShip = eShip.getAreaObject().getX();
		float yEShip = eShip.getAreaObject().getY();
		yEShip -=  eShip.getSpeed() * Gdx.graphics.getDeltaTime(); 
		
		eShip.getAreaObject().setPosition(xEShip, yEShip);
	}
	
	public void shoot() {
		Projectile projectile = new Projectile(typeProjectile);
		positioningBullet(projectile);
		projectile.setVectorDirection(new Vector2(0, -1f));
		game.addProjectile(projectile);
		startTime = System.currentTimeMillis();
	}
	
	private void positioningBullet(Projectile projectile) {
		Polygon areaProjectile = projectile.getAreaObject();
		float x = eShip.getAreaObject().getX() + eShip.getWidth() / 2f;
		float y = eShip.getAreaObject().getY();
		float width = projectile.getWidth();
		float height = projectile.getHeight();
		float xOrigin = 0;
		float yOrigin = 0;
		float[] areaVertices = new float[] {
				x, y,
				x, y + height,
				x + width, y + height,
				x + width, y
		};
		areaProjectile.setOrigin(xOrigin, yOrigin);
		areaProjectile.setPosition(x, y);
		areaProjectile.setVertices(areaVertices);
		projectile.setSpeedProjectile(30f);
	}
	
	@Override
	public void setGame(AcrosStarsGame game) {
		this.game = game;
	}

	public EnemyShip getEnemyShip() {
		return eShip;
	}

	public void setEnemyShip(EnemyShip eShip) {
		this.eShip = eShip;
	}
	
}
