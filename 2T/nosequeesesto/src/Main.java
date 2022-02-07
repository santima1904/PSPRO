import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Host:");
        String host = teclado.next();
        System.out.println("Ip:");
        String ip = teclado.next();
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println(inetAddress);
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
