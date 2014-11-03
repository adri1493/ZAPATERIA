package project1;

import Interfaz.GuiIngresar;

import java.awt.Image;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStreamReader;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import org.hibernate.annotations.Type;

@Entity

public class Empresa extends Observable {

    //Atributos

    @Id
    private String CUIL;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String email;
    //@Type(type = "org.hibernate.type.PrimitiveByteArrayBlobType")
    private byte[] foto;
    public static Persistencia persistencia = new Persistencia();
    private Calendar fechaUltimo;
    private String file;
    private int dias;
    private String nombreBackup;
    private int mes;

    /**
     * @associates <{project1.Persona}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Persona> personas;

    /**
     * @associates <{project1.Articulo}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Articulo> articulos;

    /**
     * @associates <{project1.Rol}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, Rol> roles;


    /**
     * @associates <{project1.Categoria}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, Categoria> categorias;

    /**
     * @associates <{project1.Marca}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Marca> marcas;

    /**
     * @associates <{project1.Compra}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, Compra> compras;

    /**
     * @associates <{project1.Proveedor}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Proveedor> proveedores;

    /**
     * @associates <{project1.Caja}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, Caja> cajas;

    /**
     * @associates <{project1.TipoPago}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, TipoPago> tiposPagos;

    /**
     * @associates <{project1.Empleado}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Empleado> empleados;

    /**
     * @associates <{project1.Venta}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<Integer, Venta> ventas;

    /**
     * @associates <{project1.Auditoria}>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Map<Integer, Auditoria> auditorias;

    /**
     * @associates <{project1.Usuario}>
     */
    /*   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Map<String, Usu> usuarios;
*/

    //Constructores


    public Empresa() {
        this.articulos = new HashMap();
        this.cajas = new HashMap();
        this.categorias = new HashMap();
        this.compras = new HashMap();
        this.empleados = new HashMap();
        this.marcas = new HashMap();
        this.personas = new HashMap();
        this.proveedores = new HashMap();
        this.roles = new HashMap();
        this.tiposPagos = new HashMap();
        this.ventas = new HashMap();
        this.auditorias = new HashMap();
        //this.persistencia = new Persistencia();

    }

    public Empresa(String CUIL, String razonSocial, String direccion, String telefono, String email) {
        this();
        this.CUIL = CUIL;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.foto = toArrayByte("C:\\Users\\Adrian\\Downloads\\fotos.jpg");
        this.getPersistencia().insert(this);
    }


    //Getter y Setter

    public void setCUIL(String CUIL) {
        this.CUIL = CUIL;
        setChanged();
    }

    public String getCUIL() {
        return CUIL;
    }

    public void setFechaUltimo(Calendar fechaUltimo) {
        this.fechaUltimo = fechaUltimo;
    }

    public Calendar getFechaUltimo() {
        return fechaUltimo;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
        setChanged();
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setNombreBackup(String nombreBackup) {
        this.nombreBackup = nombreBackup;
    }

    public String getNombreBackup() {
        return nombreBackup;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setAuditorias(Map<Integer, Auditoria> auditorias) {
        this.auditorias = auditorias;
    }

    public Map<Integer, Auditoria> getAuditorias() {
        return auditorias;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmpleados(Map<String, Empleado> empleados) {
        this.empleados = empleados;
    }

    public Map<String, Empleado> getEmpleados() {
        return empleados;
    }

    public void setPersonas(Map<String, Persona> personas) {
        this.personas = personas;
    }

    public Map<String, Persona> getPersonas() {
        return personas;
    }

    public static void setPersistencia(Persistencia persistencia) {
        Empresa.persistencia = persistencia;
    }

    public static Persistencia getPersistencia() {
        return persistencia;
    }
    //------------------------getter setter---------------------

    public void setArticulos(Map<String, Articulo> articulos) {
        this.articulos = articulos;
    }

    public Map<String, Articulo> getArticulos() {
        return articulos;
    }

    public void setRoles(Map<Integer, Rol> roles) {
        this.roles = roles;
    }

    public Map<Integer, Rol> getRoles() {
        return roles;
    }

    public void setCategorias(Map<Integer, Categoria> categorias) {
        this.categorias = categorias;
    }

    public Map<Integer, Categoria> getCategorias() {
        return categorias;
    }

    public void setMarcas(Map<String, Marca> marcas) {
        this.marcas = marcas;
    }

    public Map<String, Marca> getMarcas() {
        return marcas;
    }

    public void setCompras(Map<Integer, Compra> compras) {
        this.compras = compras;
    }

    public Map<Integer, Compra> getCompras() {
        return compras;
    }

    public void setProveedores(Map<String, Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public Map<String, Proveedor> getProveedores() {
        return proveedores;
    }

    public void setCajas(Map<Integer, Caja> cajas) {
        this.cajas = cajas;
    }

    public Map<Integer, Caja> getCajas() {
        return cajas;
    }

    public void setTiposPagos(Map<Integer, TipoPago> tiposPagos) {
        this.tiposPagos = tiposPagos;
    }

    public Map<Integer, TipoPago> getTiposPagos() {
        return tiposPagos;
    }

    public void setVentas(Map<Integer, Venta> ventas) {
        this.ventas = ventas;
    }

    public Map<Integer, Venta> getVentas() {
        return ventas;
    }

    //------------------------Metodos---------------------

    // Empresa


    public void modificarEmpresa(String CUIL, String razonSocial, String direccion, String telefono, String email, String fotos) throws Exception {
        this.generarAuditoria("MODIFICAR", "EMPRESA", CUIL + "/ " + razonSocial + "/ " + direccion + "/ " + telefono + "/ " + email,
                              this.getCUIL() + "/ " + this.getRazonSocial() + "/ " + this.getDireccion() + "/ " + this.getTelefono() + "/ " + this.email + "/ " + this.email,
                              GuiIngresar.getUsuarioActual().getUsser().toString());
        this.CUIL = CUIL;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        if (fotos != null)
            this.foto = this.toArrayByte(fotos);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
    }

    //Compras
    public int agregarCompra(Proveedor unProveedor, Empleado unUsuario, double total, Calendar fechaHora) throws Exception {
        int dia = fechaHora.get(Calendar.DAY_OF_WEEK);
        int mes = fechaHora.get(Calendar.MONTH);
        int year = fechaHora.get(Calendar.YEAR);
        int hora = fechaHora.get(Calendar.HOUR_OF_DAY);
        int minutos = fechaHora.get(Calendar.MINUTE);
        String horaFinal = dia + "/ " + mes + "/ " + year + "/ " + " " + hora + ":" + minutos;
        this.generarAuditoria("ALTA", "COMPRA",
                              unProveedor.getRazonSocial() + "/ " + unUsuario.getApellido() + "/ " + unUsuario.getNombreEmpleado() + "/ " + String.valueOf(total) + "/ " +
                              horaFinal, "", GuiIngresar.getUsuario());
        Compra nuevaCompra = new Compra(unProveedor, unUsuario, total, fechaHora);
        int ret = nuevaCompra.getCodCompra();
        this.compras.put(nuevaCompra.getCodCompra(), nuevaCompra);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
        return ret;
    }

    public void modificarCompra(int codCompra, Calendar fecha, Proveedor unProveedor) throws Exception {
        if (this.compras.containsKey(codCompra)) {
            Compra unaCompra = (Compra) compras.get(codCompra);
            unaCompra.setFechaHora(fecha);
            unaCompra.setUnProveedor(unProveedor);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe la compra");
    }

    //detalleCompra
    /*public void agregarDetalleCompra(int codCompra, int codDetalleCompra, int codArticulo, double precio, int cantidad) throws Exception {
        if (!((this.compras.containsKey(codCompra)) && (this.articulos.containsKey(codArticulo)))) {
            Compra unaCompra = (Compra) compras.get(codCompra);
            Articulo unArticulo = (Articulo) articulos.get(codArticulo);
            unaCompra.agregarDetalleCompra(precio, codDetalleCompra, cantidad, unArticulo);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no se realizo la accion");
    }

    public void eliminarDetalleCompra(int codDetalleCompra, int codCompra) throws Exception {
        if (this.compras.containsKey(codCompra)) {
            Compra unaCompra = (Compra) compras.get(codCompra);
            unaCompra.eliminarDetalleCompra(codDetalleCompra);
            setChanged();
            notifyObservers();
        }
    }

    public void modificarDetalleCompra(int codCompra, double precio, int codDetalleCompra, int cantidad, int codArticulo) throws Exception {
        if ((this.compras.containsKey(codCompra)) && (this.articulos.containsKey(codArticulo))) {
            Compra unaCompra = (Compra) compras.get(codCompra);
            Articulo unArticulo = (Articulo) articulos.get(codArticulo);
            unaCompra.modificarDetalleCompra(precio, codDetalleCompra, cantidad, unArticulo);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no se realizo la accion");
    }
*/

    //proveedor
    public void agregarProveedor(String razonSocial, String CUITPro, String telPro, String domPro, double saldo) throws Exception {
        if (!this.proveedores.containsKey(CUITPro)) {
            this.generarAuditoria("ALTA", "PROVEEDOR", razonSocial + "/ " + CUITPro + "/ " + domPro + "/ " + String.valueOf(saldo), "", GuiIngresar.getUsuario());
            proveedores.put(CUITPro, new Proveedor(saldo, razonSocial, CUITPro, telPro, domPro));
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("Ya existe el CUIL ingresado");
        }
    }

    public void eliminarProveedor(String CUITPro) throws Exception {
        this.generarAuditoria("BAJA", "PROVEEDOR", razonSocial + "/ " + CUITPro, "", GuiIngresar.getUsuario());
        if (this.proveedores.containsKey(CUITPro)) {
            Proveedor unProveedor = (Proveedor) proveedores.get(CUITPro);
            this.proveedores.remove(unProveedor.getCUITPro());
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El Proveedor no Existe");
        }
    }

    public void modificarProveedor(String razonSocial, String CUITPro, String telPro, String domPro, double saldo) throws Exception {
        if (this.proveedores.containsKey(CUITPro)) {
            Proveedor unProveedor = (Proveedor) proveedores.get(CUITPro);
            this.generarAuditoria("MODIFICAR", "PROVEEDOR", razonSocial + "/ " + CUITPro + "/ " + domPro + "/ " + String.valueOf(saldo),
                                  unProveedor.getRazonSocial() + "/ " + unProveedor.getCUITPro() + "/ " + unProveedor.getDomPro() + "/ " + unProveedor.getSaldo(),
                                  GuiIngresar.getUsuario());
            unProveedor.setCUITPro(CUITPro);
            unProveedor.setDomPro(domPro);
            unProveedor.setRazonSocial(razonSocial);
            unProveedor.setSaldo(saldo);
            unProveedor.setTelPro(telPro);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("no se realizo la accion");
        }
    }

    //PagoCompra
    /* public void agregarPagoCompra(String CUITPro, int codPagoCompra, double monto, TipoPago unTipoPago) throws Exception {
        if (!(this.proveedores.containsKey(CUITPro))) {
            Proveedor unProveedor = (Proveedor) proveedores.get(CUITPro);
            unProveedor.agregarPagoCompra(codPagoCompra, monto, unTipoPago);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe movimiento");
    }

    public void modificarPagoCompra(int CUITPro, int codPagoCompra, double monto, String detalleMovimiento, Compra unacompra, Calendar fechaHora,
                                    TipoPago unTipoPago) throws Exception {
        if ((this.proveedores.containsKey(CUITPro))) {
            Proveedor unProveedor = (Proveedor) proveedores.get(CUITPro);
            unProveedor.modificarPagoCompra(codPagoCompra, monto, detalleMovimiento, unacompra, fechaHora, unTipoPago);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe movimiento");
    }*/

    //articulo
    public void agregarArticulo(String codBarra, String nombre, int stock, double precioVenta, String color2, String color, int talle, boolean enVidriera, Marca unaMarca,
                                Categoria unaCategoria, String sexo) throws Exception {
        if (!this.articulos.containsKey(codBarra)) {
            this.generarAuditoria("ALTA", "ARTICULO",
                                  codBarra + "/ " + nombre + "/ " + stock + "/ " + precioVenta + "/ " + color2 + "/ " + color + "/ " + talle + "/ " +
                                  unaMarca.getNombreMarca() + "/ " + unaCategoria.getNombre() + "/ " + sexo, "", GuiIngresar.getUsuario());
            this.articulos.put(codBarra, new Articulo(codBarra, nombre, stock, precioVenta, color2, color, talle, enVidriera, unaMarca, unaCategoria, sexo));
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El Articulo ya Existe");
        }
    }

    public void eliminarArticulo(String codBarra) throws Exception {
        //boolean retorno = false;
        if (this.articulos.containsKey(codBarra)) {
            this.generarAuditoria("BAJA", "ARTICULO", codBarra, "", GuiIngresar.getUsuario());
            Articulo unArticulo = (Articulo) articulos.get(codBarra);
            this.articulos.remove(unArticulo.getCodBarra());
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("El Articulo no Existe");
        }
        //return retorno;
    }

    public void modificarArticulo(String codBarra, String nombre, int stock, double precioVenta, String color2, String color, int talle, boolean enVidriera, Marca unaMarca,
                                  Categoria unaCategoria, String sexo) throws Exception {
        if (this.articulos.containsKey(codBarra)) {
            Articulo unArticulo = (Articulo) articulos.get(codBarra);
            this.generarAuditoria("MODIFICAR", "ARTICULO",
                                  codBarra + "/ " + nombre + "/ " + stock + "/ " + precioVenta + "/ " + color2 + "/ " + color + "/ " + talle + "/ " +
                                  unaMarca.getNombreMarca() + "/ " + unaCategoria.getNombre() + "/ " + sexo,
                                  unArticulo.getCodBarra() + "/ " + unArticulo.getNombre() + "/ " + unArticulo.getStock() + "/ " + unArticulo.getPrecioVenta() + "/ " +
                                  unArticulo.getColor2() + "/ " + unArticulo.getColor() + "/ " + unArticulo.getTalle() + "/ " + unArticulo.getUnaMarca().getNombreMarca() +
                                  "/ " + unArticulo.getUnaCategoria().getNombre() + "/ " + unArticulo.getSexo(), GuiIngresar.getUsuario());
            unArticulo.setNombre(nombre);
            unArticulo.setStock(stock);
            unArticulo.setColor(color);
            unArticulo.setColor(color2);
            unArticulo.setEnVidriera(enVidriera);
            unArticulo.setPrecioVenta(precioVenta);
            unArticulo.setTalle(talle);
            unArticulo.setUnaMarca(unaMarca);
            unArticulo.setUnaCategoria(unaCategoria);
            unArticulo.setSexo(sexo);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else
            throw new Exception("no existe el articulo");
    }

    //categoria
    public void agregarCategoria(String nombre, int codPadre, Boolean esPadre) throws Exception {
        if (!this.categorias.containsKey(nombre)) {
            this.generarAuditoria("ALTA", "CATEGORIA", nombre + "/ " + codPadre, "", GuiIngresar.getUsuario());
            Categoria nuevacategorias = new Categoria(nombre, codPadre, esPadre);
            this.categorias.put(nuevacategorias.getNroCateg(), nuevacategorias);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("la cateogria ya existe");
        }
    }


    public void eliminarCategoria(int nroCategoria) throws Exception {
        //boolean retorno = false;
        if (this.categorias.containsKey(nroCategoria)) {
            Categoria unaCategoria = (Categoria) categorias.get(nroCategoria);
            this.generarAuditoria("BAJA", "CATEGORIA", unaCategoria.getNombre(), "", GuiIngresar.getUsuario());
            this.categorias.remove(unaCategoria.getNroCateg());
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("El Proveedor no Existe");
        }
        //return retorno;
    }

    public void modificarCategoria(int nroCateg, String nombre, int codPadre) throws Exception {
        if (this.categorias.containsKey(nroCateg)) {
            Categoria unaCategoria = (Categoria) categorias.get(nroCateg);
            this.generarAuditoria("MODIFICAR", "CATEGORIA", nombre, unaCategoria.getNombre(), GuiIngresar.getUsuario());
            unaCategoria.setNombre(nombre);
            unaCategoria.setCodPadre(codPadre);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else
            throw new Exception("no existe la categoria");
    }

    //marca
    public void agregarMarca(String nombreMarca) throws Exception {
        this.generarAuditoria("ALTA", "MARCA", nombreMarca, "", GuiIngresar.getUsuario());
        Marca unaMarca = null;
        unaMarca = new Marca(nombreMarca);
        this.marcas.put(nombreMarca, unaMarca);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
    }

    public void eliminarMarca(String nombreMarca) throws Exception {
        //boolean retorno = false;
        if (this.marcas.containsKey(nombreMarca)) {
            this.generarAuditoria("BAJA", "MARCA", nombreMarca, "", GuiIngresar.getUsuario());
            this.marcas.remove(nombreMarca);
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("La marca no Existe");
        }
        //return retorno;
    }

    public void modificarMarca(String nombreMarcaViejo, String nombreMarcaNuevo) throws Exception {
        if (this.marcas.containsKey(nombreMarcaViejo)) {
            Marca unaMarca = (Marca) marcas.get(nombreMarcaViejo);
            this.generarAuditoria("MODIFICAR", "MARCA", nombreMarcaNuevo, nombreMarcaViejo, GuiIngresar.getUsuario());
            unaMarca.setNombreMarca(nombreMarcaNuevo);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe la marca");
    }

    //empleado
    public void agregarEmpleado(String nroDocEmpleado, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido, Calendar creadoDia, boolean estado,
                                int porcentaje) throws Exception {
        if (!this.empleados.containsKey(nroDocEmpleado)) {
            this.generarAuditoria("AGREGAR", "EMPLEADO", nroDocEmpleado + "/ " + nombreEmpleado + "/ " + apellido + "/ " + domEmpleado + "/ " + telEmpleado, "",
                                  GuiIngresar.getUsuario());
            //Calendar creadoDia, boolean estado, String nroDoc, String nombreEmpleado, String domEmpleado,String telEmpleado, String apellido
            this.empleados.put(nroDocEmpleado, new Empleado(nroDocEmpleado, nombreEmpleado, domEmpleado, telEmpleado, apellido, creadoDia, estado, porcentaje));
            this.empleados.get(nroDocEmpleado).setDesde(Calendar.getInstance());
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El Empleado ya Existe");
        }
    }

    public void agregarEmpleadoUsuario(String nroDocEmpleado, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido, String pasword,
                                       Calendar creadoDia, boolean estado, Rol rol, String usser, int porcentaje) throws Exception {
        if (!this.empleados.containsKey(nroDocEmpleado)) {
            this.generarAuditoria("AGREGAR", "USUARIO",
                                  nroDocEmpleado + "/ " + nombreEmpleado + "/ " + apellido + "/ " + domEmpleado + "/ " + telEmpleado + "/ " + usser + "/ " + pasword + "/ " +
                                  rol.getNombre(), "", GuiIngresar.getUsuario());
            this.empleados.put(nroDocEmpleado,
                               new Empleado(nroDocEmpleado, nombreEmpleado, domEmpleado, telEmpleado, apellido, pasword, creadoDia, estado, rol, usser, porcentaje));
            Empresa.persistencia.update(this);
            this.empleados.get(nroDocEmpleado).setDesde(Calendar.getInstance());
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El Empleado ya Existe");
        }
    }

    public void eliminarEmpleado(String nroDocEmpleado) throws Exception {
        //boolean retorno = false;
        if (this.empleados.containsKey(nroDocEmpleado)) {
            this.generarAuditoria("BAJA", "EMPLEADO", nroDocEmpleado, "", GuiIngresar.getUsuario());
            this.empleados.remove(nroDocEmpleado);
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("El cajero no Existe");
        }
        //return retorno;
    }

    public void modificarEmpleadoUsuario(String nroDocEmpleado, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido, String pasword,
                                         Calendar creadoDia, boolean estado, Rol rol, String usser) throws Exception {
        if (empleados.containsKey(nroDocEmpleado)) {
            Empleado unEmpleado = (Empleado) empleados.get(nroDocEmpleado);
            this.generarAuditoria("MODIFICAR", "USUARIO",
                                  nroDocEmpleado + "/ " + nombreEmpleado + "/ " + apellido + "/ " + domEmpleado + "/ " + telEmpleado + "/ " + usser + "/ " + pasword + "/ " +
                                  rol.getNombre(),
                                  unEmpleado.getNroDocEmppleado() + "/ " + unEmpleado.getNombreEmpleado() + "/ " + unEmpleado.getApellido() + "/ " +
                                  unEmpleado.getDomEmpleado() + "/ " + unEmpleado.getTelEmpleado() + "/ " + unEmpleado.getUsser() + "/ " + unEmpleado.getPasword(),
                                  GuiIngresar.getUsuario());
            unEmpleado.setApellido(apellido);
            unEmpleado.setNombreEmpleado(nombreEmpleado);
            unEmpleado.setTelEmpleado(telEmpleado);
            unEmpleado.setDomEmpleado(domEmpleado);
            unEmpleado.setCreadoDia(creadoDia);
            unEmpleado.setEstado(estado);
            unEmpleado.setPasword(pasword);
            unEmpleado.setUnRol(rol);
            unEmpleado.setUsser(usser);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El nro de Documento no existe");
        }
    }

    public void modificarEmpleado(String nroDocEmpleado, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido, Calendar creadoDia,
                                  boolean estado) throws Exception {
        if (empleados.containsKey(nroDocEmpleado)) {
            Empleado unEmpleado = (Empleado) empleados.get(nroDocEmpleado);
            this.generarAuditoria("MODIFICAR", "EMPLEADO", nroDocEmpleado + "/ " + nombreEmpleado + "/ " + apellido + "/ " + domEmpleado + "/ " + telEmpleado,
                                  unEmpleado.getNroDocEmppleado() + "/ " + unEmpleado.getNombreEmpleado() + "/ " + unEmpleado.getApellido() + "/ " +
                                  unEmpleado.getDomEmpleado() + "/ " + unEmpleado.getTelEmpleado(), GuiIngresar.getUsuario());
            unEmpleado.setApellido(apellido);
            unEmpleado.setNombreEmpleado(nombreEmpleado);
            unEmpleado.setTelEmpleado(telEmpleado);
            unEmpleado.setDomEmpleado(domEmpleado);
            unEmpleado.setCreadoDia(creadoDia);
            unEmpleado.setEstado(estado);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El nro de Documento no existe");
        }
    }

    public void modificarComision(String nroDocEmpleado, int comision) {
        Empleado unEmpleado = (Empleado) empleados.get(nroDocEmpleado);
        unEmpleado.setPorcentaje(comision);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();

    }

    public void modificarMontoComision(String nroDocEmpleado, double monto) {
        Empleado unEmpleado = (Empleado) empleados.get(nroDocEmpleado);
        unEmpleado.setMonto(monto);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
    }

    public void pagarComision(String nroDocEmpleado, double monto) {
        Empleado unEmpleado = (Empleado) empleados.get(nroDocEmpleado);
        unEmpleado.setMonto(monto);
        unEmpleado.setDesde(Calendar.getInstance());
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();

    }
    //caja

    public int agregarCaja(Calendar fecha, double saldoInicial, boolean cajaAbierta, Empleado unEmpleado) throws Exception {
        this.generarAuditoria("ALTA", "CAJA", saldoInicial + "/ " + unEmpleado.getUsser(), "", GuiIngresar.getUsuario());
        Caja unaCaja = new Caja(fecha, saldoInicial, cajaAbierta, unEmpleado);
        int re = unaCaja.getCodCaja();
        cajas.put(unaCaja.getCodCaja(), unaCaja);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
        return re;
    }

    public void cerrarCaja(Caja unaCaja) {
        unaCaja.setCajaAbierta(false);
        unaCaja.setUnEmpleadoCierre(GuiIngresar.getUsuarioActual());
        unaCaja.setCierreCaja(Calendar.getInstance());
        Empresa.persistencia.update(this);

    }
    //turno
    /* public void agregarTurno(int codCaja, int codTurno, Calendar fechaHora, double saldoInicial, double saldoFinal) throws Exception {
        if (!(this.cajas.containsKey(codCaja))) {
            Caja unaCaja = (Caja) cajas.get(codCaja);
            unaCaja.agregarTurno(codTurno, fechaHora, saldoInicial, saldoFinal);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe movimiento");
    }

    public void modificarTurno(int codCaja, int codTurno, Calendar fechaHora, double saldoInicial, double saldoFinal) throws Exception {
        if (!(this.cajas.containsKey(codCaja))) {
            Caja unaCaja = (Caja) cajas.get(codCaja);
            unaCaja.modificarTurno(codTurno, fechaHora, saldoInicial, saldoFinal);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe movimiento");
    }

    public void eliminarTurno(int codCaja, int codTurno) throws Exception {
        if (!(this.cajas.containsKey(codCaja))) {
            Caja unaCaja = (Caja) cajas.get(codCaja);
            unaCaja.eliminarTurno(codTurno);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe movimiento");
    }*/

    //tipoPago
    public void agregarTipoPago(String nombre, Boolean parametros[]) throws Exception {
        //if (!this.tiposPagos.containsKey(nombreViejo)) {
        this.generarAuditoria("ALTA", "TIPOPAGO", nombre, "", GuiIngresar.getUsuario());
        TipoPago nuevoTipoPago = new TipoPago(nombre, parametros);
        this.tiposPagos.put(nuevoTipoPago.getCodTipoPago(), nuevoTipoPago);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
        //} else {
        // throw new Exception("el tipo pago ya Existe");
        //}
    }

    public void eliminarTipoPago(String codTipoPago) throws Exception {
        //boolean retorno = false;
        if (this.tiposPagos.containsKey(codTipoPago)) {
            this.generarAuditoria("BAJA", "TIPOPAGO", codTipoPago, "", GuiIngresar.getUsuario());
            this.tiposPagos.remove(codTipoPago);
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("El tipo pago no Existe");
        }
        //return retorno;
    }

    public void modificarTipoPago(String nombreNuevo, String nombreViejo, Boolean parametros[]) throws Exception {
        if (this.tiposPagos.containsKey(nombreViejo)) {
            TipoPago unTipoPago = (TipoPago) tiposPagos.get(nombreViejo);
            this.generarAuditoria("MODIFICACION", "TIPOPAGO", nombreNuevo, nombreViejo, GuiIngresar.getUsuario());
            unTipoPago.setNombre(nombreNuevo);
            unTipoPago.setParametros(parametros);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe la Tipo Pago");
    }

    //venta

    public int agregarVenta(Empleado unEmpleado, Empleado unUsuario, double total, Calendar fechaVenta, String nombreCliente, String domicilioCliente,
                            String numeroDocCliente) throws Exception {
        // if (!this.categorias.containsKey(nombre)) {
        this.generarAuditoria("ALTA", "VENTA", unEmpleado.getApellido() + "/ " + unEmpleado.getNombreEmpleado() + "/ " + nombreCliente  + "/ " + total , "", GuiIngresar.getUsuario());
        Venta nuevaVenta = new Venta(unEmpleado, unUsuario, total, fechaVenta, nombreCliente, domicilioCliente, numeroDocCliente);
        int ret = nuevaVenta.getCodVenta();
        this.ventas.put(nuevaVenta.getCodVenta(), nuevaVenta);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
        return ret;
        //} else {
        //  throw new Exception("la Venta ya Existe");
        // }
    }

    public void eliminarVenta(int codVenta) throws Exception {
        //boolean retorno = false;
        if (this.ventas.containsKey(codVenta)) {
            this.ventas.remove(codVenta);
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("La Venta no Existe");
        }
        //return retorno;
    }

    public void modificarVenta(int codVenta, Empleado unEmpleado, double total, Calendar fechaVenta, String nombreCliente) throws Exception {
        if (this.ventas.containsKey(codVenta)) {
            Venta unaVenta = (Venta) ventas.get(codVenta);
            unaVenta.setCodVenta(codVenta);
            unaVenta.setFechaVenta(fechaVenta);
            unaVenta.setTotal(total);
            unaVenta.setUnEmpleado(unEmpleado);
            unaVenta.setNombreCliente(nombreCliente);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe la Venta");
    }
    //PagoVenta

    /*public void agregarPagoVenta(int codPagoVenta, TipoPago unTipoPago, double monto, int codVenta) throws Exception {
        if (!(this.ventas.containsKey(codVenta))) {
            Venta unaVenta = (Venta) ventas.get(codVenta);
            unaVenta.agregarPagoVenta(codPagoVenta, unTipoPago, monto);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe Pago Venta");
    }

    public void modificarPagoVenta(int codPagoVenta, TipoPago unTipoPago, double monto, int codVenta) throws Exception {
        if ((this.ventas.containsKey(codVenta))) {
            Venta unaVenta = (Venta) ventas.get(codVenta);
            unaVenta.modificarPagoVenta(codPagoVenta, unTipoPago, monto);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe Pago venta");
    }*/

    //detalleVenta
    /*public void agregarDetalleVenta(int codVenta, int cantidad, int codDetalleVenta, double precio, Articulo unArticulo) throws Exception {
        if (!(this.ventas.containsKey(codVenta))) {
            Venta unaVenta = (Venta) ventas.get(codVenta);
            unaVenta.agregarDetalleVenta(cantidad, codDetalleVenta, precio, unArticulo);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe detalle venta");
    }

    public void modificarDetalleVenta(int codVenta, int cantidad, int codDetalleVenta, double precio, Articulo unArticulo) throws Exception {
        if ((this.ventas.containsKey(codVenta))) {
            Venta unaVenta = (Venta) ventas.get(codVenta);
            unaVenta.modificarDetalleVenta(cantidad, codDetalleVenta, precio, unArticulo);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe detalle venta");
    }

    public void eliminarDetalleVenta(int codVenta, int codDetalleVenta) throws Exception {
        if ((this.ventas.containsKey(codVenta))) {
            Venta unaVenta = (Venta) ventas.get(codVenta);
            unaVenta.eliminarDetalleVenta(codDetalleVenta);
            setChanged();
            notifyObservers();
        }
        throw new Exception("no existe detalle venta");
    }*/

    //cirreCaja
    public void agregarCierreCaja(int codCaja, double saldoSistema, double saldoReal, TipoPago tipospago, String descripcion) throws Exception {
        Caja unaCaja = (Caja) cajas.get(codCaja);
        this.generarAuditoria("ALTA", "CIERRE_CAJA", codCaja + "/ " + saldoSistema + "/ " + saldoReal + "/ " + descripcion, "", GuiIngresar.getUsuario());
        unaCaja.agregarCierreCaja(saldoSistema, saldoReal, tipospago, descripcion);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
    }

    public void modificarCierreCaja(int codCaja, int codCierreCaja, double saldoSistema, double saldoReal, TipoPago tipospago, String descripcion) throws Exception {
        if (!(this.cajas.containsKey(codCaja))) {
            Caja unaCaja = (Caja) cajas.get(codCaja);
            unaCaja.modificarCierreCaja(codCierreCaja, saldoSistema, saldoReal, tipospago, descripcion);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe movimiento");
    }
    //movimiento Caja
    public void agregarMovimientoCaja(int codCaja, Venta unaVenta) throws Exception {
        if (!(this.cajas.containsKey(codCaja))) {
            Caja unaCaja = (Caja) cajas.get(codCaja);
            unaCaja.agregarMovimientoCaja(unaVenta);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        }
        throw new Exception("existe movimiento");
    }


    //usuario
    /*public void agregarUsuario(String nroDocEmppleado, String nombreEmpleado, String domEmpleado, String telEmpleado, String apellido, String pasword,Rol unRol, Calendar creadoDia, boolean estado, String usser) {
        Usu unUsuario;
        unUsuario = new Usu(nroDocEmppleado, nombreEmpleado, domEmpleado, telEmpleado, unRol, apellido, pasword, creadoDia, estado, usser);
        usuarios.put(nroDocEmppleado, unUsuario);
        Empresa.persistencia.insert(this);
        setChanged();
        notifyObservers();
    }

    public void eliminarUsuario(String id) throws Exception {
        //boolean retorno = false;
        if (this.usuarios.containsKey(id)) {
            this.usuarios.remove(id);
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("El Usuario no Existe");
        }
        //return retorno;
    }

    public void modificarUsuario(String nroDoc, String nombre, String tel, String apellido, int id, String telefono, String domicilio, String password, String usser, Calendar creadoDia, boolean estado,
                                 Rol unRol) throws Exception {
        if (usuarios.containsKey(id)) {
            Usu unUsuario = (Usu) usuarios.get(id);
            unUsuario.setCreadoDia(creadoDia);
            unUsuario.setEstado(estado);
            unUsuario.setPasword(password);
            unUsuario.setRol(unRol);
            unUsuario.setApellido(apellido);
            unUsuario.setDomEmpleado(domicilio);
            unUsuario.setNombreEmpleado(nombre);
            unUsuario.setNroDocEmppleado(nroDoc);
            unUsuario.setTelEmpleado(telefono);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El Usuario no existe");
        }
    }*/

    public boolean isEmptyUsuarios() {
        boolean hay = false;
        if (!this.getEmpleados().isEmpty()) {
            hay = true;

        }
        return hay;
    }

    public Empleado esUsuario(String usuario, String contrasenia) {
        Empleado retorno = null;
        Empleado aux = null;
        for (Object unUsuario : this.getEmpleados().values().toArray()) {
            aux = (Empleado) unUsuario;
            if (aux.getUsser() != null)
                if (aux.getUsser().toUpperCase().equals(usuario.toUpperCase()) && aux.getPasword().toUpperCase().equals((contrasenia.toUpperCase()))) {
                    retorno = aux;
                }
            String mensaje;
            //mensaje = ("MD5 = " + StringMD.getStringMessageDigest(contrasenia, StringMD.MD5));
        }
        return retorno;
    }

    public Empleado existeUsuario(String usuario, String contrasenia) {
        Empleado unUsu = null;
        for (Map.Entry enttr : getEmpleados().entrySet()) {
            Empleado unUsuario = (Empleado) enttr.getValue();
            if (unUsuario.getNombreEmpleado().toUpperCase().equals(usuario.toUpperCase())) {
                if (unUsuario.getPasword().toUpperCase().equals(contrasenia.toUpperCase())) {
                    unUsu = unUsuario;
                }
            } else {
            }
        }

        return unUsu;
    }

    public void agregarRol(String nombre, Boolean[] permiso, boolean estado) {
        Rol unRol;
        try {
            this.generarAuditoria("ALTA", "ROL", nombre, "", GuiIngresar.getUsuario());
        } catch (Exception e) {
        }
        unRol = new Rol(nombre, permiso, estado);
        roles.put(unRol.getIdRol(), unRol);
        Empresa.persistencia.update(this);
        setChanged();
        notifyObservers();
    }

    public void eliminarRol(int id) throws Exception {
        //boolean retorno = false;
        if (this.roles.containsKey(id)) {
            this.generarAuditoria("BAJA", "ROL", String.valueOf(id), "", GuiIngresar.getUsuario());
            this.roles.remove(id);
            setChanged();
            notifyObservers();
            //retorno = true;
        } else {
            throw new Exception("El Rol no Existe");
        }
        //return retorno;
    }

    public void modificarRol(int idRol, String nombre, Boolean[] permiso, boolean estado) throws Exception {
        if (roles.containsKey(idRol)) {
            Rol unRol = (Rol) roles.get(idRol);
            this.generarAuditoria("ALTA", "ROL", nombre, unRol.getNombre(), GuiIngresar.getUsuario());
            unRol.setEstado(estado);
            unRol.setIdRol(idRol);
            unRol.setNombre(nombre);
            unRol.setPermiso(permiso);
            Empresa.persistencia.update(this);
            setChanged();
            notifyObservers();
        } else {
            throw new Exception("El Rol no existe");
        }
    }

    public static byte[] toArrayByte(String url) {
        File file = new File(url);
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }

    public void generarAuditoria(String operacion, String tabla, String dato, String detalle, String usuario) throws Exception {
        Auditoria nuevaAuditoria = new Auditoria(operacion, tabla, dato, detalle, usuario);
        this.auditorias.put(nuevaAuditoria.getId(), nuevaAuditoria);
        Empresa.persistencia.update(this);
    }

    public void backup(String nombreBackup, String file, Calendar fecha, int dias) {
        this.setDias(dias);
        this.setFechaUltimo(fecha);
        this.setFile(file);
        this.setNombreBackup(nombreBackup);
    }

    public void realizarBackup() {
        if (!file.equals("")) {
            Calendar unDate = Calendar.getInstance();
            String fechaActual =
                String.valueOf(unDate.get(Calendar.DAY_OF_MONTH)) + "_" + String.valueOf(unDate.get(Calendar.MONTH) + 1) + "_" + String.valueOf(unDate.get(Calendar.YEAR));
            String horaActual = "_" + String.valueOf(unDate.get(Calendar.HOUR_OF_DAY)) + "_" + String.valueOf(unDate.get(Calendar.MINUTE));
            final String[] comandos = new String[15];
            comandos[0] = "C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dump.exe";
            comandos[1] = "-i";
            comandos[2] = "-h";
            comandos[3] = "localhost";
            comandos[4] = "-p";
            comandos[5] = "5432";
            comandos[6] = "-U";
            comandos[7] = "postgres";
            comandos[8] = "-F";
            comandos[9] = "c";
            comandos[10] = "-b";
            comandos[11] = "-v";
            comandos[12] = "-f";
            comandos[13] = this.file + "/(" + fechaActual + horaActual + ").backup";
            comandos[14] = "ZAPATERIA";
            ProcessBuilder pb = new ProcessBuilder(comandos);

            pb.environment().put("PGPASSWORD", "1234");

            try {
                final Process process = pb.start();
                try {
                    BufferedReader r = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                    String line = r.readLine();
                    while (line != null) {
                        System.err.println(line);
                        line = r.readLine();
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                process.waitFor();
                process.destroy();
                JOptionPane.showMessageDialog(null, "Backup completado.");
            } catch (IOException e) {
            } catch (InterruptedException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Directorio vacio.");
        }
        this.setFechaUltimo(Calendar.getInstance());
    }
}
    //busqeudas insertar





