import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte [] hash = obtenerHash(obtenerCadena());
        imprimirHash(hash);
        byte [] hash2 = obtenerFichero("prueba.txt");
        imprimirHash(hash2);
    }

    public static byte[] obtenerCadena(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca la cadena a digerir: ");
        return scanner.nextLine().getBytes();
    }

    public static byte[] obtenerHash(byte[] informacion){
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(informacion);
        return messageDigest.digest();
    }

    public static void imprimirHash(byte[] hash){
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : hash){
            stringBuilder.append(String.format("%x",b));
        }
        System.out.printf("El codigo hash es: %s%n",stringBuilder);
    }

    public static byte[] obtenerFichero(String nombreFichero){
        byte[] b = null;
        try{
            b = (new FileInputStream(new File(nombreFichero))).readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
