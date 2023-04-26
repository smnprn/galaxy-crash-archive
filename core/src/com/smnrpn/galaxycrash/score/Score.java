package com.smnrpn.galaxycrash.score;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.TimerTask;

public class Score extends TimerTask {
    private int counter;
    private BitmapFont font;

    public Score() {
        this.counter = 0;
    }

    @Override
    public void run() {
        increaseCounter();
    }

    public void increaseCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public BitmapFont getFont() {
        return font;
    }
}
