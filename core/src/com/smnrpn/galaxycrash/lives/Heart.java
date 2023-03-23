package com.smnrpn.galaxycrash.lives;

public class Heart {
    private boolean heartStatus;

    public Heart() {
        heartStatus = true;
    }

    public void loseLive() {
        heartStatus = false;
    }

    public boolean isLiveStatus() {
        return heartStatus;
    }
}
