package com.smnrpn.galaxycrash.scrollable;

public class ScrollHandler {

    public static class ScrollHandlerConstants {
        private static final int BACKGROUND_SCROLL_SPEED = -200;

        private static final int BACKGORUND_HEIGHT = 1600;
        private static final int BACKGORUND_WIDTH = 800;

        private static final int BOTTOM_BG_X = 0;
        private static final int BOTTOM_BG_Y = 0;

        private static final int TOP_BG_X = 0;
        private static final int TOP_BG_Y = -1600;
    }

    private Backgound bottomBackground;
    private Backgound topBackground;

    public ScrollHandler(float yPos) {
        bottomBackground = new Backgound(
                ScrollHandlerConstants.BOTTOM_BG_X,
                ScrollHandlerConstants.BOTTOM_BG_Y,
                ScrollHandlerConstants.BACKGORUND_HEIGHT,
                ScrollHandlerConstants.BACKGORUND_WIDTH,
                ScrollHandlerConstants.BACKGROUND_SCROLL_SPEED
        );

        topBackground = new Backgound(
                ScrollHandlerConstants.TOP_BG_X,
                ScrollHandlerConstants.TOP_BG_Y,
                ScrollHandlerConstants.BACKGORUND_HEIGHT,
                ScrollHandlerConstants.BACKGORUND_WIDTH,
                ScrollHandlerConstants.BACKGROUND_SCROLL_SPEED
        );
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
