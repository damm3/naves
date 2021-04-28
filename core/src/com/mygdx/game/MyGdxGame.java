package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// http://millionthvector.blogspot.com/p/free-sprites.html

public class MyGdxGame extends ApplicationAdapter {

	static Random random = new Random();
	SpriteBatch batch;
	BitmapFont bitmapFont;
	Fondo fondo;
	Nave nave;
	List<Alien> aliens = new ArrayList<>();
	List<Bala> balasAEliminar = new ArrayList<>();
	List<Alien> aliensAEliminar = new ArrayList<>();
	Temporizador temporizadorNuevoAlien;

	@Override
	public void create () {
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		bitmapFont.setColor(Color.WHITE);
		fondo = new Fondo();
		nave = new Nave();

		aliens.add(new Alien());

		temporizadorNuevoAlien = new Temporizador(120);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		Temporizador.tiempoJuego += 1;

		if (temporizadorNuevoAlien.suena()) aliens.add(new Alien());

		nave.update();
		for (Alien alien:aliens) alien.update();


		balasAEliminar.clear();
		aliensAEliminar.clear();
		for (Alien alien: aliens) {
			for (Bala bala: nave.balas) {
				if (solapan(bala.x, bala.y, bala.w, bala.h, alien.x, alien.y, alien.w, alien.h)) {
					balasAEliminar.add(bala);
					aliensAEliminar.add(alien);
					nave.puntos++;
					break;
				}
			}

			if (!nave.muerta && solapan(alien.x, alien.y, alien.w, alien.h, nave.x, nave.y, nave.w, nave.h)) {
				nave.vidas--;
				nave.muerta = true;
				nave.respawn.activar();
			}
		}
		for (Bala bala:balasAEliminar) nave.balas.remove(bala);
		for (Alien alien:aliensAEliminar) aliens.remove(alien);



		batch.begin();
		fondo.render(batch);
		nave.render(batch);
		for(Alien alien:aliens) alien.render(batch);
		bitmapFont.draw(batch, "VIDAS: "+nave.vidas, 530, 420);
		bitmapFont.draw(batch, "PUNTOS: "+nave.puntos, 30, 420);
		batch.end();
	}

	boolean solapan(float x, float y, float w, float h, float x2, float y2, float w2, float h2){
		return !(x > x2 + w2) && !(x + w < x2) && !(y > y2 + h2) && !(y + h < y2);
	}
}

/*

init();

create();

while(true) render();

 */