package project1;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codComision;
    private Calendar desde;
    private int porcentaje;
    private double monto;

    public Comision(Calendar desde, int porcentaje, double monto) {
        super();
        this.codComision = 0;
        this.desde = desde;
        this.porcentaje = porcentaje;
        this.monto = monto;
        Empresa.getPersistencia().insert(this);
    }

    public Comision() {
    }


    public void setCodComision(int codComision) {
        this.codComision = codComision;
    }

    public int getCodComision() {
        return codComision;
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


}
