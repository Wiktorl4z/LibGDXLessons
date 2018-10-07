package com.mygdx.game.screen;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.entities.Player;
import com.mygdx.game.main.GameMain;

public class GameplayScreen extends AbstractScreen {

    private Player player;

    public GameplayScreen(GameMain game) {
        super(game);
        init();
    }

    private void init() {
        initPlayer();
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();

    }
}
