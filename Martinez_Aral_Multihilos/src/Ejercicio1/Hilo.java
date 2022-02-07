package Ejercicio1;

import java.util.List;

public class Hilo implements Runnable{

    List<Double> listadoNumeros;

    public Hilo(List<Double> listadoNumeros) {
        this.listadoNumeros = listadoNumeros;
    }

    @Override
    public void run() {
        double suma = 0;
        for (double numero:listadoNumeros) {
            suma += numero;
        }
        System.out.println(String.format("La suma es %.2f",suma));
    }
}

