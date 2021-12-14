public class Hilo implements Runnable{

    private String nombre;
    private Pedido pedido;

    public Hilo(String nombre, Pedido pedido) {
        this.nombre = nombre;
        this.pedido = pedido;
    }

    @Override
    public void run() {
        double precio = 0;
        int cantidad = 0;
        for (Producto p:pedido.getProductos()) {
            precio += p.getPrecioUnitario();
            cantidad += p.getCantidad();
        }
    }
}
