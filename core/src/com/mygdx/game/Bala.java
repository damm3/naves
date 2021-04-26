package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bala {
    static Texture texture = new Texture("bala.png");

    float x, y, w, h, v;

    Bala(float xNave, float yNave){
        w = 10;
        h = 50;
        x = xNave-w/2;
        y = yNave;
        v = 4;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, w, h);
    }

    void update(){
        y += v;
    }
}
