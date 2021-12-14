package PruebaContarArray;

public class Main2 {
    public static void main(String[] args) {
        Contenedor2 almacen = new Contenedor2();

        try {
        Thread hprod1 = new Thread(new Productor(almacen, "P1"));
        Thread hprod2 = new Thread(new Productor(almacen, "P2"));
        Thread hprod3 = new Thread(new Productor(almacen, "P3"));
        Thread hprod4 = new Thread(new Productor(almacen, "P4"));
        Thread hprod5 = new Thread(new Productor(almacen, "P5"));
        Thread hcons1 = new Thread(new Consumidor(almacen, "C1"));
        Thread hcons2 = new Thread(new Consumidor(almacen, "C2"));
        Thread hcons3 = new Thread(new Consumidor(almacen, "C3"));
        Thread hcons4 = new Thread(new Consumidor(almacen, "C4"));
        Thread hcons5 = new Thread(new Consumidor(almacen, "C4"));
        hprod1.start();
        hprod2.start();
        hprod3.start();
        hprod4.start();
        hprod5.start();
        hcons1.start();
        hcons2.start();
        hcons3.start();
        hcons4.start();
        hcons5.start();


            Thread.sleep(10000);
            hcons1.interrupt();
            hcons2.interrupt();
            hcons3.interrupt();
            hcons4.interrupt();
            hcons5.interrupt();
            hprod1.interrupt();
            hprod2.interrupt();
            hprod3.interrupt();
            hprod4.interrupt();
            hprod5.interrupt();

        }catch (InterruptedException e) {
            //System.out.println("INTERRUMPIDO EL HILO PRINCIPAL");
        }
    }
}
