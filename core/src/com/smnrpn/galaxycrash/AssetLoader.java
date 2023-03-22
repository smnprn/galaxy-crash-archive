package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AssetLoader {
    public static Texture background;
    public static Texture userShip;
    public static Texture explosion;
    public static TextureRegion projectileBase;

    public void loadImages() {
        background = new Texture(Gdx.files.internal("space-backgrounds/bg_big.png"));
        userShip = new Texture(Gdx.files.internal("ships/user-ships/13B_custom.png"));
        explosion = new Texture(Gdx.files.internal("fire/explosions.png"));

        projectileBase = new TextureRegion(explosion, 1, 43, 30, 30);
    }

    public void dispose() {
        background.dispose();
        userShip.dispose();
        explosion.dispose();
    }
}
