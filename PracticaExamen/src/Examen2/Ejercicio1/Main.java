package Examen2.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int NUMERO_HILOS = 10;
    private static int NUMERO_NUMEROS = 10000;

    public static void main(String[] args) {

        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new Hilo(obtenerListado())));
        }

        for (Thread hilo:hilos) {
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ha acabao");
    }

    private static List<Double> obtenerListado(){
        Random random = new Random();
        List<Double>listado = new ArrayList<>();

        for (int i = 0;i<NUMERO_NUMEROS;i++){
            listado.add(random.nextDouble()*1);
        }
        return listado;
    }

}
