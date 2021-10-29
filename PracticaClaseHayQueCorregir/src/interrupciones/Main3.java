package interrupciones;

import PruebaContarArray.Productor;

public class Main3 {
    public static void main(String[] args) {
        //for (int i = 0; i < 5; i++) {
            Thread h1 = new Thread(new Hilo(1));
            Thread h2 = new Thread(new Hilo(2));
            Thread h3 = new Thread(new Hilo(3));

        //}

        h1.start();
        h2.start();
        h3.start();

        try {
            Thread.sleep(5000);
            h1.interrupt();
            h2.interrupt();
            h3.interrupt();

        }catch (InterruptedException e) {
            System.out.println("INTERRUMPIDO EL HILO PRINCIPAL");
        }
    }
}
