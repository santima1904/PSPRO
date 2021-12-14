package Examen2.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Hilo implements Runnable{

    List<Double> listadoNumeros = new ArrayList<>();

    public Hilo(List<Double> listadoNumeros) {
        this.listadoNumeros = listadoNumeros;
    }

    @Override
    public void run() {
        double media = 0;
        for (double numero:listadoNumeros) {
            media += numero;
        }
        System.out.println("La media es "+media/listadoNumeros.size());
    }
}
