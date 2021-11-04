package ru.fadedfog.acrosstars.config;

public class Config {
	private String titleWindowGame; // A c r o s s S t a r s
	private int widthWindowGame; // 700
	private int heightWindowGame; // 600
	private int yWindowGame; //50
	private boolean isResizable; //false
	private float widthSpaceShip; //32.0f
	private float heightSpaceShip; //32.0f
	private float startingSpeedSpaceShip; // 10.0f
	private float[] startingColorBG; // [0.1f, 0.1f, 0.1f]
	private float startingAlfaBG; // 1.0f
	
	public String getTitleWindowGame() {
		return titleWindowGame;
	}
	
	public void setTitleWindowGame(String titleWindowGame) {
		this.titleWindowGame = titleWindowGame;
	}
	
	public int getWidthWindowGame() {
		return widthWindowGame;
	}
	
	public void setWidthWindowGame(int widthWindowGame) {
		this.widthWindowGame = widthWindowGame;
	}
	
	public int getHeightWindowGame() {
		return heightWindowGame;
	}
	
	public void setHeightWindowGame(int heightWindowGame) {
		this.heightWindowGame = heightWindowGame;
	}
	
	public int getyWindowGame() {
		return yWindowGame;
	}
	
	public void setyWindowGame(int yWindowGame) {
		this.yWindowGame = yWindowGame;
	}
	
	public boolean isResizable() {
		return isResizable;
	}
	
	public void setResizable(boolean isResizable) {
		this.isResizable = isResizable;
	}
	
	public float getWidthSpaceShip() {
		return widthSpaceShip;
	}
	
	public void setWidthSpaceShip(float widthSpaceShip) {
		this.widthSpaceShip = widthSpaceShip;
	}
	
	public float getHeightSpaceShip() {
		return heightSpaceShip;
	}
	
	public void setHeightSpaceShip(float heightSpaceShip) {
		this.heightSpaceShip = heightSpaceShip;
	}
	
	public float getXSpaceShip() {
		return widthWindowGame / 2f;
	}
	
	public float getYSpaceShip() {
		return (heightWindowGame * 2f) / 100f;
	}
	
	public float getStartingSpeedSpaceShip() {
		return startingSpeedSpaceShip;
	}
	
	public void setStartingSpeedSpaceShip(float startingSpeedSpaceShip) {
		this.startingSpeedSpaceShip = startingSpeedSpaceShip;
	}
	
	public float[] getStartingColorBG() {
		return startingColorBG;
	}
	
	public void setStartingColorBG(float[] startingColorBG) {
		this.startingColorBG = startingColorBG;
	}
	
	public float getStartingAlfaBG() {
		return startingAlfaBG;
	}
	
	public void setStartingAlfaBG(float startingAlfaBG) {
		this.startingAlfaBG = startingAlfaBG;
	}
	
}
