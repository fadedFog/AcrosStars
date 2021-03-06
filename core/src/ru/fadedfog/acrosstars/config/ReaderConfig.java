package ru.fadedfog.acrosstars.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class ReaderConfig {
	private String pathFile;

	public ReaderConfig(String pathFile) {
		this.pathFile = pathFile;
	}
	
	public Config read(GameConfig gameConfig) {
		File jsonFile = new File(pathFile);
		Config config = null;
		try {
			config = readConfig(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return config;
	}
	
	private Config readConfig(File jsonFile) throws FileNotFoundException {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(jsonFile));
		return gson.fromJson(reader, Config.class);
	}

}
