package ru.fadedfog.acrosstars.models.cannon;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;

import ru.fadedfog.acrosstars.models.projectile.Projectile;

public class Cannon {
	private Rectangle areaObject;
	private TypeCannon typeCannon;
	private List<Projectile> projectilesOut;
	
	public Cannon(TypeCannon typeCannon) {
		this.typeCannon = typeCannon;
		areaObject = typeCannon.getAreaCannon();
		projectilesOut = new ArrayList<>();
	}
	
	public void shoot() {
		Projectile projectile = new Projectile(typeCannon.getTypeProjectile());
		positioningBullet(projectile);
		projectilesOut.add(projectile);
	}
	
	private void positioningBullet(Projectile projectile) {
		projectile.setX(areaObject.x + areaObject.width / 2.5f);
		projectile.setY(areaObject.y + areaObject.height);
	}
	
	public float getX() {
		return areaObject.x;
	}
	
	public void setX(float x) {
		areaObject.x = x;
	}
	
	public float getY() {
		return areaObject.y;
	}
	
	public void setY(float y) {
		areaObject.y = y;
	}

	public float getWidth() {
		return areaObject.width;
	}
	
	public void setWidth(float width) {
		areaObject.width = width;
	}
	
	public float getHeight() {
		return areaObject.height;
	}
	
	public void setHeight(float height) {
		areaObject.height = height;
	}

	
	public Rectangle getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Rectangle areaObject) {
		this.areaObject = areaObject;
	}

	public TypeCannon getTypeCannon() {
		return typeCannon;
	}

	public void setTypeCannon(TypeCannon typeCannon) {
		this.typeCannon = typeCannon;
	}

	public List<Projectile> getProjectilesOut() {
		return projectilesOut;
	}

	public void setProjectilesOut(List<Projectile> projectilesOut) {
		this.projectilesOut = projectilesOut;
	}
	
}
