package project1;

import Interfaz.GuiIngresar;

import groovyjarjarcommonscli.*;

import java.util.Calendar;

import java.util.GregorianCalendar;

import javax.swing.*;

import org.jvnet.substance.SubstanceLookAndFeel;

public class Principal {

    public static void main(String[] args) throws ParseException, Exception {
        Boolean[] permiso = new Boolean[10];
        Boolean[] parametros = new Boolean[8];
        for (int i = 0; i <= 9; i++)
            permiso[i] = true;
        for (int i = 0; i <= 5; i++)
            parametros[i] = false;
        Calendar fechaActual = new GregorianCalendar();
        Empresa unaEmpresa = null;
        //unaEmpresa = new Empresa();
        unaEmpresa = Empresa.getPersistencia().load("1");
        if (unaEmpresa == null) {
            unaEmpresa = new Empresa("1", "empresa1", "asdfgh", "123456", "sdfasdf@gmail.com");
        }
        if (unaEmpresa.getEmpleados().isEmpty()) {
            unaEmpresa.agregarRol("Administrador", permiso, true);
            unaEmpresa.backup("Zapatillasoft", "", Calendar.getInstance(), 1000);
            Rol unRol = (Rol) unaEmpresa.getRoles().get(1);
            unaEmpresa.agregarEmpleadoUsuario("2", "Sabrina", "lasHeras", "37430800", "Perez", "admin", fechaActual, true, unRol, "admin", 0);
            unaEmpresa.agregarTipoPago("Efectivo", parametros);
            unaEmpresa.agregarTipoPago("Cuenta Corriente", parametros);
            unaEmpresa.agregarCategoria("Zapatilla", -1, true);
        }
        GuiIngresar.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin");
        //SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceAquaTheme");
        JFrame Usuario = new GuiIngresar(unaEmpresa);
        Usuario.setVisible(true);
    }
}


