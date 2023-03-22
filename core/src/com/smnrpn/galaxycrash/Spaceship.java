package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Spaceship {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private int height;
    private int width;
    SwipeHandler swipeHandler;

    public Spaceship(float x, float y, int height, int width) {
        this.height = height;
        this.width = width;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);

        swipeHandler = new SwipeHandler();
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
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

    public void onClick() {
        System.out.println("boom");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }
}
