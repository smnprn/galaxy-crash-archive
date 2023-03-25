package com.smnrpn.galaxycrash.scrollable;

public class ScrollHandler {
    private Backgound bottomBackground;
    private Backgound topBackground;

    public static final int SCROLL_SPEED = -50;
    public ScrollHandler(float yPos) {
        bottomBackground = new Backgound(0, 0, 1600, 800, SCROLL_SPEED);
        topBackground = new Backgound(0, -1600, 1600, 800, SCROLL_SPEED);
    }

    public void update(float delta) {
        bottomBackground.update(delta);
        topBackground.update(delta);

        if (bottomBackground.isScrolled()) {
            bottomBackground.reset(topBackground.getTailY());
        }

        if (topBackground.isScrolled()) {
            topBackground.reset(bottomBackground.getTailY());
        }
    }

    public Backgound getBottomBackground() {
        return bottomBackground;
    }

    public Backgound getTopBackground() {
        return topBackground;
    }
}
