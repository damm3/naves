package com.mygdx.game;

public class Temporizador {
    static int framesJuego;
    int alarma;
    int frecuencia;
    boolean repetir = true;
    boolean activo = true;

    Temporizador(int frecuencia) {
        this.frecuencia = frecuencia;
        alarma = framesJuego + frecuencia;
    }

    Temporizador(int frecuencia, boolean repetir) {
        this.frecuencia = frecuencia;
        alarma = framesJuego + frecuencia;
        this.repetir = repetir;
    }

    public boolean suena() {
        if (activo && framesJuego >= alarma) {
            alarma = framesJuego + frecuencia;
            if (!repetir) activo = false;
            return true;
        }
        return false;
    }

    public void activar() {
        activo = true;
        alarma = framesJuego + frecuencia;
    }
}
