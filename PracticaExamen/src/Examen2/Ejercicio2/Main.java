package Examen2.Ejercicio2;

import Examen2.Ejercicio2.Hilo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMERO_HILOS = 10;

    public static void main(String[] args) {

        Comunicacion comunicacion = new Comunicacion();
        List<Thread> hilos = new ArrayList<Thread>();

        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new Hilo(comunicacion, i)));
        }

        for (Thread hilo:hilos) {
            hilo.start();
        }
    }
}
