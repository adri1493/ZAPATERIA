package project1;

import java.util.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Persona extends Observable {
    @Id
    private String nroDoc;
    private String nombre;
    private String domicilio;
    private String telefono;
    private String apellido;


    public Persona() {
    }

    public Persona(String nroDoc, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido) {
        super();
        this.nroDoc = nroDoc;
        this.nombre = nombreEmpleado;
        this.domicilio = domEmpleado;
        this.telefono = telEmpleado;
        this.apellido = apellido;
        Empresa.getPersistencia().insert(this);
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNroDocEmppleado() {
        return nroDoc;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombre = nombreEmpleado;
    }

    public String getNombreEmpleado() {
        return nombre;
    }

    public void setDomEmpleado(String domEmpleado) {
        this.domicilio = domEmpleado;
    }

    public String getDomEmpleado() {
        return domicilio;
    }

    public void setTelEmpleado(String telEmpleado) {
        this.telefono = telEmpleado;
    }

    public String getTelEmpleado() {
        return telefono;
    }

    public void setNroDocEmppleado(String nroDocEmppleado) {
        this.nroDoc = nroDocEmppleado;
    }
}
