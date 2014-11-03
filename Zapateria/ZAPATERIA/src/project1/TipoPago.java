package project1;

import java.util.*;

import javax.persistence.*;

@Entity
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codTipoPago;
    private String nombre;
    private Boolean[] parametros = new Boolean[6];

    public TipoPago(String nombre, Boolean[] parametros) {
        super();
        this.codTipoPago = 0;
        this.nombre = nombre;
        this.parametros = parametros;

        Empresa.getPersistencia().insert(this);
    }

    public TipoPago() {
    }

    public void setCodTipoPago(int codTipoPago) {
        this.codTipoPago = codTipoPago;
    }

    public int getCodTipoPago() {
        return codTipoPago;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setParametros(Boolean[] parametros) {
        this.parametros = parametros;
    }

    public Boolean[] getParametros() {
        return parametros;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
