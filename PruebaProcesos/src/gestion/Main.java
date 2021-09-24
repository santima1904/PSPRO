package gestion;

import clasesBasicas.FileAccess;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("notepad");//Declarar proceso con comando a ejecutar

        abrirBlocNotas(pb);
        System.out.println(FileAccess.comprobarFichero("Hola.txt", "."));
        imprimirEnvironment(pb);

        
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
