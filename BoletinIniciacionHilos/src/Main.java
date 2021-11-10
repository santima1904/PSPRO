import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int NUMERO_MAXIMO = 10000;
    public static final int NUMERO_ARRAY = 20;
    public static final int POSICIONES_ARRAY = 20;

    private static int[] rellenarArray(){
        int[] array = new int[POSICIONES_ARRAY];
        SecureRandom sr = new SecureRandom();

        for (int i = 0; i<array.length; i++){
            array[i] = sr.nextInt(NUMERO_MAXIMO)+1;
        }
        return array;
    }

    public static void main(String[] args) {
        List<int[]> listaArray = new ArrayList<>();

        for (int i = 0; i<NUMERO_ARRAY; i++){
            listaArray.add(rellenarArray());
        }

    }
}
