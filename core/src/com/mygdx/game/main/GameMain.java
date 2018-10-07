package com.mygdx.game.main;

import com.badlogic.gdx.Game;
import com.mygdx.game.screen.SplashScreen;

public class GameMain extends Game {

    public final static String GAME_NAME = "Clicker";
    public final static int WIDTH = 480;
    public final static int HEIGHT = 700;
    private boolean paused;

    @Override
    public void create() {
    //    this.setScreen(new SplashScreen(this));
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}