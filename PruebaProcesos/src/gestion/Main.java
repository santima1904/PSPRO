/**
 * Ejercicio de abrir el bloc de notas cometnado y ejercicico de redireccionar la entrada y salida sin comentar
 */


package gestion;

import clasesBasicas.FileAccess;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        File fichero = new File("comandos.txt");
        File salida = new File("salida.txt" );
       // ProcessBuilder pb = new ProcessBuilder("notepad");//Declarar proceso con comando a ejecutar

        ProcessBuilder pb = new ProcessBuilder("cmd");

        //pb.inheritIO();Esto para el caso de no tener redireccionada la salida, para que se redierccione automaticamente
        pb.redirectInput(fichero);
        pb.redirectOutput(salida);

        try {
            pb.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void abrirBlocNotas(ProcessBuilder pb){

        pb.inheritIO();//para usar la consola java

        try {
            Process proceso = pb.start();//empezar proceso
            proceso.waitFor(30, TimeUnit.SECONDS);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirEnvironment(ProcessBuilder pb) {

        for (Map.Entry<String, String> entry : pb.environment().entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


}
