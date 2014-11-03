package project1;

import java.net.URL;

import java.util.Calendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

@Entity
public class Articulo {

    @Id
    private String codBarra;
    private String nombre;
    private int stock;
    private double precioVenta;
    private String color2;
    private String color;
    private int talle;
    private boolean enVidriera;
    @ManyToOne
    private Marca unaMarca;
    private String sexo;
    int ventasMes;

    /**
     * @associates <{project1.Categoria}>
     */
    @ManyToOne
    private Categoria unaCategoria;


    public Articulo(String codBarra, String nombre, int stock, double precioVenta, String color2, String color, int talle, boolean enVidriera, Marca unaMarca,
                    Categoria unaCategoria, String sexo) {
        super();
        this.unaCategoria = unaCategoria;
        this.codBarra = codBarra;
        this.nombre = nombre;
        this.stock = stock;
        this.precioVenta = precioVenta;
        this.color2 = color2;
        this.color = color;
        this.talle = talle;
        this.enVidriera = enVidriera;
        this.unaMarca = unaMarca;
        this.sexo = sexo;
    }

    public Articulo() {
    }

    public void setEnVidriera(boolean enVidriera) {
        this.enVidriera = enVidriera;
    }

    public boolean isEnVidriera() {
        return enVidriera;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVentasMes(int ventasMes) {
        this.ventasMes = ventasMes;
    }

    public int getVentasMes() {
        return ventasMes;
    }

    public void setTalle(int talle) {
        this.talle = talle;
    }

    public int getTalle() {
        return talle;
    }

    public void setStock(int stock) {
        this.stock = stock;
        Empresa.persistencia.update(this);
    }

    public int getStock() {
        return stock;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setUnaMarca(Marca unaMarca) {
        this.unaMarca = unaMarca;
    }

    public Marca getUnaMarca() {
        return unaMarca;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor2() {
        return color2;
    }

    public void setUnaCategoria(Categoria unaCategoria) {
        this.unaCategoria = unaCategoria;
    }

    public Categoria getUnaCategoria() {
        return unaCategoria;
    }

}


