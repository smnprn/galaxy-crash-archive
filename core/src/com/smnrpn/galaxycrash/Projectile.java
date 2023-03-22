package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;

public class Projectile extends Movable {
    public Projectile(float x, float y, int height, int width) {
        super(x, y, height, width);
    }

    public void fire() {
        velocity.y = 1100;
    }
}
