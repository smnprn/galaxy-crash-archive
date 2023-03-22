package com.smnrpn.galaxycrash;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.smnrpn.galaxycrash.Main;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
        config.setWindowedMode(480, 800);
        config.useVsync(true);
		config.setTitle("galaxy-crash");
		new Lwjgl3Application(new Main(), config);
	}
}
