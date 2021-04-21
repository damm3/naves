package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fondo {
    Texture texture;

    Fondo(){
        texture = new Texture("fondo.jpg");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0,0);
    }
}
