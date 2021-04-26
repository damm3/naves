package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Nave {
    Texture texture;
    float x, y, w, h, v;
    List<Bala> balas;

    Nave(){
        texture = new Texture("nave.png");
        x = 100;
        y = 100;
        w = 50;
        h = 100;
        v = 5;
        balas = new ArrayList<>();
    }

    void render(SpriteBatch batch){
        batch.draw(texture, x, y, w, h);

        for (Bala bala: balas) {
            bala.render(batch);
        }
    }

    void update(){
        for (Bala bala: balas) {
            bala.update();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += v;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= v;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y += v;
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= v;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
           balas.add(new Bala(x+w/2, y+h));
        }
    }
}
