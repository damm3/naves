package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Nave {
    Texture texture;
    float x, y;

    Nave(){
        texture =  new Texture("nave.png");
        x = 100;
        y = 100;
    }

    void render(SpriteBatch batch){
        batch.draw(texture, x, y);
    }
}
