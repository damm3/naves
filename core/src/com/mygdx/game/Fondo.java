package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fondo {
    Texture texture = new Texture("black.png");

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0, 640, 480);
    }
}
