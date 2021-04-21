package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bala {
    Texture texture;

    float x, y;

    Bala(){
        texture = new Texture("bala.png");
        x = 200;
        y = 100;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }
}
