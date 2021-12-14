import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int CANTIDAD_MAXIMA = 50;
    public static final int HERRAMIENTA_MAXIMA = 130;
    public static final int HERRAMIENTA_MINIMA = 4;
    public static final int RECAMBIOS_MINIMA = 2;
    public static final int RECAMBIOS_MAXIMA = 29;
    public static final int LIMPIEZA_MAXIMA = 14;
    public static final int LIMPIEZA_MINIMA = 1;
    public static final int NUMERO_PRODUCTOS = 25;
    public static final int NUMERO_PROCESADORES = 12;
    public static final int NUMERO_PEDIDOS = 100000;

    public static void main(String[] args) {
        List<Pedido> listaPedidos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0;i<=NUMERO_PEDIDOS;i++){
            listaPedidos.add(pedidoAleatorio(random));
        }

        for (int j = 0;j<=NUMERO_PROCESADORES;j++){
            Thread h1 = new Thread(new Hilo(""+j, listaPedidos.get(j)));
        }

    }

    private static Pedido pedidoAleatorio(Random random){
        Pedido pedido;

        pedido = new Pedido(generarListaProducto(random));
        return pedido;
    }

    private static List<Producto> generarListaProducto(Random random){
        List<Producto> listaProductos = new LinkedList<>();
        int posicion = 1;

        while(posicion <=random.nextInt(NUMERO_PRODUCTOS)+1){
            switch (random.nextInt(3)+1){
                case 1:
                    listaProductos.add(new Producto(Tipo.HERRAMIENTAS,random.nextInt(CANTIDAD_MAXIMA),random.nextInt(HERRAMIENTA_MAXIMA)+HERRAMIENTA_MINIMA));
                    break;

                case 2:
                    listaProductos.add(new Producto(Tipo.LIMPIEZA,random.nextInt(CANTIDAD_MAXIMA),random.nextInt(LIMPIEZA_MAXIMA)+LIMPIEZA_MINIMA));
                    break;

                case 3:
                    listaProductos.add(new Producto(Tipo.RECAMBIOS,random.nextInt(CANTIDAD_MAXIMA),random.nextInt(RECAMBIOS_MAXIMA)+RECAMBIOS_MINIMA));
                    break;
            }
            posicion++;
        }
        return listaProductos;
    }

}
