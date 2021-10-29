package interrupciones;

public class Hilo implements Runnable {

    int numHilo;

    public Hilo(int numHilo) {
        this.numHilo = numHilo;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // try {
            // Thread.sleep(1000);
            System.out.println("Calculo del hilo " + this.numHilo + " hecho");
            //} catch (InterruptedException e) {
            // }
        }
        System.out.println("Finalizado");
    }
}
