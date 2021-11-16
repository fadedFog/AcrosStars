package ru.fadedfog.acrosstars.models.cannon;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

import ru.fadedfog.acrosstars.models.projectile.Projectile;
import ru.fadedfog.acrosstars.movements.MovementCannon;

public class Cannon {
	private Polygon areaObject;
	private float[] widthHeight;
	private TypeCannon typeCannon;
	private List<Projectile> projectilesOut;
	private MovementCannon movement;
	
	public Cannon(TypeCannon typeCannon) {
		this.typeCannon = typeCannon;
		widthHeight = typeCannon.getAreaCannon();
		areaObject = new Polygon();
		projectilesOut = new ArrayList<>();
		movement = new MovementCannon();
	}
	
	public void rotate() {
		movement.rotate(areaObject);
	}
	
	public void shoot() {
		Projectile projectile = new Projectile(typeCannon.getTypeProjectile());
		positioningBullet(projectile);
		projectilesOut.add(projectile);
	}
	
	private void positioningBullet(Projectile projectile) {
		updateWidthAndHeight();
		Polygon areaProjectile = projectile.getAreaObject();
		float x = areaObject.getX() + widthHeight[0] / 2.5f;
		float y = areaObject.getY() + widthHeight[1];
		float width = projectile.getWidth();
		float height = projectile.getHeight();
		float xOrigin = 0;
		float yOrigin = -getHeight();
		float[] areaVertices = new float[] {
			x, y,
			x, y + height,
			x + width, y + height,
			x + width, y
		};
		areaProjectile.setRotation(areaObject.getRotation());
		areaProjectile.setOrigin(xOrigin, yOrigin);
		areaProjectile.setPosition(x, y);
		areaProjectile.setVertices(areaVertices);
		Vector2 posProjectile = new Vector2(x, y);
		Vector2 posMouse = movement.getMousePosition();
		projectile.setVectorDirection(posMouse.sub(posProjectile).nor());
	}
	
	private void updateWidthAndHeight() {
		int lastY = areaObject.getVertices().length - 1;
		float width = areaObject.getVertices()[lastY - 1] - areaObject.getVertices()[0];
		float height = areaObject.getVertices()[5] - areaObject.getVertices()[1];
		widthHeight = new float[] {width, height};
	} 
	
	public float getX() {
		return areaObject.getX();
	}
	
	public float getY() {
		return areaObject.getY();
	}
	
	public void setXY(float x, float y) {
		areaObject.setPosition(x, y);
	}

	public float getWidth() {
		return widthHeight[0];
	}
	
	public void setWidth(float width) {
		widthHeight[0] = width;
	}
	
	public float getHeight() {
		return widthHeight[1];
	}
	
	public void setHeight(float height) {
		widthHeight[1] = height;
	}

	public float getRotation() {
		return areaObject.getRotation();
	}
	
	public void setRotation(float rotation) {
		areaObject.setRotation(rotation);
	}
	
	public Polygon getAreaObject() {
		return areaObject;
	}

	public void setAreaObject(Polygon areaObject) {
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
