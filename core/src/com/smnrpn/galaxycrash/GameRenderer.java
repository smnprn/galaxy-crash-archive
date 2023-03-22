package com.smnrpn.galaxycrash;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRenderer {
    private GameWorld world;
    private OrthographicCamera camera;
    private SpriteBatch batcher;

    private int gameHeight;
    private int gameWidth;

    public GameRenderer(GameWorld world, int gameHeight, int gameWidth) {
        this.world = world;
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, gameWidth, gameHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
    }

    public void render(float runTime) {
        batcher.begin();
        batcher.draw(AssetLoader.background, 0, 0);
        batcher.draw(AssetLoader.userShip, world.getUserSpaceship().getX(), world.getUserSpaceship().getY());
        batcher.end();
    }
}
