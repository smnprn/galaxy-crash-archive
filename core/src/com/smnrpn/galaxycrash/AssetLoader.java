package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AssetLoader {
    public static Texture background;
    public static Texture userShip;
    public static Texture explosion;
    public static Texture heart;
    public static TextureRegion projectileBase;

    public static Music backgroundMusic;

    public static BitmapFont score;

    public void loadImages() {
        background = new Texture(Gdx.files.internal("space-backgrounds/bg_big.png"));
        userShip = new Texture(Gdx.files.internal("ships/user-ships/13B_custom.png"));
        explosion = new Texture(Gdx.files.internal("fire/explosions.png"));
        heart = new Texture(Gdx.files.internal("hearts/heart_32x32.png"));

        projectileBase = new TextureRegion(explosion, 1, 43, 30, 30);
    }

    public void loadSound() {
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/music/placeholder_music.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
    }

    public void loadFont() {
        score = new BitmapFont(Gdx.files.internal("font/gameover/72.fnt"), false);
    }

    public void dispose() {
        background.dispose();
        userShip.dispose();
        explosion.dispose();
        heart.dispose();

        backgroundMusic.dispose();
    }
}
