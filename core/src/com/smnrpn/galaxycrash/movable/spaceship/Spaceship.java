package com.smnrpn.galaxycrash.movable.spaceship;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.movable.Movable;

public class Spaceship extends Movable {
    SwipeHandler swipeHandler;
    Projectile projectile;

    public Spaceship(float x, float y, int height, int width, Projectile projectile) {
        super(x, y, height, width);
        this.projectile = projectile;
        swipeHandler = new SwipeHandler();
    }

    public void onSwipeRight() {
        if (swipeHandler.isSwipRight()) {
            position.x = Gdx.input.getX() - 50;
        }
    }

    public void onSwipeLeft() {
        if (swipeHandler.isSwipLeft()) {
            position.x = Gdx.input.getX() - 50;
        }
    }
}
