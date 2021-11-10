public class IA implements Runnable{
    int identificador;

    public IA(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public void run() {
        try {
            System.out.println("Calculando IA "+identificador);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
