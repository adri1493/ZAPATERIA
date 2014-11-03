package project1;

import java.util.*;

import javax.persistence.*;

@Entity
public class Marca extends Observable {
    /**
     * @associates <{project1.Articulo}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Articulo> articulos;
    @Id
    private String nombreMarca;

    public Marca(String nombreMarca) {
        this.articulos = new HashMap();
        this.nombreMarca = nombreMarca;
        Empresa.getPersistencia().insert(this);
    }

    public Marca() {
    }

    public void setArticulos(Map articulos) {
        this.articulos = articulos;
    }

    public Map getArticulos() {
        return articulos;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    @Override
    public String toString() {
        return this.nombreMarca;
    }

}
