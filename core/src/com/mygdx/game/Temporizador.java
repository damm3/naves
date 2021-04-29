package com.mygdx.game;

public class Temporizador {
    static int tiempoJuego;
    int alarma;
    int frecuencia;
    boolean repetir = true;
    boolean activo = true;

    Temporizador(int frecuencia) {
        this.frecuencia = frecuencia;
        alarma = tiempoJuego + frecuencia;
    }

    Temporizador(int frecuencia, boolean repetir) {
        this.frecuencia = frecuencia;
        alarma = tiempoJuego + frecuencia;
        this.repetir = repetir;
    }

    public boolean suena() {
        if (activo && tiempoJuego >= alarma) {
            alarma = tiempoJuego + frecuencia;
            if (!repetir) activo = false;
            return true;
        }
        return false;
    }

    public void activar() {
        activo = true;
        alarma = tiempoJuego + frecuencia;
    }
}
