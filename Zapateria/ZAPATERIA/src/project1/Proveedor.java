package project1;

import java.util.*;

import javax.persistence.*;

@Entity

public class Proveedor {
    @Id
    private String CUITPro;

    /**
     * @associates <{project1.PagoCompra}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, PagoCompra> pagosCompras;
    private double saldo;
    private String razonSocial;
    private String telPro;
    private String domPro;


    public Proveedor(double saldo, String razonSocial, String CUITPro, String telPro, String domPro) {
        this.saldo = saldo;
        this.pagosCompras = new HashMap();
        this.razonSocial = razonSocial;
        this.CUITPro = CUITPro;
        this.telPro = telPro;
        this.domPro = domPro;
        Empresa.getPersistencia().insert(this);
    }

    public Proveedor() {
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setCUITPro(String CUITPro) {
        this.CUITPro = CUITPro;
    }

    public String getCUITPro() {
        return CUITPro;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    public String getTelPro() {
        return telPro;
    }

    public void setDomPro(String domPro) {
        this.domPro = domPro;
    }

    public String getDomPro() {
        return domPro;
    }

    public void setMovimientos(Map movimientos) {
        this.pagosCompras = movimientos;
    }

    public Map getMovimientos() {
        return pagosCompras;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    /* public void agregarPagoCompra(TipoPago unTipoPago, double monto, String CBU, String nombreBanco, String numeroCuenta, String numeroDocumento,
                                  String TipoCuenta, String Titular) throws Exception {
            PagoCompra pagoCompra = new PagoCompra(unTipoPago, monto, CBU, nombreBanco, numeroCuenta, numeroDocumento, TipoCuenta, Titular);
            pagosCompras.put(pagoCompra.getCodPagoCompra(), pagoCompra);

    }

    public void modificarPagoCompra(int codPagoCompra, double monto, String detalleMovimiento, Compra unacompra, Calendar fechaHora, TipoPago unTipoPago) throws Exception {
        if (!this.pagosCompras.containsKey(codPagoCompra)) {
            PagoCompra unPagoCompra = (PagoCompra) pagosCompras.get(codPagoCompra);
            unPagoCompra.setMonto(monto);
        }
        throw new Exception("no existe movimiento");
    }*/

    @Override
    public String toString() {

        return this.getRazonSocial();
    }
}
