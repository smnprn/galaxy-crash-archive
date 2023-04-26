package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.smnrpn.galaxycrash.hp.HPHandler;
import com.smnrpn.galaxycrash.moving.enemies.Enemy;
import com.smnrpn.galaxycrash.moving.enemies.EnemyGroup;
import com.smnrpn.galaxycrash.moving.spaceship.Projectile;
import com.smnrpn.galaxycrash.moving.spaceship.Spaceship;
import com.smnrpn.galaxycrash.scrollable.ScrollHandler;

public class GameWorld {
    private final Spaceship userSpaceship;
    //private final Enemy enemy;
    private final EnemyGroup enemyGroup;
    private final HPHandler hpHandler;
    private final ScrollHandler scroller;

    public GameWorld() {
        scroller = new ScrollHandler(0);
        hpHandler = new HPHandler();
        userSpaceship = new Spaceship((Gdx.graphics.getWidth()/2F) - (162/2F), 120, 100, 162);
        enemyGroup = new EnemyGroup(50);
    }

    public void update(float delta) {
        userSpaceship.update(delta);

        for (Projectile projectile : userSpaceship.getAmmunition()) {
            projectile.update(delta);
        }

        for (Enemy enemy : enemyGroup.getGroup()) {
            enemy.update(delta);
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
/*
    public Enemy getEnemy() {
        return enemy;
    }
 */

    public EnemyGroup getEnemyGroup() {
        return enemyGroup;
    }
}
