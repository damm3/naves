package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

	Texture fondo;
	SpriteBatch batch;
	Nave nave;

	@Override
	public void create () {
		batch = new SpriteBatch();
		fondo = new Texture("fondo.jpg");
		nave = new Nave();
	}

	@Override
	public void render () {

		nave.update();

		batch.begin();
		batch.draw(fondo, 0,0);
		nave.render(batch);
		batch.end();
	}
}

/*
create();

while(true) render();


 */