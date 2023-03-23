package com.smnrpn.galaxycrash.lives;

public class HPHandler {
    private Heart firstHeart;
    private Heart secondHeart;
    private Heart thirdHeart;

    public HPHandler() {
        firstHeart = new Heart();
        secondHeart = new Heart();
        thirdHeart = new Heart();
    }

    public Heart getFirstHeart() {
        return firstHeart;
    }

    public Heart getSecondHeart() {
        return secondHeart;
    }

    public Heart getThirdHeart() {
        return thirdHeart;
    }
}
