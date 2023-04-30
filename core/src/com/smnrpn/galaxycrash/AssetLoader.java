package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AssetLoader {
    public static Texture background;
    public static Texture userShip, userShipLights;
    public static Animation userShipAnimation;
    public static Texture explosion;
    public static Texture heart;
    public static Texture enemyBomber, enemyBomberLights;
    public static Texture enemyScout, enemyScoutLights;
    public static Texture enemyCruiser, enemyCruiserLights;
    public static Animation enemyBomberAnimation, enemyScoutAnimation, enemyCruiserAnimation;
    public static TextureRegion projectileBase;

    public static Music backgroundMusic;

    public static BitmapFont score;

    public void loadImages() {
        background = new Texture(Gdx.files.internal("space-backgrounds/bg_big.png"));

        userShip = new Texture(Gdx.files.internal("ships/user-ships/13B_custom.png"));
        userShipLights = new Texture(Gdx.files.internal("ships/user-ships/13B_custom-Lights.png"));

        explosion = new Texture(Gdx.files.internal("fire/explosions.png"));

        heart = new Texture(Gdx.files.internal("hearts/heart_32x32.png"));

        enemyBomber = new Texture(Gdx.files.internal("ships/enemy-ships/Alien-Bomber.png"));
        enemyBomberLights = new Texture(Gdx.files.internal("ships/enemy-ships/Alien-Bomber-Lights.png"));

        enemyScout = new Texture(Gdx.files.internal("ships/enemy-ships/Alien-Scout.png"));
        enemyScoutLights = new Texture(Gdx.files.internal("ships/enemy-ships/Alien-Scout-Lights.png"));

        enemyCruiser = new Texture(Gdx.files.internal("ships/enemy-ships/Alien-Cruiser.png"));
        enemyCruiserLights = new Texture(Gdx.files.internal("ships/enemy-ships/Alien-Cruiser-Lights.png"));

        loadAnimations();

        projectileBase = new TextureRegion(explosion, 1, 43, 30, 30);
    }

    public void loadAnimations() {
        Texture[] enemyBombers = {enemyBomber, enemyBomberLights};
        enemyBomberAnimation = new Animation<Texture>(0.5F, enemyBombers);
        enemyBomberAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        Texture[] enemyScouts = {enemyScout, enemyScoutLights};
        enemyScoutAnimation = new Animation<Texture>(0.5F, enemyScouts);
        enemyScoutAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        Texture[] enemyCruisers = {enemyCruiser, enemyCruiserLights};
        enemyCruiserAnimation = new Animation<Texture>(0.5F, enemyCruisers);
        enemyCruiserAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        Texture[] userShips = {userShip, userShipLights};
        userShipAnimation = new Animation<Texture>(1F, userShips);
        userShipAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
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
