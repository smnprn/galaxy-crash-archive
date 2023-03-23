package com.smnrpn.galaxycrash.scrollable;

public class Backgound extends Scrollable {
    private float tailY;
    public Backgound(float x, float y, int height, int width, float scrollSpeed) {
        super(x, y, height, width, scrollSpeed);
    }

    public float getTailY() {
        return tailY = position.y + getHeight();
    }
}
