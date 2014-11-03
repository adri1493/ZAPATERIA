package project1;

import java.util.Calendar;

import javax.persistence.*;

@Entity
public class CierreCaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codCierreCaja;
    private double saldoSistema;
    private double saldoReal;
    @OneToOne
    private TipoPago tipospago;
    private String descripcion;


    public CierreCaja(double saldoSistema, double saldoReal, TipoPago tipospago, String descripcion) {
        super();
        this.codCierreCaja = 0;
        this.saldoSistema = saldoSistema;
        this.saldoReal = saldoReal;
        this.tipospago = tipospago;
        this.descripcion = descripcion;
        Empresa.getPersistencia().insert(this);
    }

    public CierreCaja() {
    }


    public void setCodCierreCaja(int codCierreCaja) {
        this.codCierreCaja = codCierreCaja;
    }

    public int getCodCierreCaja() {
        return codCierreCaja;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setSaldoSistema(double saldoSistema) {
        this.saldoSistema = saldoSistema;
    }

    public double getSaldoSistema() {
        return saldoSistema;
    }

    public void setSaldoReal(double saldoReal) {
        this.saldoReal = saldoReal;
    }

    public double getSaldoReal() {
        return saldoReal;
    }

    public void setTipopago(TipoPago tipopago) {
        this.tipospago = tipopago;
    }

    public TipoPago getTipopago() {
        return tipospago;
    }
}
