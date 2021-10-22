package PruebaContarArray;

import java.util.List;

public class Contenedor2<T> {
    private List<int[]> datos;

    synchronized public int[] get() {
        int [] result = datos.get(0);
        datos.remove(0);
        return result;
    }

    synchronized public void put(int[] valor) {
        this.datos.add(valor);
    }

    synchronized public  boolean maximoAlcanzado() {
        return (this.datos.size() == 10);
    }

    synchronized public boolean vacio() {
        return datos.isEmpty();
    }
}
