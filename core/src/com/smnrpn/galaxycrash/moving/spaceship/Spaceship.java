package com.smnrpn.galaxycrash.moving.spaceship;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.moving.Moving;

import java.util.ArrayList;

public class Spaceship extends Moving {

    public static class SpaceshipConstants {
        private static final int PROJECTILE_STARTING_Y = 180;
        private static final int PROJECTILE_HEIGHT = 30;
        private static final int PROJECTILE_WIDTH = 30;

        private static final int AMMUNITION_QUANTITY = 3;
    }

    private SwipeHandler swipeHandler;
    private Projectile projectile;
    private ArrayList<Projectile> ammunition;

    // This variable checks if the user touched the ship
    private boolean userTouched = false;
    private int ammunitionQuantity;

    public Spaceship(float x, float y, int height, int width) {
        super(x, y, height, width);

        ammunition = new ArrayList<>();
        ammunitionQuantity = SpaceshipConstants.AMMUNITION_QUANTITY;

        addProjectilesToAmmunition();

        swipeHandler = new SwipeHandler();
    }

    public void onSwipeRight() {
        if (swipeHandler.isSwipRight() && isCursorOverShip() || userTouched) {
            moveShip();
        }
    }

    public void onSwipeLeft() {
        if (swipeHandler.isSwipLeft() && isCursorOverShip() || userTouched) {
            moveShip();
        }
    }

    public void moveShip() {
        position.x = Gdx.input.getX() - 50;

        // Avoid ship movement over the borders
        if (position.x < 0) {
            position.x = 0;
        }

        if (position.x + this.width > Gdx.graphics.getWidth()) {
            position.x = Gdx.graphics.getWidth() - this.width;
        }
    }

    public boolean isCursorOverShip() {

        // If the cursor is inside the ship hitbox
        if (Gdx.input.getX() >= position.x &&
            Gdx.input.getX() <= position.x + width) {

            if (Gdx.input.getY() <= Gdx.graphics.getHeight() - position.y  &&
                Gdx.input.getY() >= Gdx.graphics.getHeight() - position.y - height) {

                userTouched = true;
                return true;
            }

        }

        return false;
    }

    // This method is used inside InputHandler.TouchUp()
    public void setUserTouchedFalse() {
        userTouched = false;
    }

    public void fire(float resetX) {
        ammunition.get(0).fire(resetX);

        for (int i = 1; i < ammunition.size(); i++) {
            if (ammunition.get(i - 1).getY() >= Gdx.graphics.getHeight() / (float) ammunitionQuantity) {
                ammunition.get(i).fire(resetX);
            }
        }
    }

    public void addProjectilesToAmmunition() {
        // Add projectiles to the ammunition ArrayList
        for (int i = 1; i <= ammunitionQuantity; i++) {
            projectile = new Projectile(
                    (Gdx.graphics.getWidth()/2F) - (SpaceshipConstants.PROJECTILE_WIDTH/2F),
                    SpaceshipConstants.PROJECTILE_STARTING_Y,
                    SpaceshipConstants.PROJECTILE_HEIGHT,
                    SpaceshipConstants.PROJECTILE_WIDTH
            );

            ammunition.add(projectile);
        }
    }

    public ArrayList<Projectile> getAmmunition() {
        return ammunition;
    }
}