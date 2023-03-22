package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class AssetLoader {
    public static Texture background;
    public static Texture userShip;

    public void loadImages() {
        background = new Texture(Gdx.files.internal("space-backgrounds/bg_big.png"));
        userShip = new Texture(Gdx.files.internal("ships/user-ships/13B_custom.png"));
    }

    public void dispose() {
        background.dispose();
        userShip.dispose();
    }
}
