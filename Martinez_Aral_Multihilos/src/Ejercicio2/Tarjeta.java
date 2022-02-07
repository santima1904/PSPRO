package Ejercicio2;

public class Tarjeta {

    private final double SALDO_INICIAL = 1000000;
    private double saldo;

    public Tarjeta() {
        saldo = SALDO_INICIAL;
    }

    public synchronized boolean comprar(double precio){
        boolean valido = false;
        if (precio < saldo){
            saldo = saldo - precio;
            valido = true;
        }
        return valido;
    }
}
