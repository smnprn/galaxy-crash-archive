package com.smnrpn.galaxycrash.moving.enemies;

import com.badlogic.gdx.math.Vector2;

public class Bomber extends Enemy {
    public Bomber(float x, float y, int height, int width, Vector2 velocity) {
        super(x, y, height, width, velocity);

        setType(0);
    }
}
