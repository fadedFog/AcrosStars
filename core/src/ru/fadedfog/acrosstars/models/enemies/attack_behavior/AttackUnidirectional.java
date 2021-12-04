package ru.fadedfog.acrosstars.models.enemies.attack_behavior;


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
	
	@Override
	public void attack() {
		if (isTimeShoot()) {
			shoot();
		}
	}
	
	private boolean isTimeShoot() {
		return System.currentTimeMillis() - startTime > 1000;
	}
	
	public void shoot() {
		Projectile projectile = new Projectile(typeProjectile);
		positioningProjectile(projectile);
		
		Vector2 vectorDirection = getVectorDirection();
		projectile.setVectorDirection(new Vector2(vectorDirection));
		projectile.getAreaObject().setRotation(eShip.getAreaObject().getRotation());
		
		game.addProjectile(projectile);
		startTime = System.currentTimeMillis();
	}
	
	private Vector2 getVectorDirection() {
		Polygon areaShip = eShip.getAreaObject();
		float[] verticesOfShip = areaShip.getTransformedVertices();
		Vector2 posFirst = new Vector2(verticesOfShip[0], verticesOfShip[1]);
		Vector2 posLast = new Vector2(verticesOfShip[6], verticesOfShip[7]);
		
		float xMid = (posFirst.x + posLast.x) / 2;
		float yMid = (posFirst.y + posLast.y) / 2;
		Vector2 posMid = new Vector2(xMid, yMid);
		
		float a = posFirst.y - posLast.y;
		float b = posLast.x - posFirst.x;
		b *= -1;
		a *= -1;
		
		float norm = (float) Math.sqrt(a * a + b * b);
		a /= norm;
		b /= norm;
		
		float xStraight = posMid.x + a * 10;
		float yStraight = posMid.y + b * 10;
		Vector2 posStraight = new Vector2(xStraight, yStraight);
		
		return posStraight.sub(posMid).nor();
	}
	
	private void positioningProjectile(Projectile projectile) {
		Polygon areaProjectile = projectile.getAreaObject();
		
		float[] verticesOfShip = eShip.getAreaObject().getTransformedVertices();
		Vector2 posFirst = new Vector2(verticesOfShip[0], verticesOfShip[1]);
		Vector2 posLast = new Vector2(verticesOfShip[6], verticesOfShip[7]);
		Vector2 distance = new Vector2(posFirst.x - posLast.x, posFirst.y - posLast.y);
		
		float x = posFirst.x + (distance.x / 2 * -1);
		float y = posFirst.y + (distance.y / 2 * -1);
		
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

	@Override
	public void setTimeAim(float time) {
	}

	@Override
	public void setTimeToShoot(float time) {
	}
	
}
