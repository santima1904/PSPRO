package Examen1.Ejercicio2;

public class Hilo implements Runnable {
    private int incrementos = 0;
    private final Contador contador;

    public Hilo(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        while (contador.incrementar()) {
            incrementos++;
        }
        System.out.println(String.format("El número de incrementos realizados es %d",
                incrementos));
    }
}

