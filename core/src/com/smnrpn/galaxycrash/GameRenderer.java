package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.smnrpn.galaxycrash.movable.spaceship.Projectile;
import com.smnrpn.galaxycrash.scrollable.Backgound;

public class GameRenderer {
    private GameWorld world;
    public static OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batcher;
    private Backgound bottomBackground;
    private Backgound topBackground;

    private int gameHeight;
    private int gameWidth;

    public GameRenderer(GameWorld world, int gameHeight, int gameWidth) {
        this.world = world;
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;

        bottomBackground = world.getScroller().getBottomBackground();
        topBackground = world.getScroller().getTopBackground();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, gameWidth, gameHeight);
        viewport = new ExtendViewport(480, 800, camera);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
    }

    public void render(float runTime) {
        batcher.begin();

        drawBackground();

        drawHPBar();

        drawUserShip();

        drawProjectiles();

        batcher.end();
    }

    public void drawBackground() {
        batcher.draw(AssetLoader.background, bottomBackground.getPosition().x, bottomBackground.getPosition().y);
        batcher.draw(AssetLoader.background, topBackground.getPosition().x, topBackground.getPosition().y);
    }

    public void drawHPBar() {
        if (world.getHpHandler().getFirstHeart().isLive()) {
            batcher.draw(AssetLoader.heart, 550, Gdx.graphics.getHeight() - 80);
        }

        if (world.getHpHandler().getSecondHeart().isLive()) {
            batcher.draw(AssetLoader.heart, 550 + 32 + 10, Gdx.graphics.getHeight() - 80);
        }

        if (world.getHpHandler().getThirdHeart().isLive()) {
            batcher.draw(AssetLoader.heart, 550 + 32 + 32 + 20, Gdx.graphics.getHeight() - 80);
        }
    }

    public void drawUserShip() {
        batcher.draw(AssetLoader.userShip, world.getUserSpaceship().getX(), world.getUserSpaceship().getY());
    }

    public void drawProjectiles() {
        for (Projectile projectile : world.getAmmunition()) {
            projectile.fire(world.getUserSpaceship().getX() + 65);
            batcher.draw(AssetLoader.projectileBase, projectile.getX(), projectile.getY());
        }
    }

    public Viewport getViewport() {
        return viewport;
    }
}
