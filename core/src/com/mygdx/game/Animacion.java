package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Animacion {
    Texture[] textures;
    int duracion;

    Animacion(int duracion, Texture... textures){
        this.textures = textures;
        this.duracion = duracion;
    }

    Texture obtenerFrame(){
        int anim = Temporizador.framesJuego/duracion%textures.length;
        return textures[anim];
    }
}
