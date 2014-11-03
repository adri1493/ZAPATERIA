package project1;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    private String nombre;
    private Boolean[] permiso = new Boolean[10];
    private boolean estado;


    public Rol() {

    }


    public Rol(String nombre, Boolean[] permiso, boolean estado) {
        super();
        this.nombre = nombre;
        this.permiso = permiso;
        this.estado = estado;
        Empresa.getPersistencia().insert(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public boolean getEstado() {
        return estado;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public void setPermiso(Boolean[] permiso) {
        this.permiso = permiso;
    }

    public Boolean[] getPermiso() {
        return permiso;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }


}
