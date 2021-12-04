package ru.fadedfog.acrosstars.config;


public class GameConfig {
	private final String PATH_CONFIG_FILE = "src/ru/fadedfog/acrosstars/resources/game_config.json";
	private static GameConfig gameConfig;
	private ReaderConfig reader;
	private WriterConfig writer;
	private Config config;
	
	private GameConfig() {
		reader = new ReaderConfig(PATH_CONFIG_FILE);
		writer = new WriterConfig(PATH_CONFIG_FILE);
		config = Config.getInstance();
	}
	
	public static GameConfig getInstance() {
		if (gameConfig == null) {
			gameConfig = new GameConfig();
		}
		return gameConfig;
	}
	
	public void readConfig() {
		config = reader.read(this);
	}
	
	public void writeConfig() {
		writer.write(config);
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
	
	public String getTitleWindowGame() {
		return config.getTitleWindowGame();
	}
	
	public void setTitleWindowGame(String titleWindowGame) {
		config.setTitleWindowGame(titleWindowGame);;
	}
	
	public int getWidthWindowGame() {
		return config.getWidthWindowGame();
	}
	
	public void setWidthWindowGame(int widthWindowGame) {
		config.setWidthWindowGame(widthWindowGame);
	}
	
	public int getHeightWindowGame() {
		return config.getHeightWindowGame();
	}
	
	public void setHeightWindowGame(int heightWindowGame) {
		config.setHeightWindowGame(heightWindowGame);
	}
	
	public int getyWindowGame() {
		return config.getyWindowGame();
	}
	
	public void setyWindowGame(int yWindowGame) {
		config.setyWindowGame(yWindowGame);
	}
	
	public boolean isResizable() {
		return config.isResizable();
	}
	
	public void setResizable(boolean isResizable) {
		config.setResizable(isResizable);
	}
	
	public float getWidthSpaceShip() {
		return config.getWidthSpaceShip();
	}
	
	public void setWidthSpaceShip(float widthSpaceShip) {
		config.setWidthSpaceShip(widthSpaceShip);
	}
	
	public float getHeightSpaceShip() {
		return config.getHeightSpaceShip();
	}
	
	public void setHeightSpaceShip(float heightSpaceShip) {
		config.setHeightSpaceShip(heightSpaceShip);
	}
	
	public float getXSpaceShip() {
		return config.getXSpaceShip();
	}
	
	public float getYSpaceShip() {
		return config.getYSpaceShip();
	}
	
	public float getStartingSpeedSpaceShip() {
		return config.getStartingSpeedSpaceShip();
	}
	
	public void setStartingSpeedSpaceShip(float startingSpeedSpaceShip) {
		config.setStartingSpeedSpaceShip(startingSpeedSpaceShip);
	}
	
	public float[] getStartingColorBG() {
		return config.getStartingColorBG();
	}
	
	public void setStartingColorBG(float[] startingColorBG) {
		config.setStartingColorBG(startingColorBG);
	}
	
	public float getStartingAlfaBG() {
		return config.getStartingAlfaBG();
	}
	
	public void setStartingAlfaBG(float startingAlfaBG) {
		config.setStartingAlfaBG(startingAlfaBG);
	}
	
	public float getWidthEPawn() {
		return config.getWidthEPawn();
	}

	public void setWidthEPawn(float widthEPawn) {
		config.setWidthEPawn(widthEPawn);
	}

	public float getHeightEPawn() {
		return config.getHeightEPawn();
	}

	public void setHeightEPawn(float heightEPawn) {
		config.setHeightEPawn(heightEPawn);
	}

	public float getWidthEBastion() {
		return config.getWidthEBastion();
	}

	public void setWidthEBastion(float widthEBastion) {
		config.setWidthEBastion(widthEBastion);
	}

	public float getHeightEBastion() {
		return config.getHeightEBastion();
	}

	public void setHeightEBastion(float heightEBastion) {
		config.setHeightEBastion(heightEBastion);
	}

	public float getWidthEKamikaza() {
		return config.getWidthEKamikaza();
	}

	public void setWidthEKamikaza(float widthEKamikaza) {
		config.setWidthEKamikaza(widthEKamikaza);
	}

	public float getHeightEKamikaza() {
		return config.getHeightEKamikaza();
	}

	public void setHeightEKamikaza(float heightEKamikaza) {
		config.setHeightEKamikaza(heightEKamikaza);
	}
	
	public float getWidthBulletAssault() {
		return config.getWidthBulletAssault();
	}

	public void setWidthBulletAssault(float widthBulletAssault) {
		config.setWidthBulletAssault(widthBulletAssault);
	}

	public float getHeightBulletAssault() {
		return config.getHeightBulletAssault();
	}

	public void setHeightBulletAssault(float heightBulletAssault) {
		config.setHeightBulletAssault(heightBulletAssault);
	}

	public float getWidthRocket() {
		return config.getWidthRocket();
	}

	public void setWidthRocket(float widthRocket) {
		config.setWidthRocket(widthRocket);
	}

	public float getHeightRocket() {
		return config.getHeightRocket();
	}

	public void setHeightRocket(float heightRocket) {
		config.setHeightRocket(heightRocket);
	}

	public float getWidthLaser() {
		return config.getWidthLaser();
	}

	public void setWidthLaser(float widthLaser) {
		config.setWidthLaser(widthLaser);
	}

	public float getHeightLaser() {
		return config.getHeightLaser();
	}

	public void setHeightLaser(float heightLaser) {
		config.setHeightLaser(heightLaser);
	}

	public float getWidthAssaultGun() {
		return config.getWidthAssaultGun();
	}

	public void setWidthAssaultGun(float widthAssaultGun) {
		config.setWidthAssaultGun(widthAssaultGun);
	}

	public float getHeightAssaultGun() {
		return config.getHeightAssaultGun();
	}

	public void setHeightAssaultGun(float heightAssaultGun) {
		config.setHeightAssaultGun(heightAssaultGun);
	}

	public float getWidthRocketLauncher() {
		return config.getWidthRocketLauncher();
	}

	public void setWidthRocketLauncher(float widthRocketLauncher) {
		config.setWidthRocketLauncher(widthRocketLauncher);
	}

	public float getHeightRocketLauncher() {
		return config.getHeightRocketLauncher();
	}

	public void setHeightRocketLauncher(float heightRocketLauncher) {
		config.setHeightRocketLauncher(heightRocketLauncher);
	}

	public float getWidthLasertGun() {
		return config.getWidthLasertGun();
	}

	public void setWidthLasertGun(float widthLasertGun) {
		config.setWidthLasertGun(widthLasertGun);
	}

	public float getHeightLaserGun() {
		return config.getHeightLaserGun();
	}

	public void setHeightLaserGun(float heightLaserGun) {
		config.setHeightLaserGun(heightLaserGun);
	}
	
	public float getShiftDistance() {
		return config.getShiftDistance();
	}

	public void setShiftDistance(float shiftDistance) {
		config.setShiftDistance(shiftDistance);
	}
	
	public float getHpSpaceShip() {
		return config.getHpSpaceShip();
	}

	public void setHpSpaceShip(float hpSpaceShip) {
		config.setHpSpaceShip(hpSpaceShip);
	}

	public float getHpShipEPawn() {
		return config.getHpShipEPawn();
	}

	public void setHpShipEPawn(float hpShipEPawn) {
		config.setHpShipEPawn(hpShipEPawn);
	}

	public float getHpShipEBastion() {
		return config.getHpShipEBastion();
	}

	public void setHpShipEBastion(float hpShipEBastion) {
		config.setHpShipEBastion(hpShipEBastion);
	}

	public float getHpShipEKamikaze() {
		return config.getHpShipEKamikaze();
	}

	public void setHpShipEKamikaze(float hpShipEKamikaze) {
		config.setHpShipEKamikaze(hpShipEKamikaze);
	}
	
}
