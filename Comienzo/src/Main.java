import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        /*
        String linea;
        Runtime runtime=  Runtime.getRuntime();

        System.out.println(String.format("Numero de procesadores: %d",runtime.availableProcessors()));
        System.out.println(String.format("Memoria disponible: %d bytes", runtime.freeMemory()));
        System.out.println(String.format("Memoria maxima: %d bytes", runtime.maxMemory()));

        try {
           Process ejecucionComando =  runtime.exec("cmd /c dir");
           ejecucionComando.waitFor();
           BufferedReader br = new BufferedReader(new InputStreamReader(ejecucionComando.getInputStream()));

           while ((linea = br.readLine()) != null){
               System.out.println(linea);
           }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

        }

         */

        abrirBlocNotas();

    }

    public static void abrirBlocNotas(){
        ProcessBuilder pb = new ProcessBuilder("notepad");//Declarar proceso con comando a ejecutar
        pb.inheritIO();//para usar la consola java

        try {
            Process proceso = pb.start();//empezar proceso

            while(proceso.isAlive()){//mientras este activo, va a seguir el bucle
                System.out.println("Esta vivo");
                Thread.sleep(5000);//mandar a dormir el proceso principal durante el tiempo introducido(milisegundos)
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
