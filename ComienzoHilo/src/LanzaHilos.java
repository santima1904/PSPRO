public class LanzaHilos {
    public static void main(String[] args) {


        Thread h1 = new Thread(new Hilo("H1"));
        Thread h2 = new Thread(new Hilo("H2"));

        h1.start();
        h2.start();

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        /**
         *Prueba de hacerlo muchas veces
         */
        /*
        for (int i = 0; i <= 1000000000; i++){
            Thread h = new Thread(new Hilo("H"+i));
            h.start();
        }

        */

        System.out.println("Hilo principal terminado");

    }
}
