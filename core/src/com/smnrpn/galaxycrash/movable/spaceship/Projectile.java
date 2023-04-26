package com.smnrpn.galaxycrash.movable.spaceship;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.movable.Movable;

public class Projectile extends Movable {

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
