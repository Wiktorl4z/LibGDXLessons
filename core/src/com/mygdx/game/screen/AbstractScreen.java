package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.main.GameMain;

public class AbstractScreen implements Screen {

    protected GameMain game;
    protected Stage stage;  // each screen will have his own Stage
    private OrthographicCamera camera;
    protected SpriteBatch spriteBatch;

    public AbstractScreen(GameMain game) {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(GameMain.WIDTH, GameMain.HEIGHT, camera));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage); // pobieramy naszego stage
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameMain.WIDTH, GameMain.HEIGHT);
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() {  //
        game.setPaused(false);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void dispose() {
        game.dispose();
    }



    @Override
    public void resize(int width, int height) {

    }
}
