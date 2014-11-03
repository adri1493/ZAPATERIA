package project1;

import java.util.*;

import javax.persistence.*;

@Entity

public class PagoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codPagoCompra;
    @ManyToOne
    private TipoPago unTipoPago;
    private double monto;
    private String CBU;
    private String nombreBanco;
    private String numeroCuenta;
    private String numeroDocumento;
    private String Titular;


    public PagoCompra(TipoPago unTipoPago, double monto, String CBU, String nombreBanco, String numeroCuenta, String numeroDocumento, String Titular) {
        super();
        this.codPagoCompra = 0;
        this.unTipoPago = unTipoPago;
        this.monto = monto;
        this.CBU = CBU;
        this.nombreBanco = nombreBanco;
        this.numeroCuenta = numeroCuenta;
        this.numeroDocumento = numeroDocumento;
        this.Titular = Titular;
    }

    public PagoCompra() {
    }


    public void setCodPagoCompra(int codPagoCompra) {
        this.codPagoCompra = codPagoCompra;
    }

    public int getCodPagoCompra() {
        return codPagoCompra;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setUnTipoPago(TipoPago unTipoPago) {
        this.unTipoPago = unTipoPago;
    }

    public TipoPago getUnTipoPago() {
        return unTipoPago;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

    public String getCBU() {
        return CBU;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
    }

    public String getTitular() {
        return Titular;
    }
}
