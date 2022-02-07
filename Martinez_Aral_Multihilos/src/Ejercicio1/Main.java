package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int NUMERO_HILOS = 10;
    private static final int NUMERO_POSICIONES = 100000;
    private static final int TIEMPO_ESPERA = 1000;
    private static final String MENSAJE_FINALIZADO = "Hilos finalizados";
    private static final String MENSAJE_NO_FINALIZADO = "Hilos lentos";

    public static void main(String[] args) {
        ArrayList<Thread> hilos= new ArrayList<>();

        crear(hilos);
        iniciarHilos(hilos);
        dormirHilos();
        comprobarFinalizacion(hilos);
    }

    private static List<Thread> crear(List<Thread> hilos) {

        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new Hilo(obtenerListado())));
        }
        return hilos;
    }

    private static List<Double> obtenerListado(){
        Random random = new Random();

        List<Double>listado = new ArrayList<>();

        for (int i = 0;i<NUMERO_POSICIONES;i++){
            listado.add(random.nextDouble()*1);
        }
        return listado;
    }

    private static void iniciarHilos(ArrayList<Thread> hilos){
        for (Thread h:hilos) {
            h.start();
        }
    }

    private static void dormirHilos(){
        try {
            Thread.sleep(TIEMPO_ESPERA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void comprobarFinalizacion(ArrayList<Thread> hilos){
        boolean vivos=false;

        for(int i=0;i<hilos.size()&&!vivos;i++){
            vivos=hilos.get(i).isAlive();
        }
        System.out.println(mandarMensaje(vivos));
    }

    private static String mandarMensaje(boolean vivos){
        String mensaje = MENSAJE_FINALIZADO;

        if (vivos){
            mensaje = MENSAJE_NO_FINALIZADO;
        }
        return mensaje;
    }

}
