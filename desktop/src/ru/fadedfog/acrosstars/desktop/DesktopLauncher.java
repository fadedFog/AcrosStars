package ru.fadedfog.acrosstars.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ru.fadedfog.acrosstars.AcrosStarsGame;
import ru.fadedfog.acrosstars.config.GameConfig;

public class DesktopLauncher {
	public static void main (String[] arg) { 
		GameConfig gameConfig = GameConfig.getInstance();
		gameConfig.readConfig();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = gameConfig.getTitleWindowGame();
		config.width = gameConfig.getWidthWindowGame();
		config.height = gameConfig.getHeightWindowGame();
		config.y = gameConfig.getyWindowGame();
		config.resizable = gameConfig.isResizable();
		new LwjglApplication(new AcrosStarsGame(), config);
	}
}
