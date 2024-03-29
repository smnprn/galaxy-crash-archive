package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import java.util.Timer;

public class Main extends Game {
    AssetLoader assetLoader = new AssetLoader();

    @Override
	public void create () {
		assetLoader.loadImages();
        assetLoader.loadSound();
        assetLoader.loadFont();
        setScreen(new GameScreen());
	}

    @Override
    public void dispose() {
        super.dispose();
        assetLoader.dispose();
    }

}
