package Ejercicio2;

public class Hilo2 implements Runnable{

    private double precio;
    private Tarjeta tarjeta;

    public Hilo2(double precio, Tarjeta tarjeta) {
        this.precio = precio;
        this.tarjeta = tarjeta;
    }

    @Override
    public void run() {

        if (tarjeta.comprar(precio)){
            System.out.println(String.format("Importe gastado: %.2f euros",precio));
        }else{
            System.out.println("Operación cancelada");
        }
    }
}
