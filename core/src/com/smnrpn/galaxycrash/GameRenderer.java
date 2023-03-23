package com.smnrpn.galaxycrash;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.smnrpn.galaxycrash.movable.spaceship.Projectile;
import com.smnrpn.galaxycrash.scrollable.Backgound;

public class GameRenderer {
    private GameWorld world;
    private OrthographicCamera camera;
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
        batcher.draw(AssetLoader.background, bottomBackground.getPosition().x, bottomBackground.getPosition().y);
        batcher.draw(AssetLoader.background, topBackground.getPosition().x, topBackground.getPosition().y);
        batcher.draw(AssetLoader.userShip, world.getUserSpaceship().getX(), world.getUserSpaceship().getY());
        for (Projectile projectile : world.getAmmunition()) {
            projectile.fire(world.getUserSpaceship().getX() + 65);
            batcher.draw(AssetLoader.projectileBase, projectile.getX(), projectile.getY());
        }
        /*
        world.getProjectile().fire(world.getUserSpaceship().getX() + 65);
        batcher.draw(AssetLoader.projectileBase, world.getProjectile().getX(), world.getProjectile().getY());
         */
        batcher.end();
    }

    public Viewport getViewport() {
        return viewport;
    }
}
