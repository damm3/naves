package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bala {
    Texture texture;

    float x, y, w, h;

    Bala(float xNave, float yNave){
        texture = new Texture("bala.png");
        w = 10;
        h = 50;
        x = xNave-w/2;
        y = yNave;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, w, h);
    }

    void update(){
        y += 2;
    }
}
