package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.main.GameMain;

public class SplashScreen extends AbstractScreen {

    private Texture splashImg;

    public SplashScreen(final GameMain game) {
        super(game);
        init();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new GameplayScreen(game));
            }
        }, 1);
    }

    private void init() {
        // TODO implement better assests loading when game grows
        splashImg = new Texture("badlogic.jpg");
    }


    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0, 0);
        spriteBatch.end();
    }
}