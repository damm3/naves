package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreBoard {

    class Score {
        String nombre;
        int puntuacion;

        public Score(String nombre, int puntuacion) {
            this.nombre = nombre;
            this.puntuacion = puntuacion;
        }
    }

    Texture background = new Texture("back.png");
    char[] nombre = {'A', 'A','A'};  // 65:A -> 90:Z
    int index = 0;  // 0=1a letra; 1=2a letra; 2=3a letra; 3=replay; 4=exit
    private boolean saved;

    List<Score> scoreList = new ArrayList<>();

    /**
     * @param puntos
     * @return
     *         0 = seguir mostrando el scoreboard
     *         1 = replay
     *         2 = exit
     */
    int update(int puntos){
        if(index < 3 && Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            nombre[index]++;
            if(nombre[index] > 90) {
                nombre[index] = 65;
            }
        }
        if(index < 3 && Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            nombre[index]--;
            if(nombre[index] < 65) {
                nombre[index] = 90;
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            if(index == 3) {
                return 1;
            } else if (index == 4) {
                return 2;
            }
            index++;
        }

        if(index > 2 && Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            if (index == 3) index = 4; else index = 3;
        }
        if(index > 2 && Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            if (index == 3) index = 4; else index = 3;
        }

        if(index > 2 && !saved) {
            guardarPuntuacion(puntos);
            saved = true;
        }
        return 0;
    }

    void render(SpriteBatch batch, BitmapFont font) {
        batch.draw(background, 60, 120, 520, 320);

        if(!saved) {
            font.draw(batch, "ENTER YOUR NAME", 180, 400);

            font.getData().setScale(3);
            font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            for (int i = 0; i < 3; i++) {
                if(index == i){
                    font.setColor(Color.RED);
                }
                font.draw(batch, ""+ nombre[i], 260+40*i, 280);
                font.setColor(Color.WHITE);
            }
            font.getData().setScale(2);
        }else {
            font.draw(batch, "SCOREBOARD", 220, 400);

            for (int i = 0; i < 5 && i < scoreList.size(); i++) {
                font.draw(batch, scoreList.get(i).nombre, 200, 340 - i * 40);
                font.draw(batch, "" + scoreList.get(i).puntuacion, 380, 340 - i * 40);
            }

            if(index == 3) font.setColor(Color.RED);
            font.draw(batch, "REPLAY", 180, 60);
            font.setColor(Color.WHITE);

            if(index == 4) font.setColor(Color.RED);
            font.draw(batch, "EXIT", 360, 60);
            font.setColor(Color.WHITE);
        }
    }

    void guardarPuntuacion(int puntuacion) {
        try {
            FileWriter fileWriter = new FileWriter("scores.txt", true);
            fileWriter.write(""+ nombre[0]+ nombre[1]+ nombre[2] + "," + puntuacion + "\n");
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        leerPuntuaciones();
    }

    void leerPuntuaciones() {
        try {
            Scanner scanner = new Scanner(new File("scores.txt"));
            scanner.useDelimiter(",|\n");

            while (scanner.hasNext()) {
                String nombre = scanner.next();
                int puntos = scanner.nextInt();

                scoreList.add(new Score(nombre, puntos));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
