package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private final static int NUMERO_HILOS = 10;

    public static void main(String[] args) {

        List<Thread> hilos = crear();
        iniciar(hilos);
    }

    private static List<Thread> crear() {
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new Hilo()));
        }
        return hilos;
    }

    private static void iniciar(List<Thread> hilos) {
        for (Thread hilo :
                hilos) {
            hilo.start();
        }
    }

}
