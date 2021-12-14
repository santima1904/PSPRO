package PruebaContarArray;

import java.util.ArrayList;
import java.util.List;

public class Contenedor2<T> {
    private List<int[]> datos = new ArrayList<>();

    synchronized public int[] get() {
        int [] result = datos.get(0);
        datos.remove(0);
        return result;
    }

    synchronized public void put(int[] valor) {
        datos.add(valor);
    }

    synchronized public  boolean maximoAlcanzado() {
        return (datos.size() == 10);
    }

    synchronized public boolean vacio() {
        return datos.isEmpty();
    }
}
