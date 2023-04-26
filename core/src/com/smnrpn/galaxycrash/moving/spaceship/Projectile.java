package com.smnrpn.galaxycrash.moving.spaceship;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.moving.Moving;

public class Projectile extends Moving {

    public static class ProjectileConstants {
        public static final int VELOCITY = 1100;
        public static final int STARTING_Y = 210;
    }

    public Projectile(float x, float y, int height, int width) {
        super(x, y, height, width);
    }

    public void fire(float resetX) {
        velocity.y = ProjectileConstants.VELOCITY;

        if (position.y > Gdx.graphics.getHeight()) {
            position.y = ProjectileConstants.STARTING_Y;
            position.x = resetX;
        }
    }
}
