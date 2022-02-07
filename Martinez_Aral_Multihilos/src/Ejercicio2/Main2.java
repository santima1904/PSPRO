package Ejercicio2;

import Ejercicio1.Hilo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {

    private static final int NUMERO_HILOS = 10;
    private static final double PRECIO_MAXIMO = 50;

    public static void main(String[] args) {
        ArrayList<Thread> hilos= new ArrayList<>();
        Tarjeta tarjeta = new Tarjeta();

        crear(hilos, tarjeta);
        iniciarHilos(hilos);
    }

    private static List<Thread> crear(List<Thread> hilos, Tarjeta tarjeta) {

        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new Hilo2(obtenerPrecio(),tarjeta)));
        }
        return hilos;
    }

    private static double obtenerPrecio(){
        Random random = new Random();

        return random.nextDouble()*PRECIO_MAXIMO;
    }

    private static void iniciarHilos(ArrayList<Thread> hilos){
        for (Thread h:hilos) {
            h.start();
        }
    }
}

