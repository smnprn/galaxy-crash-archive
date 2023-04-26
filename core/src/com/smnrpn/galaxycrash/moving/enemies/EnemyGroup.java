package com.smnrpn.galaxycrash.moving.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

public class EnemyGroup {
    private ArrayList<Enemy> enemyGroup;
    private Random random;
    private int size;

    //private float x;
    //private float y;

    public EnemyGroup(int size) {
        this.size = size;

        enemyGroup = new ArrayList<>();
        random = new Random();

        addFirstEnemy();
        addOtherEnemies();
    }

    public float generateX() {
        return random.nextFloat() * (Gdx.graphics.getWidth() - 100);
    }

    public float generateY() {
        return (Gdx.graphics.getHeight()/8F) + random.nextFloat() * ((Gdx.graphics.getHeight()/4F) - (Gdx.graphics.getHeight()/8F));
    }

    public void addFirstEnemy() {
        enemyGroup.add(
                new Enemy(generateX(), Gdx.graphics.getHeight() + 150, 100, 100, new Vector2(0, -250))
        );
    }

    public void addOtherEnemies() {
        for (int i = 1; i < size; i++) {
            enemyGroup.add(
                    new Enemy(generateX(), enemyGroup.get(i - 1).getY() + generateY(), 100, 100, new Vector2(0, -250))
            );
        }
    }

    public ArrayList<Enemy> getGroup() {
        return enemyGroup;
    }
}
