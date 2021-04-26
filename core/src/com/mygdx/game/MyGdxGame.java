package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

// http://millionthvector.blogspot.com/p/free-sprites.html

public class MyGdxGame extends ApplicationAdapter {

	SpriteBatch batch;
	Fondo fondo;
	Nave nave;
	List<Alien> aliens;

	Temporizador temporizadorNuevoAlien;

	@Override
	public void create () {
		batch = new SpriteBatch();
		fondo = new Fondo();
		nave = new Nave();
		aliens = new ArrayList<>();

		aliens.add(new Alien());

		temporizadorNuevoAlien = new Temporizador(120);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Temporizador.tiempoJuego += 1;

		if(temporizadorNuevoAlien.suena()){
			aliens.add(new Alien());
		}

		nave.update();
		for(Alien alien:aliens) alien.update();

		batch.begin();
		fondo.render(batch);
		nave.render(batch);
		for(Alien alien:aliens) alien.render(batch);
		batch.end();
	}
}

/*

create();

while(true) render();

 */