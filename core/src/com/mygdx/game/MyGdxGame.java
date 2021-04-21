package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

// http://millionthvector.blogspot.com/p/free-sprites.html

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Fondo fondo;
	Nave nave;

	@Override
	public void create () {
		batch = new SpriteBatch();
		fondo = new Fondo();
		nave = new Nave();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		nave.update();


		batch.begin();
		fondo.render(batch);
		nave.render(batch);
		batch.end();
	}
}

/*
create();

while(true) render();


 */