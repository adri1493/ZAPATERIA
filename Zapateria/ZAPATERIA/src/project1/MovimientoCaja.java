package project1;

import java.util.*;

import javax.persistence.*;

@Entity
public class MovimientoCaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nroMovimientoCaja;
    @OneToOne
    private Venta unaVenta;

    public MovimientoCaja(Venta unaVenta) {
        this.nroMovimientoCaja = 0;
        this.unaVenta = unaVenta;
        Empresa.getPersistencia().insert(this);
    }
    
    public MovimientoCaja() {
    }

    public void setUnaVenta(Venta unaVenta) {
        this.unaVenta = unaVenta;
    }

    public Venta getUnaVenta() {
        return unaVenta;
    }

    public void setNroMovimientoCaja(int nroMovimientoCaja) {
        this.nroMovimientoCaja = nroMovimientoCaja;
    }

    public int getNroMovimientoCaja() {
        return nroMovimientoCaja;
    }
}
