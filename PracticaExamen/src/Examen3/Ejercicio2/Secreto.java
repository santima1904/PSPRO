package Examen3.Ejercicio2;

import java.util.Random;

public class Secreto {
    private boolean adivinado=false;
    private int numSecreto;

    public Secreto(){
        Random random = new Random();
        numSecreto = random.nextInt(1001);
    }

    public synchronized int adivinar(int numero){
        int resultado;

        if(adivinado){
            resultado=-1;
        }else{
            if(numero==numSecreto){
                resultado=1;
                adivinado=true;
            }else{
                resultado=0;
            }
        }
        return resultado;
    }
}

