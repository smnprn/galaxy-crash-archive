package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;

public class GameWorld {
    private Spaceship userSpaceship;
    private Projectile projectile;

    public GameWorld() {
        projectile = new Projectile((Gdx.graphics.getWidth()/2) - (30/2), 180, 30,30);
        userSpaceship = new Spaceship((Gdx.graphics.getWidth()/2) - (162/2), 80, 100, 162, projectile);
    }

    public void update(float delta) {
        userSpaceship.update(delta);
        projectile.update(delta);
    }

    public Spaceship getUserSpaceship() {
        return userSpaceship;
    }

    public Projectile getProjectile() {
        return projectile;
    }
}
