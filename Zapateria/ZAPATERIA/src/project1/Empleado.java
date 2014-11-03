package project1;

import java.util.*;

import javax.persistence.*;

@Entity
public class Empleado extends Persona {


    private Calendar desde;
    private int porcentaje;
    private double monto;
    private String usser;
    private String pasword;
    private Calendar creadoDia;
    private boolean estado;
    @ManyToOne
    private Rol unRol;


    public Empleado(String nroDoc, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido, String pasword, Calendar creadoDia, boolean estado,
                    Rol unRol, String usser, int porcentaje) {
        super(nroDoc, nombreEmpleado, domEmpleado, telEmpleado, apellido);
        this.usser = usser;
        this.pasword = pasword;
        this.creadoDia = creadoDia;
        this.estado = estado;
        this.unRol = unRol;
        this.porcentaje = porcentaje;
    }

    //nroDocEmpleado, nombreEmpleado, domEmpleado, telEmpleado, apellido, pasword, creadoDia, estado, rol, usser
    public Empleado(String nroDoc, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido, Calendar creadoDia, boolean estado, int porcentaje) {
        super(nroDoc, nombreEmpleado, domEmpleado, telEmpleado, apellido);
        this.creadoDia = creadoDia;
        this.estado = estado;
        this.porcentaje = porcentaje;
    }

    public Empleado() {
    }

    public void setUsser(String usser) {
        this.usser = usser;
    }

    public String getUsser() {
        return usser;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getPasword() {
        return pasword;
    }

    public void setCreadoDia(Calendar creadoDia) {
        this.creadoDia = creadoDia;
    }

    public Calendar getCreadoDia() {
        return creadoDia;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    public Rol getUnRol() {
        return unRol;
    }


    public void setDesde(Calendar desde) {
        this.desde = desde;
    }

    public Calendar getDesde() {
        return desde;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return this.getApellido() + " " + this.getNombreEmpleado();
    }
}

