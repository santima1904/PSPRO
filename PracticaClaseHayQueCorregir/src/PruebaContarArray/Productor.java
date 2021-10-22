package PruebaContarArray;


import java.security.SecureRandom;

public class Productor  implements Runnable {

    private final Contenedor2 datos;

    public Productor(Contenedor2 datos) {
        this.datos = datos;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (this.datos) {
                while (!this.datos.maximoAlcanzado()) {
                    try {
                        this.datos.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                this.datos.put(producirDato());
                this.datos.notifyAll();
            }
        }
    }

    private int[] producirDato() {
            int[] numeros = new int[100];
            for (int i = 0; i < 100; i++) {
                SecureRandom random = new SecureRandom();
                numeros[i] = random.nextInt();
            }
            return numeros;
        }
    }
