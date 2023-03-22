package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
    private final GameRenderer renderer;
    private final GameWorld world;
    private float runTime;

    public GameScreen() {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();

        world = new GameWorld();

        renderer = new GameRenderer(world, screenHeight, screenWidth);

        Gdx.input.setInputProcessor(new InputHandler(world.getUserSpaceship()));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
