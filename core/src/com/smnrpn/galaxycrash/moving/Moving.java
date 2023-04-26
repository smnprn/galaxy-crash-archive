package com.smnrpn.galaxycrash.moving;

import com.badlogic.gdx.math.Vector2;

public abstract class Moving {
    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 acceleration;
    protected int height;
    protected int width;

    public Moving(float x, float y, int height, int width) {
        this.height = height;
        this.width = width;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }

    public Moving(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }
}
