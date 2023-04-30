package com.smnrpn.galaxycrash.moving.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.smnrpn.galaxycrash.moving.Moving;
import com.smnrpn.galaxycrash.moving.enemies.fire.FiringBehavior;

import java.util.Random;

public class Enemy extends Moving {

    /*
     * Enemy types:
     * 0 - Bomber
     * 1 - Scout
     * 2 - Cruiser
     */

    private int type;
    protected FiringBehavior firingBehavior;

    public Enemy(float x, float y, int height, int width, Vector2 velocity) {
        super(height, width);

        this.position = new Vector2(x,y);
        this.velocity = velocity;
        this.acceleration = new Vector2(0, 0);
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
