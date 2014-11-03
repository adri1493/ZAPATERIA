package project1;

import java.util.*;

import javax.persistence.*;

@Entity
public class Turno {
    @Id
    private int codTurno;
    private Calendar fechaHora;
    private double saldoInicial;
    private double saldoFinal;

    /**
     * @associates <{project1.CierreCaja}>
     */
    @OneToMany
    private Map<Integer, CierreCaja> cierresCajas;

    /**
     * @associates <{project1.MovimientoCaja}>
     */
    @OneToMany
    private Map<Integer, MovimientoCaja> movimientosCaja;
    @ManyToOne
    private Empleado unEmpleado;


    public Turno(int codTurno, Calendar fechaHora, double saldoInicial, double saldoFinal) {
        this();
        this.codTurno = codTurno;
        this.fechaHora = fechaHora;
        this.saldoInicial = saldoInicial;
        this.saldoFinal = saldoFinal;
        Empresa.getPersistencia().insert(this);
    }

    public Turno() {
        this.cierresCajas = new HashMap();
        this.movimientosCaja = new HashMap();
    }

    public void setCodTurno(int codTurno) {
        this.codTurno = codTurno;
    }

    public int getCodTurno() {
        return codTurno;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }


    public void setCierresCajas(Map cierresCajas) {
        this.cierresCajas = cierresCajas;
    }

    public Map getCierresCajas() {
        return cierresCajas;
    }

    public void setMovimientosCaja(Map movimientosCaja) {
        this.movimientosCaja = movimientosCaja;
    }

    public Map getMovimientosCaja() {
        return movimientosCaja;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }

    public Empleado getUnEmpleado() {
        return unEmpleado;
    }
    //cierre Caja
    /*  public void agregarCierreCaja(int codCierreCaja, double saldoSistema, double saldoReal, TipoPago tipospago, String descripcion) throws Exception {
        if (!this.cierresCajas.containsKey(codCierreCaja)) {
            this.cierresCajas.put(codCierreCaja, new CierreCaja(codCierreCaja, saldoSistema, saldoReal, tipospago, descripcion));
        } else {
            throw new Exception("El cierre de caja ya Existe");
        }
    }

    public void modificarCierreCaja(int codCierreCaja, double saldoSistema, double saldoReal, TipoPago tipospago, String descripcion) throws Exception {
        if (this.cierresCajas.containsKey(codCierreCaja)) {
            CierreCaja unCierreCaja = (CierreCaja) cierresCajas.get(codCierreCaja);
            unCierreCaja.setCodCierreCaja(codCierreCaja);
            unCierreCaja.setDescripcion(descripcion);
            unCierreCaja.setSaldoReal(saldoReal);
            unCierreCaja.setSaldoSistema(saldoSistema);
            unCierreCaja.setTipopago(tipospago);
        }
        throw new Exception("no existe el cierre de caja");
    }
    //movimiento caja
    /*public void agregarMovimientoCaja(Venta unaVenta) throws Exception {
        Venta unaVenta =  new
            this.movimientosCaja.put(movimientoCaja, new MovimientoCaja(unaVenta));
        } else {
            throw new Exception("El cierre de caja ya Existe");
        }
    }*/

}
