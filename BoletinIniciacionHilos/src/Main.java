import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static final int NUMERO_MAXIMO = 10000;
    public static final int NUMERO_ARRAY = 20;
    public static final int POSICIONES_ARRAY = 1000000;

    private static int[] rellenarArray(){
        int[] array = new int[POSICIONES_ARRAY];
        Random sr = new Random();

        for (int i = 0; i<array.length; i++){
            array[i] = sr.nextInt(NUMERO_MAXIMO)+1;
        }
        return array;
    }

    public static void main(String[] args) {
        List<int[]> listaArray = new ArrayList<>();
        List<Thread> listaHilos = new ArrayList<>();

        for (int i = 0; i < NUMERO_ARRAY; i++) {
            listaArray.add(rellenarArray());
            listaHilos.add(new Thread(new Hilo("" + i, listaArray.get(i))));
        }

        for (Thread hilo : listaHilos) {
            hilo.start();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }

        for (Thread hilo : listaHilos) {
            if (hilo.isAlive()) {
                hilo.interrupt();
            }
        }
        System.out.println("Calculos interrumpidos");
    }
}
