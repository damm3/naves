package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

    void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.D)) x += 1;
        if(Gdx.input.isKeyPressed(Input.Keys.A)) x -= 1;
        if(Gdx.input.isKeyPressed(Input.Keys.W)) y += 1;
        if(Gdx.input.isKeyPressed(Input.Keys.S)) y -= 1;
    }

}
