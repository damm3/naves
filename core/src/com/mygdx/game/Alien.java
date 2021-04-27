package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Alien {
    Texture texture;
    float x, y, w, h, vx, vy;
    Temporizador cambioVelocidad;

    Alien(){
        texture = new Texture("alien.png");
        x = 300;
        y = 300;
        w = 50;
        h = 70;
        vx = 2;
        vy = 1;
        cambioVelocidad = new Temporizador(60);
    }

    void render(SpriteBatch batch){
        batch.draw(texture, x, y, w, h);
    }

    public void update() {
        y += vy;
        x += vx;

        if(cambioVelocidad.suena()){
            vy = MyGdxGame.random.nextInt(6)-3;
            vx = MyGdxGame.random.nextInt(6)-3;
        }
    }
}
