package com.smnrpn.galaxycrash.scrollable;

import com.badlogic.gdx.math.Vector2;

public class Scrollable {
    protected Vector2 position;
    protected Vector2 velocity;
    protected int height;
    protected int width;
    protected boolean isScrolled;

    public Scrollable(float x, float y, int height, int width, float scrollSpeed) {
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, scrollSpeed);
        this.height = height;
        this.width = width;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));

        if (position.y + height < 0) {
            isScrolled = true;
        }
    }

    public void reset(float resetY) {
        position.y = resetY;
        isScrolled = false;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isScrolled() {
        return isScrolled;
    }
}
