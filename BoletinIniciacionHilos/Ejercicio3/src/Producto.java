import java.util.List;

public class Producto {
    private Tipo tipoProducto;
    private int cantidad;
    private double precioUnitario;

    public Producto(Tipo tipoProducto, int cantidad, double precioUnitario) {
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Tipo getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Tipo tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
