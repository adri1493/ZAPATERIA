package project1;

import javax.persistence.*;

@Entity

public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codDetalleVenta;
    private double precio;
    private int cantidad;
    @ManyToOne
    private Articulo unArticulo;

    public DetalleVenta(int cantidad, double precio, Articulo unArticulo) {
        super();
        this.codDetalleVenta = 0;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unArticulo = unArticulo;
        Empresa.getPersistencia().insert(this);
    }

    public DetalleVenta() {
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCodDetalleVenta(int codDetalleVenta) {
        this.codDetalleVenta = codDetalleVenta;
    }

    public int getCodDetalleVenta() {
        return codDetalleVenta;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setUnArticulo(Articulo unArticulo) {
        this.unArticulo = unArticulo;
    }

    public Articulo getUnArticulo() {
        return unArticulo;
    }
}
