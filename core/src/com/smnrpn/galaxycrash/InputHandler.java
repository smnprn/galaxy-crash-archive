package com.smnrpn.galaxycrash;

import com.badlogic.gdx.InputProcessor;
import com.smnrpn.galaxycrash.moving.spaceship.Spaceship;

public class InputHandler implements InputProcessor {
    private Spaceship userSpaceship;

    public InputHandler(Spaceship userSpaceship) {
        this.userSpaceship = userSpaceship;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        userSpaceship.setUserTouchedFalse();
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        userSpaceship.onSwipeRight();
        userSpaceship.onSwipeLeft();
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
