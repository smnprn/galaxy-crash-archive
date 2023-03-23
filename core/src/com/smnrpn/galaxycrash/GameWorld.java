package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.lives.HPHandler;
import com.smnrpn.galaxycrash.movable.spaceship.Projectile;
import com.smnrpn.galaxycrash.movable.spaceship.Spaceship;
import com.smnrpn.galaxycrash.scrollable.ScrollHandler;

import java.util.ArrayList;

public class GameWorld {
    private Spaceship userSpaceship;
    private Projectile projectile;
    private ArrayList<Projectile> ammunition;
    private int ammunitionQuantity;
    private HPHandler hpHandler;
    private ScrollHandler scroller;

    public GameWorld() {
        scroller = new ScrollHandler(0);
        hpHandler = new HPHandler();

        ammunitionQuantity = 3;
        ammunition = new ArrayList<>();
        for (int i = 1; i <= ammunitionQuantity; i++) {
            projectile = new Projectile((Gdx.graphics.getWidth()/2) - (30/2), 180, 30,30);
            ammunition.add(projectile);
        }
        System.out.println(ammunition.size());
        userSpaceship = new Spaceship((Gdx.graphics.getWidth()/2) - (162/2), 80, 100, 162, projectile);
    }

    public void update(float delta) {
        userSpaceship.update(delta);

        for (Projectile projectile : ammunition) {
            projectile.update(delta);
            delta += 0.01F;
        }

        scroller.update(delta);
    }

    public Spaceship getUserSpaceship() {
        return userSpaceship;
    }

    public ArrayList<Projectile> getAmmunition() {
        return ammunition;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public HPHandler getHpHandler() {
        return hpHandler;
    }
}
