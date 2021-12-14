public class Hilo implements Runnable {

    private String nombre;

    Hilo(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Hola, soy el hilo: "+this.nombre);
        System.out.println("Hilo "+this.nombre+" terminado.\n");
    }


}
