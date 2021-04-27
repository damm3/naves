package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// http://millionthvector.blogspot.com/p/free-sprites.html

public class MyGdxGame extends ApplicationAdapter {

	static Random random = new Random();
	SpriteBatch batch;
	Fondo fondo;
	Nave nave;
	List<Alien> aliens;
	List<Bala> balasAEliminar = new ArrayList<>();
	List<Alien> aliensAEliminar = new ArrayList<>();
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


		boolean heEliminado = false;
		for(Bala bala:nave.balas){
			for(Alien alien:aliens){
				if (!(bala.x > alien.x + alien.w) && !(bala.x + bala.w < alien.x)
						&&
						!(bala.y > alien.y + alien.h) && !(bala.y + bala.h < alien.y)) {

					aliensAEliminar.add(alien);
					balasAEliminar.add(bala);
					heEliminado = true;
				}
			}
		}

		for(Alien alien: aliensAEliminar){
			aliens.remove(alien);
		}

		for(Bala bala: balasAEliminar){
			nave.balas.remove(bala);
		}

		if(heEliminado){
			aliensAEliminar.clear();
			balasAEliminar.clear();
		}
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