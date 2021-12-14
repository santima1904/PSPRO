package Examen3.Ejercicio1;

import Examen3.Ejercicio1.Hilo;
import java.util.ArrayList;

public class Main {

    private static final int NUMERO_HILOS = 10;

    public static void main(String[] args) {

        ArrayList<Thread> hilos= new ArrayList<>();
        Thread hilo;
        boolean vivos=false;

        for (int i=1;i<=10;i++){
            hilo = new Thread(new Hilo(i));
            hilos.add(hilo);
        }
        for (Thread h:hilos) {
            h.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<hilos.size()&&!vivos;i++){
            vivos=hilos.get(i).isAlive();
        }
        if(vivos){
            System.out.println("Hilos lentos");
        }else{
            System.out.println("Hilos finalizados");
        }

    }
}

