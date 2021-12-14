package Examen3.Ejercicio2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Thread> hilos= new ArrayList<>();
        Thread hilo;
        Secreto secreto = new Secreto();

        for(int i=0;i<10;i++){
            hilo=new Thread(new Hilo(i,secreto));
            hilos.add(hilo);
        }
        for (Thread h:hilos) {
            h.start();
        }

    }
}

