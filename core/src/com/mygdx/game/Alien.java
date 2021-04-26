package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Alien {
    Texture texture;
    float x, y, w, h, v;

    Alien(){
        texture = new Texture("alien.png");
        x = 300;
        y = 300;
        w = 50;
        h = 70;
        v = 2;
    }

    void render(SpriteBatch batch){
        batch.draw(texture, x, y, w, h);
    }

    public void update() {
        y -= 1;
        x += 1;
    }
}
