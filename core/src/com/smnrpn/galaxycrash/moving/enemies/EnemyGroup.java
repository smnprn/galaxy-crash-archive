package com.smnrpn.galaxycrash.moving.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

public class EnemyGroup {
    private ArrayList<Enemy> enemyGroup;
    private Random random;
    private int size;

    private final int SCREEN_WIDTH = Gdx.graphics.getWidth();
    private final int SCREEN_HEIGHT = Gdx.graphics.getHeight();

    public EnemyGroup(int size) {
        this.size = size;

        enemyGroup = new ArrayList<>();
        random = new Random();

        addFirstEnemy();
        addOtherEnemies();
    }

    public float generateX() {
        return random.nextFloat() * (SCREEN_WIDTH - 100);
    }

    public float generateY() {
        return (SCREEN_HEIGHT/6F) + random.nextFloat() * ((SCREEN_HEIGHT/3F) - (SCREEN_HEIGHT/6F));
    }

    public void addFirstEnemy() {
        enemyGroup.add(
                new Bomber(generateX(), SCREEN_HEIGHT + 150, 100, 100, new Vector2(0, -250))
        );
    }

    public void addOtherEnemies() {
        for (int i = 1; i < size; i++) {
            int randomType = random.nextInt(3);

            switch (randomType) {
                case 0 -> enemyGroup.add(
                        new Bomber(generateX(), enemyGroup.get(i - 1).getY() + generateY(), 100, 100, new Vector2(0, -250))
                );
                case 1 -> enemyGroup.add(
                        new Scout(generateX(), enemyGroup.get(i - 1).getY() + generateY(), 100, 100, new Vector2(0, -250))
                );
                case 2 -> enemyGroup.add(
                        new Cruiser(generateX(), enemyGroup.get(i - 1).getY() + generateY(), 100, 100, new Vector2(0, -250))
                );
            }
        }
    }

    public ArrayList<Enemy> getGroup() {
        return enemyGroup;
    }
}
