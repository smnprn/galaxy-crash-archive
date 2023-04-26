package com.smnrpn.galaxycrash.hp;

public class Heart {

    // heartStatus becomes false when the player gets hit, thus losing a heart
    private boolean heartStatus;

    public Heart() {
        heartStatus = true;
    }

    public void loseHP() {
        heartStatus = false;
    }

    public boolean isLive() {
        return heartStatus;
    }
}
