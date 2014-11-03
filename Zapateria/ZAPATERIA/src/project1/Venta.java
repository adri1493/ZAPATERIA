package project1;


import java.util.*;

import javax.persistence.*;

@Entity
public class Venta {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codVenta;

    /**
     * @associates <{project1.DetalleVenta}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, DetalleVenta> detallesVenta;

    /**
     * @associates <{project1.PagoVenta}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, Pago> pagosVentas;

    @ManyToOne
    private Empleado unEmpleado;
    @ManyToOne
    private Empleado unUsuario;
    private double total;
    private Calendar fechaVenta;
    private String nombreCliente;
    private String domicilioCliente;
    private String numeroDocCliente;

    //constructores
    public Venta() {
        this.detallesVenta = new HashMap();
        this.pagosVentas = new HashMap();
    }


    public Venta(Empleado unEmpleado, Empleado unUsuario, double total, Calendar fechaVenta, String nombreCliente, String domicilioCliente,
                 String numeroDocCliente) {
        this();
        this.codVenta = 0;
        this.unEmpleado = unEmpleado;
        this.unUsuario = unUsuario;
        this.total = total;
        this.fechaVenta = fechaVenta;
        this.nombreCliente = nombreCliente;
        this.domicilioCliente = domicilioCliente;
        this.numeroDocCliente = numeroDocCliente;
        Empresa.getPersistencia().insert(this);
    }

    //getter y setter
    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setPagosVentas(Collection pagosVentas) {
        for (Iterator iter = pagosVentas.iterator(); iter.hasNext();) {
            Pago unP = (Pago) iter.next();
            this.pagosVentas.put(unP.getCodPago(), unP);
        }
    }

    public Map getPagosVentas() {
        return pagosVentas;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }

    public Empleado getUnEmpleado() {
        return unEmpleado;
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

    public void setDetallesVenta(Map detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    public Map getDetallesVenta() {
        return detallesVenta;
    }

    public void setFechaVenta(Calendar fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Calendar getFechaVenta() {
        return fechaVenta;
    }


    public void setDomicilioCliente(String domicilioCliente) {
        this.domicilioCliente = domicilioCliente;
    }

    public String getDomicilioCliente() {
        return domicilioCliente;
    }

    public void setNumeroDocCliente(String numeroDocCliente) {
        this.numeroDocCliente = numeroDocCliente;
    }

    public String getNumeroDocCliente() {
        return numeroDocCliente;
    }
    //metodos
    public void agregarPagoVenta(TipoPago unTipoPago, double monto, String CBU, String nombreBanco, String numeroCuenta, String numeroDocumento,
                                 String Titular) throws Exception {
        Pago pagoVenta = new Pago(unTipoPago, monto, CBU, nombreBanco, numeroCuenta, numeroDocumento, Titular);
        pagosVentas.put(pagoVenta.getCodPago(), pagoVenta);

    }

    /*public void modificarPagoVenta(int codPagoVenta, TipoPago unTipoPago, double monto) throws Exception {
        if (!this.pagosVentas.containsKey(codPagoVenta)) {
            PagoVenta unPagoVenta = (PagoVenta) pagosVentas.get(codPagoVenta);
            unPagoVenta.setMonto(monto);
            unPagoVenta.setUnTipoPago(unTipoPago);
            throw new Exception("no existe movimiento");
        }
    }*/
    //detalleVenta
    public void agregarDetalleVenta(int cantidad, double precio, Articulo unArticulo) throws Exception {
        DetalleVenta unDetalle = new DetalleVenta(cantidad, precio, unArticulo);
        this.detallesVenta.put(unDetalle.getCodDetalleVenta(), unDetalle);
    }

    public boolean eliminarDetalleVenta(int codDetalleVenta) throws Exception {
        boolean retorno = false;
        if (this.detallesVenta.containsKey(codDetalleVenta)) {
            this.detallesVenta.remove(codDetalleVenta);
            retorno = true;
        } else {
            throw new Exception("El tipo pago no Existe");
        }
        return retorno;
    }

    public void modificarDetalleVenta(int cantidad, int codDetalleVenta, double precio, Articulo unArticulo) throws Exception {
        if (this.detallesVenta.containsKey(codDetalleVenta)) {
            DetalleVenta unDetalleVenta = (DetalleVenta) detallesVenta.get(codDetalleVenta);
            unDetalleVenta.setCantidad(cantidad);
            unDetalleVenta.setCodDetalleVenta(codDetalleVenta);
            unDetalleVenta.setPrecio(precio);
            unDetalleVenta.setUnArticulo(unArticulo);
        }
        throw new Exception("no existe la marca");
    }
}
