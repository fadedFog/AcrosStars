package ru.fadedfog.acrosstars.config;

public class Config {
	private static Config config;
	private String titleWindowGame;
	private int widthWindowGame;
	private int heightWindowGame;
	private int yWindowGame;
	private boolean isResizable;
	private float widthSpaceShip; 
	private float heightSpaceShip;
	private float startingSpeedSpaceShip; 
	private float[] startingColorBG;
	private float startingAlfaBG;
	
	private float widthEPawn; 
	private float heightEPawn;
	private float widthEBastion; 
	private float heightEBastion;
	private float widthEKamikaza; 
	private float heightEKamikaza;
	
	private float widthAssaultGun;
	private float heightAssaultGun;
	private float widthRocketLauncher;
	private float heightRocketLauncher;
	private float widthLasertGun;
	private float heightLaserGun;
	
	private Config() {
	}
	
	public static Config getInstance() {
		if (config == null) {
			config = new Config();
		}
		return config;
	}
	
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

	public float getWidthEPawn() {
		return widthEPawn;
	}

	public void setWidthEPawn(float widthEPawn) {
		this.widthEPawn = widthEPawn;
	}

	public float getHeightEPawn() {
		return heightEPawn;
	}

	public void setHeightEPawn(float heightEPawn) {
		this.heightEPawn = heightEPawn;
	}

	public float getWidthEBastion() {
		return widthEBastion;
	}

	public void setWidthEBastion(float widthEBastion) {
		this.widthEBastion = widthEBastion;
	}

	public float getHeightEBastion() {
		return heightEBastion;
	}

	public void setHeightEBastion(float heightEBastion) {
		this.heightEBastion = heightEBastion;
	}

	public float getWidthEKamikaza() {
		return widthEKamikaza;
	}

	public void setWidthEKamikaza(float widthEKamikaza) {
		this.widthEKamikaza = widthEKamikaza;
	}

	public float getHeightEKamikaza() {
		return heightEKamikaza;
	}

	public void setHeightEKamikaza(float heightEKamikaza) {
		this.heightEKamikaza = heightEKamikaza;
	}

	public float getWidthAssaultGun() {
		return widthAssaultGun;
	}

	public void setWidthAssaultGun(float widthAssaultGun) {
		this.widthAssaultGun = widthAssaultGun;
	}

	public float getHeightAssaultGun() {
		return heightAssaultGun;
	}

	public void setHeightAssaultGun(float heightAssaultGun) {
		this.heightAssaultGun = heightAssaultGun;
	}

	public float getWidthRocketLauncher() {
		return widthRocketLauncher;
	}

	public void setWidthRocketLauncher(float widthRocketLauncher) {
		this.widthRocketLauncher = widthRocketLauncher;
	}

	public float getHeightRocketLauncher() {
		return heightRocketLauncher;
	}

	public void setHeightRocketLauncher(float heightRocketLauncher) {
		this.heightRocketLauncher = heightRocketLauncher;
	}

	public float getWidthLasertGun() {
		return widthLasertGun;
	}

	public void setWidthLasertGun(float widthLasertGun) {
		this.widthLasertGun = widthLasertGun;
	}

	public float getHeightLaserGun() {
		return heightLaserGun;
	}

	public void setHeightLaserGun(float heightLaserGun) {
		this.heightLaserGun = heightLaserGun;
	}

}
