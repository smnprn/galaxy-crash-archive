package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.lives.HPHandler;
import com.smnrpn.galaxycrash.movable.spaceship.Projectile;
import com.smnrpn.galaxycrash.movable.spaceship.Spaceship;
import com.smnrpn.galaxycrash.scrollable.ScrollHandler;

import java.util.ArrayList;

public class GameWorld {
    private final Spaceship userSpaceship;
    private Projectile projectile;
    private final ArrayList<Projectile> ammunition;
    private final HPHandler hpHandler;
    private final ScrollHandler scroller;

    public GameWorld() {
        scroller = new ScrollHandler(0);
        hpHandler = new HPHandler();

        int ammunitionQuantity = 3; // Set how many projectiles the ship fires each round
        ammunition = new ArrayList<>();
        for (int i = 1; i <= ammunitionQuantity; i++) { // Add projectiles to the ammunition ArrayList
            projectile = new Projectile((Gdx.graphics.getWidth()/2F) - (30/2F), 180, 30,30);
            ammunition.add(projectile);
        }

        userSpaceship = new Spaceship((Gdx.graphics.getWidth()/2F) - (162/2F), 80, 100, 162, projectile);
    }

    public void update(float delta) {
        userSpaceship.update(delta);

        // The following loop make the ship fire projectiles at different times
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
