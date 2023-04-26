package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.lives.HPHandler;
import com.smnrpn.galaxycrash.movable.spaceship.Projectile;
import com.smnrpn.galaxycrash.movable.spaceship.Spaceship;
import com.smnrpn.galaxycrash.scrollable.ScrollHandler;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.Timer;

public class GameWorld {
    private final Spaceship userSpaceship;
    private final HPHandler hpHandler;
    private final ScrollHandler scroller;

    public GameWorld() {
        scroller = new ScrollHandler(0);
        hpHandler = new HPHandler();
        userSpaceship = new Spaceship((Gdx.graphics.getWidth()/2F) - (162/2F), 120, 100, 162);
    }

    public void update(float delta) {
        userSpaceship.update(delta);

        for (Projectile projectile : userSpaceship.getAmmunition()) {
            projectile.update(delta);
        }

        scroller.update(delta);
    }

    public Spaceship getUserSpaceship() {
        return userSpaceship;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public HPHandler getHpHandler() {
        return hpHandler;
    }
}
