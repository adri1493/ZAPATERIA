package project1;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Caja {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codCaja;
    private Calendar fecha;
    private double saldoInicial;
    private boolean cajaAbierta;

    /**
     * @associates <{project1.Turno}>
     */
    @OneToMany
    private Map<Integer, Turno> turnos;

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
    @ManyToOne
    private Empleado unEmpleadoCierre;
    private Calendar fechaCierreCaja;
    //constructores


    public Caja(Calendar fecha, double saldoInicial, boolean cajaAbierta, Empleado unEmpleado) {
        this();
        this.codCaja = 0;
        this.fecha = fecha;
        this.saldoInicial = saldoInicial;
        this.cajaAbierta = cajaAbierta;
        this.unEmpleado = unEmpleado;
        Empresa.getPersistencia().insert(this);
    }

    public Caja() {
        this.turnos = new HashMap();
        this.cierresCajas = new HashMap();
        this.movimientosCaja = new HashMap();
    }

    //getter y setter
    public void setCajaAbierta(boolean cajaAbierta) {
        this.cajaAbierta = cajaAbierta;
    }

    public boolean isCajaAbierta() {
        return cajaAbierta;
    }


    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setCierresCajas(Map<Integer, CierreCaja> cierresCajas) {
        this.cierresCajas = cierresCajas;
    }

    public Map<Integer, CierreCaja> getCierresCajas() {
        return cierresCajas;
    }

    public void setMovimientosCaja(Map<Integer, MovimientoCaja> movimientosCaja) {
        this.movimientosCaja = movimientosCaja;
    }

    public Map<Integer, MovimientoCaja> getMovimientosCaja() {
        return movimientosCaja;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }

    public Empleado getUnEmpleado() {
        return unEmpleado;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getFecha() {
        return fecha;
    }


    public void setCodCaja(int codCaja) {
        this.codCaja = codCaja;
    }

    public int getCodCaja() {
        return codCaja;
    }

    public void setTurnos(Map turnos) {
        this.turnos = turnos;
    }

    public Map getTurnos() {
        return turnos;
    }

    public void setUnEmpleadoCierre(Empleado unEmpleadoCierre) {
        this.unEmpleadoCierre = unEmpleadoCierre;
    }

    public Empleado getUnEmpleadoCierre() {
        return unEmpleadoCierre;
    }

    public void setCierreCaja(Calendar CierreCaja) {
        this.fechaCierreCaja = CierreCaja;
    }

    public Calendar getCierreCaja() {
        return fechaCierreCaja;
    }
    //metodos
    //cierre Caja
    public void agregarCierreCaja(double saldoSistema, double saldoReal, TipoPago tipospago, String descripcion) throws Exception {
        CierreCaja unCierreCaja = new CierreCaja(saldoSistema, saldoReal, tipospago, descripcion);
        this.cierresCajas.put(unCierreCaja.getCodCierreCaja(), unCierreCaja);
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
    public void agregarMovimientoCaja(Venta unaVenta) throws Exception {
        MovimientoCaja unMovimiento = new MovimientoCaja(unaVenta);
        this.movimientosCaja.put(unMovimiento.getNroMovimientoCaja(), unMovimiento);
        Empresa.persistencia.update(this);
    }

}
