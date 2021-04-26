package com.mygdx.game;

public class Temporizador {
    static int tiempoJuego;
    int alarma;
    int frecuencia;

    Temporizador(int f){
        frecuencia = f;
        alarma = tiempoJuego + f;
    }

    public boolean suena() {
        if(tiempoJuego == alarma){
            alarma = tiempoJuego + frecuencia;
            return true;
        }
        return false;
    }
}
