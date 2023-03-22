package com.smnrpn.galaxycrash;

import com.badlogic.gdx.Gdx;

public class SwipeHandler {
    public boolean isSwipRight(){
        if(Gdx.input.isTouched() && Gdx.input.getDeltaX() > 0) {
            return true;
        }

        return false;
    }

    public boolean isSwipLeft(){
        if(Gdx.input.isTouched() && Gdx.input.getDeltaX() < 0) {
            return true;
        }

        return false;
    }
}
