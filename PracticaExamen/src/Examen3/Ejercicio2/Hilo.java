package Examen3.Ejercicio2;

import java.util.Random;

public class Hilo implements Runnable{
    private int numHilo;
    private Secreto secreto;

    public Hilo(int numHilo,Secreto secreto){
        this.numHilo=numHilo;
        this.secreto=secreto;
    }

    @Override
    public void run() {
        int resultado,numAleatorio;
        Random random = new Random();

        do{
            numAleatorio = random.nextInt(1001);
            resultado=secreto.adivinar(numAleatorio);
        }while(resultado==0);
        if(resultado==1){
            System.out.println("El hilo "+numHilo+" ha adiviniado el numero.");
        }else{
            System.out.println("El hilo "+numHilo+" ha finalizado el juego.");
        }
    }
}
