package Examen2.Ejercicio2;

public class Hilo implements Runnable{

    Comunicacion comunicacion;
    int numero;

    public Hilo(Comunicacion comunicacion, int numero) {
        this.comunicacion = comunicacion;
        this.numero = numero;
    }

    @Override
    public void run() {
        for (int i = 1;i<=3;i++){
            comunicacion.enviar("Datos numero "+i+" del hilo "+numero);
        }
    }
}
