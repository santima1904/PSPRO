package PruebaContarArray;

public class Consumidor implements Runnable {
    final Contenedor2 cont;
    String miNombre;

    Consumidor(Contenedor2 cont, String miNombre) {
        this.cont = cont;
        this.miNombre = miNombre;
    }
    private void consumirDato(int[] numeros){
        int sumaTotal=0;
        for (int i = 0; i < 100; i++) {
            sumaTotal+=numeros[i];
        }
        System.out.println("El total del array es: "+sumaTotal);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (cont) {
                while (cont.vacio()) {
                    try {
                        cont.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                consumirDato(cont.get());
                cont.notifyAll();
            }
        }
    }
}