package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.smnrpn.galaxycrash.hp.HPHandler;
import com.smnrpn.galaxycrash.hp.Heart;
import com.smnrpn.galaxycrash.moving.enemies.Enemy;
import com.smnrpn.galaxycrash.moving.spaceship.Projectile;
import com.smnrpn.galaxycrash.moving.spaceship.Spaceship;
import com.smnrpn.galaxycrash.score.Score;
import com.smnrpn.galaxycrash.scrollable.Backgound;

import java.util.Timer;

public class GameRenderer {
    private GameWorld world;
    public static OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batcher;
    private Backgound bottomBackground;
    private Backgound topBackground;

    private Spaceship userSpaceship;

    private HPHandler hpHandler;
    private Heart firstHeart;
    private Heart secondHeart;
    private Heart thirdHeart;

    private int gameHeight;
    private int gameWidth;

    private Timer timer;
    private Score score;

    public GameRenderer(GameWorld world, int gameHeight, int gameWidth) {
        this.world = world;
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;

        userSpaceship = world.getUserSpaceship();

        hpHandler = world.getHpHandler();
        firstHeart = hpHandler.getFirstHeart();
        secondHeart = hpHandler.getSecondHeart();
        thirdHeart = hpHandler.getThirdHeart();

        bottomBackground = world.getScroller().getBottomBackground();
        topBackground = world.getScroller().getTopBackground();

        AssetLoader.score.getData().setScale(1.5F);

        timer = new Timer();
        score = new Score();
        timer.schedule(score, 0, 100);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, gameWidth, gameHeight);
        viewport = new ExtendViewport(480, 800, camera);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
    }

    public void render(float runTime) {
        batcher.begin();

        drawBackground();

        drawUserShip(runTime);

        drawProjectiles();

        drawEnemy(runTime);

        drawHPBar();

        drawScore();

        batcher.end();
    }

    public void drawBackground() {
        batcher.draw(AssetLoader.background, bottomBackground.getPosition().x, bottomBackground.getPosition().y);
        batcher.draw(AssetLoader.background, topBackground.getPosition().x, topBackground.getPosition().y);
    }

    public void drawHPBar() {
        if (firstHeart.isLive()) {
            batcher.draw(AssetLoader.heart, Gdx.graphics.getWidth() - 160, Gdx.graphics.getHeight() - 80);
        }

        if (secondHeart.isLive()) {
            batcher.draw(AssetLoader.heart, Gdx.graphics.getWidth() - 118, Gdx.graphics.getHeight() - 80);
        }

        if (thirdHeart.isLive()) {
            batcher.draw(AssetLoader.heart, Gdx.graphics.getWidth() - 76, Gdx.graphics.getHeight() - 80);
        }
    }

    public void drawUserShip(float runTime) {
        batcher.draw((Texture) AssetLoader.userShipAnimation.getKeyFrame(runTime), userSpaceship.getX(), userSpaceship.getY());
    }

    public void drawProjectiles() {
        userSpaceship.fire(userSpaceship.getX() + 65);

        for (Projectile projectile : userSpaceship.getAmmunition()) {
            batcher.draw(AssetLoader.projectileBase, projectile.getX(), projectile.getY());
        }
    }

    public void drawScore() {
        AssetLoader.score.draw(batcher, scoreCreator(), 45, Gdx.graphics.getHeight() - 50);
    }

    public void drawEnemy(float runTime) {
        for (Enemy enemy : world.getEnemyGroup().getGroup()) {
            switch (enemy.getType()) {
                case 0 -> batcher.draw((Texture) AssetLoader.enemyBomberAnimation.getKeyFrame(runTime), enemy.getX(), enemy.getY());
                case 1 -> batcher.draw((Texture) AssetLoader.enemyScoutAnimation.getKeyFrame(runTime), enemy.getX(), enemy.getY());
                case 2 -> batcher.draw((Texture) AssetLoader.enemyCruiserAnimation.getKeyFrame(runTime), enemy.getX(), enemy.getY());
            }
        }
    }

    public String scoreCreator() {
        int scoreLength = String.valueOf(score.getCounter()).length();

        return switch (scoreLength) {
            case 1 -> "0000000" + score.getCounter();
            case 2 -> "000000" + score.getCounter();
            case 3 -> "00000" + score.getCounter();
            case 4 -> "0000" + score.getCounter();
            case 5 -> "000" + score.getCounter();
            case 6 -> "00" + score.getCounter();
            case 7 -> "0" + score.getCounter();
            case 8 -> String.valueOf(score.getCounter());
            default -> "MAX SCORE!!!";
        };
    }

    public Viewport getViewport() {
        return viewport;
    }
}
