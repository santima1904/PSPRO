package clasesBasicas;

import java.io.File;

public class FileAccess {

    public static boolean comprobarFichero(String nombre, String ruta){

        File fich = new File(nombre, ruta);

        return fich.exists();
    }
}
