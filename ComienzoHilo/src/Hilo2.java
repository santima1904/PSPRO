public class Hilo2 implements Runnable{

    int numHilo, miParte, miCuenta = 0;

    private Contador cont;

    public int getMiCuenta() {
        return miCuenta;
    }

    public Hilo2(int numHilo, int miParte, Contador c) {
        this.numHilo = numHilo;
        this.miParte = miParte;
        this.cont = c;
    }


    @Override
    public void run() {
        for (int i = 0; i < miParte; i++){
            this.cont.incrementa();
            miCuenta++;
        }

        System.out.println("Hilo "+numHilo+", cuenta: "+getMiCuenta());
    }
}
