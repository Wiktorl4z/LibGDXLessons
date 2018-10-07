package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CirclesAndArcs extends ApplicationAdapter {

    ShapeRenderer renderer;

    @Override
    public void create() {
        renderer = new ShapeRenderer();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.WHITE);

        // The most basic circle you can draw, with the segment count set for you
        renderer.circle(100, 100, 90);
        renderer.setColor(Color.YELLOW);

        // We can also draw partial circle, or arc
        renderer.arc(300, 100, 90, 45, 270);

        // What happens when we set the segments count too low
        renderer.circle(500, 100, 90, 10);
        renderer.end();

        // Circles can be drawn in either Filled or Line mode!
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.circle(100, 300, 90);

        // Let's draw target rings
        for (int radius = 80; radius > 0; radius -= 10) {
            renderer.circle(100, 300, radius);
        }

        // We can also draw the outline of an arc
        renderer.arc(300, 300, 90, 0, 90);

        // Let's draw some a funky snail shell
        final int arcs = 20;
        for (int i = 1; i < arcs; i++) {
            renderer.arc(300, 300, (1 - 1.0f * i / arcs) * 90, 360.0f * i / arcs, 90);
        }
        renderer.end();
    }
}