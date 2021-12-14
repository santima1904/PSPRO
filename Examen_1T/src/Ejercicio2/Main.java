package Ejercicio2;

import Ejercicio1.Hilo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static int NUMERO_HILOS = 10;

    public static void main(String[] args) {

        List<Thread> hilos = new ArrayList<>();

        for (int i = 0;i < NUMERO_HILOS;i++){
            hilos.add(new Thread(new Hilo()));
        }

        for (Thread hilo:hilos) {
            hilo.start();
        }
    }
}
