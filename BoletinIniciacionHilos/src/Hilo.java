public class Hilo implements Runnable{

    String nombre;
    int[] listado;

    public Hilo(String nombre, int[] listado) {
        this.nombre = nombre;
        this.listado = listado;
    }

    @Override
    public void run() {
        int media = 0, maximo = 0, minimo = 0;
        if(!Thread.currentThread().isInterrupted()){
            if (!Thread.currentThread().isInterrupted()) {
                media = calcularMedia();
            }
            if (!Thread.currentThread().isInterrupted()) {
                maximo = calcularMaximo();
            }
            if (!Thread.currentThread().isInterrupted()) {
                minimo = calcularMinimo();
            }
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("**********************************"+"\n"+
                        "Hilo: " + nombre + "\n" +
                        "El mínimo es: " + minimo + "\n" +
                        "El máximo es: " + maximo + "\n" +
                        "La media  es: " + media
                );
            }else{
                System.out.println("Hilo "+nombre+" interrumpido");
            }
        }
    }

    /**
     * Cabecera: private int calcularMaximo()
     * Descripcion: Metodo para calcular el maximo de la array
     *
     * @return int
     */
    private int calcularMaximo(){
        int maximo = 1;

        for (int i = 0; i<listado.length&&!Thread.currentThread().isInterrupted();i++){
            if (listado[i]>maximo){
                maximo = listado[i];
            }
        }
        return maximo;
    }

    /**
     * Cabecera: private int calcularMinimo()
     * Descripcion: Metodo para calcular el minimo de la array
     *
     * @return int
     */
    private int calcularMinimo(){
        int minimo = 10000;

        for (int i = 0; i<listado.length&&!Thread.currentThread().isInterrupted();i++){
            if (listado[i]<minimo){
                minimo = listado[i];
            }
        }
        return minimo;
    }

    /**
     * Cabecera: private int calcularMedia()
     * Descripcion: Metodo para calcular la media de la array
     *
     * @return int
     */
    private int calcularMedia(){
        int media = 0;

        for (int i = 0; i<listado.length&&!Thread.currentThread().isInterrupted();i++){
            media += listado[i];
        }
        return (media / listado.length);
    }
}
