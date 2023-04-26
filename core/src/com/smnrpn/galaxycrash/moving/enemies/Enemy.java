package com.smnrpn.galaxycrash.moving.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.smnrpn.galaxycrash.moving.Moving;

import java.util.Random;

public class Enemy extends Moving {

    public Enemy(float x, float y, int height, int width, Vector2 velocity) {
        super(height, width);

        this.position = new Vector2(x,y);
        this.velocity = velocity;
        this.acceleration = new Vector2(0, 0);
    }

}
