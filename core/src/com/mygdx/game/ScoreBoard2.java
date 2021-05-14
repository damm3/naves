package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreBoard2 {

    private final Stage stage;
    private final Skin skin;

    static class Score {
        String name;
        int points;

        public Score(String name, int points) {
            this.name = name;
            this.points = points;
        }
    }

    List<Score> scoreList = new ArrayList<>();

    ScoreBoard2(){
        stage = new Stage();
        skin = new Skin(Gdx.files.internal("core/assets/skin/uiskin.json"));
    }

    void render() {
        stage.act();
        stage.draw();
    }

    public void saveScore(int puntos) {
        try {
            FileWriter fileWriter = new FileWriter("scores.txt", true);
            fileWriter.append("jugador," + puntos +"\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        loadScores();
    }

    public void loadScores(){
        try {
            Scanner scanner = new Scanner(new File("scores.txt"));
            scanner.useDelimiter(",|\n");
            scoreList.clear();
            while(scanner.hasNext()) {
                String name = scanner.next();
                int points = scanner.nextInt();
                scoreList.add(new Score(name, points));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        stage.clear();
        Table table = new Table(skin);
        table.setFillParent(true);
        table.setBackground(new TextureRegionDrawable(new Texture("back.png")));
//        table.setDebug(true);
        stage.addActor(table);

        Label title = new Label("SCOREBOARD", skin);
        title.setFontScale(2.6f);
        table.add(title).colspan(2);
        table.row();
        for (Score score: scoreList){
            Label nameLabel = new Label(score.name, skin);
            nameLabel.setFontScale(2);
            table.add(nameLabel).expand();
            Label scoreLabel = new Label(""+score.points, skin);
            scoreLabel.setFontScale(2);
            table.add(scoreLabel).expand();
            table.row();
        }
    }
}
