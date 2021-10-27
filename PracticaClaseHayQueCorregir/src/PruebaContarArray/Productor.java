package PruebaContarArray;


import java.security.SecureRandom;

public class Productor  implements Runnable {

    private final Contenedor2 datos;
    private  String nombre;

    public Productor(Contenedor2 datos, String nombre) {
        this.datos = datos;
        this.nombre = nombre;
    }

    private int[] producirDato() {
        int[] numeros = new int[100];
        for (int i = 0; i < 100; i++) {
            SecureRandom random = new SecureRandom();
            numeros[i] = random.nextInt();
        }
        return numeros;
    }


    @Override
    public void run() {
        int [] dato;
        while (true) {

            dato = producirDato();
            synchronized (this.datos) {
                while (this.datos.maximoAlcanzado()) {
                    try {
                        this.datos.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                this.datos.put(dato);
                this.datos.notifyAll();
            }
        }
    }
}

