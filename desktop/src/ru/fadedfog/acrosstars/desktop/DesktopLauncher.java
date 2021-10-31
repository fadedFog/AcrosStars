package ru.fadedfog.acrosstars.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.fadedfog.acrosstars.AcrosStartsGame;

public class DesktopLauncher {
	public static void main (String[] arg) { //TODO vars to config file
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "A c r o s s S t a r s";
		config.width = 700;
		config.height = 600;
		config.resizable = false;
		new LwjglApplication(new AcrosStartsGame(), config);
	}
}
