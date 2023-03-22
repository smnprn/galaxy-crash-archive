package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;

public class GameWorld {
    private Spaceship userSpaceship;

    public GameWorld() {
        userSpaceship = new Spaceship((Gdx.graphics.getWidth()/2) - (97/2), 80, 100, 162);
    }

    public void update(float delta) {
        userSpaceship.update(delta);
    }

    public Spaceship getUserSpaceship() {
        return userSpaceship;
    }
}
