package project1;


import project1.Empresa;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Auditoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String operacion;
    private String tabla;
    private String dato;
    private String usuario;
    private String detalle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fecha;
    private String hora;

    public Auditoria() {
    }


    public Auditoria(String unaOp, String tabla, String dato, String detalle, String usuario) throws Exception {
        this.id = 0;
        this.operacion = unaOp.toUpperCase();
        this.tabla = tabla.toUpperCase();
        this.dato = dato.toUpperCase();
        this.detalle = detalle.toUpperCase();
        this.fecha = new GregorianCalendar();
        int hora;
        int minutos;
        String horaFinal;
        Calendar unCalendar = new GregorianCalendar();
        hora = unCalendar.get(Calendar.HOUR_OF_DAY);
        minutos = unCalendar.get(Calendar.MINUTE);
        horaFinal = hora + ":" + minutos;
        this.hora = horaFinal;
        this.usuario = usuario.toUpperCase();
        Empresa.persistencia.insert(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getDato() {
        return dato;
    }

    public void setDati(String dato) {
        this.dato = dato;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return this.getOperacion();
    }

}
