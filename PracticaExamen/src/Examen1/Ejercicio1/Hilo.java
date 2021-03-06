package Examen1.Ejercicio1;

public class Hilo implements Runnable {
    private final int PAUSA_MILISEGUNDOS = 1000;
    private final int número;

    public Hilo(int número) {
        this.número = número;
    }

    @Override
    public void run() {
        hacerPausa(PAUSA_MILISEGUNDOS);
        System.out.println(String.format("El factorial de %d es %d",
                número, factorial()));
    }

    private void hacerPausa(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private long factorial() {
        long factorial = 1;
        for (int i = número; i > 1; i--)
            factorial *= i;
        return factorial;
    }
}
