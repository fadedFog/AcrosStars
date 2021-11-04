package ru.fadedfog.acrosstars.config;

import java.io.File;
import java.io.IOException;

public class GameConfig {
	private final String PATH_CONFIG_FILE = "src/ru/fadedfog/acrosstars/resources/game_config.json";
	private static GameConfig gameConfig;
	private ReaderConfig reader;
	private WriterConfig writer;
	private Config config;
	
	private GameConfig() {
		File file = new File(PATH_CONFIG_FILE);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader = new ReaderConfig(PATH_CONFIG_FILE);
		writer = new WriterConfig(PATH_CONFIG_FILE);
		config = new Config();
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
	
}
