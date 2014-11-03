package project1;

import javax.persistence.*;

@Entity

public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codDetalleCompra;
    private double precio;
    private int cantidad;
    @ManyToOne
    private Articulo unArticulo;

    public DetalleCompra(int cantidad, double precio, Articulo unArticulo) {
        super();
        this.codDetalleCompra = 0;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unArticulo = unArticulo;
        Empresa.getPersistencia().insert(this);
    }

    public DetalleCompra() {
    }

    public void setUnArticulo(Articulo unArticulo) {
        this.unArticulo = unArticulo;
    }

    public void setCodDetalleCompra(int codDetalleCompra) {
        this.codDetalleCompra = codDetalleCompra;
    }

    public int getCodDetalleCompra() {
        return codDetalleCompra;
    }

    public Articulo getUnArticulo() {
        return unArticulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }
}
