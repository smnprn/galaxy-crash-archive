package com.smnrpn.galaxycrash.movable.spaceship;

import com.badlogic.gdx.Gdx;
import com.smnrpn.galaxycrash.movable.Movable;

import static com.smnrpn.galaxycrash.GameRenderer.camera;

public class Spaceship extends Movable {
    private SwipeHandler swipeHandler;

    // This variable checks if the user touched the ship
    private boolean userTouched = false;
    private Projectile projectile;

    public Spaceship(float x, float y, int height, int width, Projectile projectile) {
        super(x, y, height, width);
        this.projectile = projectile;
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
}
