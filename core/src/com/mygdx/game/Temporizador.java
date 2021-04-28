package com.mygdx.game;

import sun.awt.X11.XReparentEvent;

public class Temporizador {
    static int tiempoJuego;
    int alarma;
    int frecuencia;
    boolean repetir = true;
    boolean activo = true;

    Temporizador(int f){
        frecuencia = f;
        alarma = tiempoJuego + f;
    }

    Temporizador(int f, boolean r){
        frecuencia = f;
        alarma = tiempoJuego + f;
        repetir = r;
    }

    public boolean suena() {
        if(activo) {
            if (tiempoJuego == alarma) {
                alarma = tiempoJuego + frecuencia;
                if(!repetir) {
                    activo = false;
                }
                return true;
            }
        }
        return false;
    }

    public void activar() {
        activo = true;
        alarma = tiempoJuego + frecuencia;
    }
}
