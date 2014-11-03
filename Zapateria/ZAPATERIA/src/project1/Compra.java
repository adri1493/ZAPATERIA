package project1;

import java.util.*;

import javax.persistence.*;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codCompra;

    /**
     * @associates <{project1.DetalleCompra}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, DetalleCompra> detallesCompra;

    /**
     * @associates <{project1.TipoPago}>
     */
    @ManyToMany
    private Map<Integer, TipoPago> tiposPagos;
    @ManyToOne
    private Proveedor unProveedor;
    @ManyToOne
    private Empleado unUsuario;
    private double total;
    private Calendar fechaHora;

    /**
     * @associates <{project1.PagoCompra}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, Pago> pagosCompras;


    public Compra(Proveedor unProveedor, Empleado unUsuario, double total, Calendar fechaHora) {
        this();
        this.codCompra = 0;
        this.unProveedor = unProveedor;
        this.unUsuario = unUsuario;
        this.total = total;
        this.fechaHora = fechaHora;
        Empresa.getPersistencia().insert(this);
    }

    public Compra() {
        this.tiposPagos = new HashMap();
        this.pagosCompras = new HashMap();
        this.detallesCompra = new HashMap();
    }

    public void setUnProveedor(Proveedor unProveedor) {
        this.unProveedor = unProveedor;
    }

    public Proveedor getUnProveedor() {
        return unProveedor;
    }

    public void setDetallesCompra(Map detallesCompra) {
        this.detallesCompra = detallesCompra;
    }

    public Map getDetallesCompra() {
        return detallesCompra;
    }

    public void setTipoPago(Map tipoPago) {
        this.tiposPagos = tipoPago;
    }

    public Map getTipoPago() {
        return tiposPagos;
    }


    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setUnUsuario(Empleado unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Empleado getUnUsuario() {
        return unUsuario;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setPagosCompras(Collection pagosCompras) {
        for (Iterator iter = pagosCompras.iterator(); iter.hasNext();) {
            Pago unP = (Pago)iter.next();
            this.pagosCompras.put(unP.getCodPago(), unP);
        }
    }

    public Map<Integer, Pago> getPagosCompras() {
        return pagosCompras;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void agregarPagoCompra(TipoPago unTipoPago, double monto, String CBU, String nombreBanco, String numeroCuenta, String numeroDocumento,
                                  String Titular) throws Exception {
        Pago pago = new Pago(unTipoPago, monto, CBU, nombreBanco, numeroCuenta, numeroDocumento, Titular);
        pagosCompras.put(pago.getCodPago(), pago);

    }

    public void agregarDetalleCompra(int cantidad, double precio, Articulo unArticulo) throws Exception {
        DetalleCompra unDetalle = new DetalleCompra(cantidad, precio, unArticulo);
        this.detallesCompra.put(unDetalle.getCodDetalleCompra(), unDetalle);
    }

    public boolean eliminarDetalleCompra(int codDetalleCompra) throws Exception {
        boolean retorno = false;
        if (this.detallesCompra.containsKey(codDetalleCompra)) {
            //Marca  unArticulo = (Articulo) articulos.get(codBarra);
            this.detallesCompra.remove(codDetalleCompra);
            retorno = true;
        } else {
            throw new Exception("Detalle no Existe");
        }
        return retorno;
    }

    public void modificarDetalleCompra(double precio, int codDetalleCompra, int cantidad, Articulo unArticulo) throws Exception {
        if (this.detallesCompra.containsKey(codDetalleCompra)) {
            DetalleCompra unDetalleCompra = (DetalleCompra) detallesCompra.get(codDetalleCompra);
            unDetalleCompra.setPrecio(precio);
            unDetalleCompra.setCantidad(cantidad);
            unDetalleCompra.setUnArticulo(unArticulo);
        }
        throw new Exception("no existe la compra");
    }

}
