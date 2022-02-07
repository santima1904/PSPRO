import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        imprimirInformación(obtenerListaInterfaces());
    }

    private static List<NetworkInterface> obtenerListaInterfaces() {
        List<NetworkInterface> networkInterfaceList = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            networkInterfaceList = Collections.list(enumeration);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return networkInterfaceList;
    }

    private static void imprimirInformación(List<NetworkInterface> networkInterfaceList) {
        for (NetworkInterface networkInteface :
                networkInterfaceList) {
            try {
                if (networkInteface.getHardwareAddress() != null) {
                    System.out.println(String.format("Nombre: %s ,Nombre descriptivo: %s ,MAC: %s",
                            networkInteface.getName(), networkInteface.getDisplayName(), obtenerStringMAC(networkInteface.getHardwareAddress())));
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    private static String obtenerStringMAC(byte[] MAC) {
        StringBuilder stringBuilder = new StringBuilder();
        if (MAC != null) {
            for (byte b :
                    MAC) {
                stringBuilder.append(String.format("%02x", b));
            }
        } else {
            stringBuilder.append("MAC null");
        }
        return stringBuilder.toString();
    }
}