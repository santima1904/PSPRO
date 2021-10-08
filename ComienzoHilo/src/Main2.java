public class Main2 {
    private static final int NUM_HILOS = 10;
    private static final int CUENTA_TOTAL = 100000;

    public static void main(String[] args) {
        Contador c = new Contador();
        Thread [] hilos = new Thread[NUM_HILOS];

        for (int i = 0; i < NUM_HILOS; i++){
            Thread th = new Thread(new Hilo2(i, CUENTA_TOTAL/NUM_HILOS, c));
            th.start();
            hilos[i] = th;
        }

        for (Thread h : hilos){
            try{
                h.join();
            } catch (InterruptedException e){

            }
        }
        System.out.println("Cuenta global: "+c.getCuenta());
    }
}
