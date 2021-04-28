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
    int vidas = 3;
    int puntos = 0;
    boolean muerta = false;

    Temporizador fireRate;
    Temporizador respawn;

    Nave(){
        texture = new Texture("nave.png");
        x = 100;
        y = 100;
        w = 50;
        h = 100;
        v = 5;
        balas = new ArrayList<>();
        fireRate = new Temporizador(10);
        respawn = new Temporizador(120, false);
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

        if(x < 0) x = 0;

        if(respawn.suena()){
            muerta = false;
        }
    }
}
