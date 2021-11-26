import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static final int NUMERO_MAXIMO = 10000;
    public static final int NUMERO_ARRAY = 100;
    public static final int POSICIONES_ARRAY = 1000000;
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;
    public static final int MED_PRIORITY =5;


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
            Thread h1 = new Thread(new Hilo("" + i, listaArray.get(i)));
            if (i<33){
                h1.setPriority(MIN_PRIORITY);
            }else if (i>33&&i<=66){
                h1.setPriority(MED_PRIORITY);
            }else{
                h1.setPriority(MAX_PRIORITY);
            }
            listaHilos.add(h1);
        }

        for (Thread hilo : listaHilos) {
            hilo.start();
        }

        /*
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

         */
    }
}
