package project1;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Categoria {
    /**
     * @associates <{project1.Articulo}>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nroCateg;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Articulo> articulos;
    private String nombre;
    private int codPadre;
    private Boolean esPadre;


    public Categoria(String nombre, int codPadre, Boolean esPadre) {
        this();
        this.nroCateg = 0;
        this.esPadre = esPadre;
        this.nombre = nombre;
        this.codPadre = codPadre;
        Empresa.getPersistencia().insert(this);
    }

    public Categoria() {
        this.articulos = new HashMap();
    }

    public void setArticulos(Map articulos) {
        this.articulos = articulos;
    }

    public void setCodPadre(int codPadre) {
        this.codPadre = codPadre;
    }

    public int getCodPadre() {
        return codPadre;
    }

    public void setEsPadre(Boolean esPadre) {
        this.esPadre = esPadre;
    }

    public Boolean getEsPadre() {
        return esPadre;
    }

    public Map getArticulos() {
        return articulos;
    }

    public void setNroCateg(int nroCateg) {
        this.nroCateg = nroCateg;
    }

    public int getNroCateg() {
        return nroCateg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return this.nombre;
    }
}
