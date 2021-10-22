package pruebaEjercicioTabular;

class Contenedor<T> {
    private T dato;

    synchronized public T get() {
        T result = this.dato;
        this.dato = null;
        return result;
    }

    synchronized public void put(T valor) {
        this.dato = valor;
    }

    synchronized boolean datoDisponible() {
        return (this.dato != null);
    }
}

class HiloProductor implements Runnable {
    final Contenedor <Integer> cont;
    String miNombre;

    HiloProductor(Contenedor<Integer> cont, String miNombre) {
        this.cont = cont;
        this.miNombre = miNombre;
    }

    @Override
    public void run() {
        for (int i = 1; ; i++) {
            synchronized (this.cont) {
                while (this.cont.datoDisponible()) {
                    try {
                        this.cont.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                System.out.printf("Hilo %s produce valor %s .\n", this.miNombre, i);
                this.cont.put(i);
                this.cont.notifyAll();
            }
        }
    }
}

class HiloConsumidor implements Runnable {
    final Contenedor<Integer>cont;
    String miNombre;

    HiloConsumidor(Contenedor<Integer> cont, String miNombre) {
        this.cont = cont;
        this.miNombre = miNombre;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.cont) {
                while (!this.cont.datoDisponible()) {
                    try {
                        this.cont.wait();
                    } catch (InterruptedException ex) {
                    }
                }
                Integer dato = this.cont.get();
                this.cont.notify();
                System.out.printf("Hilo %s consume valor %d.\n", this.miNombre, dato);
            }
        }
    }
}

class ProductorConsumidor {
/*
    public static void main(String[] args) {
        pruebaEjercicioTabular.Contenedor<Integer> almacen = new pruebaEjercicioTabular.Contenedor<Integer>();
        Thread hprod = new Thread(new pruebaEjercicioTabular.HiloProductor(almacen, "P"));
        Thread hcons = new Thread(new pruebaEjercicioTabular.HiloConsumidor(almacen, "C")); hprod.start();
        hcons.start();
    }

 */

///*
    public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<Integer>();
        Thread hprod1 = new Thread(new HiloProductor(almacen, "P1"));
        Thread hprod2 = new Thread(new HiloProductor(almacen, "P2"));
        Thread hcons1 = new Thread(new HiloConsumidor(almacen, "C1"));
        Thread hcons2 = new Thread(new HiloConsumidor(almacen, "C2"));
        hprod1.start();
        hprod2.start();
        hcons1.start();
        hcons2.start();
    }
    //*/

}
