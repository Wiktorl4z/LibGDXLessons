package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class CircularMotion extends ApplicationAdapter {

    public static final String TAG = CircularMotion.class.getName();
    private static final float WORLD_SIZE = 480.0f;
    private static final float CIRCLE_RADIUS = WORLD_SIZE / 20;
    private static final float MOVEMENT_RADIUS = WORLD_SIZE / 4;

    // How many seconds until the circular motion repeats
    private static final float PERIOD = 1.0f;

    private ShapeRenderer renderer;
    private FitViewport viewport;

    // We set up a variable to hold the nanoTime at which the application was created.
    private long initialTime;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
        viewport = new FitViewport(WORLD_SIZE, WORLD_SIZE);

        // Set the initialTime
        initialTime = TimeUtils.nanoTime();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        viewport.apply();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        float elapsedNanoseconds = TimeUtils.nanoTime() - initialTime;
        float elapsedSeconds = MathUtils.nanoToSec * elapsedNanoseconds;
        float elapsedPeriods = elapsedSeconds / PERIOD;
        float cyclePosition = elapsedPeriods % 1;

        float x = WORLD_SIZE / 2 + MOVEMENT_RADIUS * MathUtils.cos(MathUtils.PI2 * cyclePosition);
        float y = WORLD_SIZE / 2 + MOVEMENT_RADIUS * MathUtils.sin(MathUtils.PI2 * cyclePosition);

        renderer.circle(x, y, CIRCLE_RADIUS);

        // Uncomment the next line to see the sort of beautiful things you can create with simple movement
//         drawFancyCircles(renderer, elapsedPeriods, 20);
        renderer.end();
    }

    private void drawFancyCircles(ShapeRenderer renderer, float elapsedPeriods, int circleCount) {
        for (int i = 1; i <= circleCount; i++) {
            float centerX = WORLD_SIZE / 2 + WORLD_SIZE / 4 * MathUtils.cos(MathUtils.PI2 * i / circleCount);
            float centerY = WORLD_SIZE / 2 + WORLD_SIZE / 4 * MathUtils.sin(MathUtils.PI2 * i / circleCount);

            float x = centerX + WORLD_SIZE / 5 * MathUtils.cos(MathUtils.PI2 * (elapsedPeriods * i / circleCount));
            float y = centerY + WORLD_SIZE / 5 * MathUtils.sin(MathUtils.PI2 * (elapsedPeriods * i / circleCount));

            renderer.circle(x, y, 10);
        }
    }
}