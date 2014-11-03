
package Interfaz;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;

import org.jvnet.substance.plugin.SubstanceSkinPlugin;
import org.jvnet.substance.skin.SkinInfo;

import project1.Empleado;
import project1.Empresa;
import project1.Rol;

/**
 *
 * @author polaco
 */

public class GuiIngresar extends javax.swing.JFrame {
    Empresa unaEmpresa;
    private String usuario;
    private String contraseña;
    public static Empleado usuarioActual;
    private Empleado unUsuario;
    private Boolean[] permiso = new Boolean[9];

    /** Creates new form Ingresar */

    public GuiIngresar(Empresa unaEmpresa) {
        this.unaEmpresa = unaEmpresa;
        initComponents();
        long dias = ((Calendar.getInstance().getTimeInMillis()- unaEmpresa.getFechaUltimo().getTimeInMillis())/ (60 * 60 * 1000));
        if (dias > unaEmpresa.getDias()){
            unaEmpresa.realizarBackup();
        }
    }

    public static void setUsuarioActual(Empleado usuarioActual) {
        GuiIngresar.usuarioActual = usuarioActual;
    }

    public static Empleado getUsuarioActual() {
        return usuarioActual;
    }

    public static String getUsuario() {
        String usu = "system";
        if (usuarioActual != null)
            usu = usuarioActual.getUsser();
        return usu;
    }

    public static Boolean[] roles() {
        Rol unRoll = usuarioActual.getUnRol();
        Boolean[] permisoo = new Boolean[28];
        permisoo = unRoll.getPermiso();
        return permisoo;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblContraseña = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/iconoprograma.png")));

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1405280090_15_Tick_32x32.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1404956598_Delete.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblContraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1409707646_preferences-desktop-cryptography.png"))); // NOI18N
        lblContraseña.setText("Contraseña");

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1409707776_stock_person.png"))); // NOI18N
        lblUsuario.setText("Usuario");

        jTextField2.setNextFocusableComponent(jTextField1);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField1.setEchoChar('*');
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContraseña)
                            .addComponent(lblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Entrar();
    }//GEN-LAST:event_btnConfirmarActionPerformed
    
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            Entrar();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        if (jTextField2.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        if (jTextField1.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiIngresar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*  Empresa unaEmpresa= null;
                try {
                } catch (Exception ex) {
                    Logger.getLogger(GuiIngresar.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (Empresa.persistencia.restaurar("30-70848882-4") != null) {
                    laCautiva = Hotel.persistencia.restaurar("30-70848882-4");
                } else {
                    try {
                        Foto unLogo = new Foto("C:/Users/Facu/Desktop/Trabajo FinalAnalista/Proyecto_Nancy/Resguardo Original UltimoNan/src/Iconos/logo-encabezado.png");
                        Foto unLogo2 = new Foto("C:/Users/Facu/Desktop/Trabajo FinalAnalista/Proyecto_Nancy/Resguardo Original UltimoNan/src/Iconos/logo-encabezado2.jpg");
                        laCautiva = new Hotel("La Cautiva Lodge", "Zona de Granjas: Lote 128", "3757-412001", "LaCautivaLodged@gmail.com", "30-70848882-4", unLogo, unLogo2);
                        laCautiva.cargarDatos();
                    } catch (Exception ex) {
                        Logger.getLogger(ControlAcceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ControlAcceso unaVentana = null;
                try {
                    unaVentana = new ControlAcceso(laCautiva);
                } catch (Exception ex) {
                    Logger.getLogger(ControlAcceso.class.getName()).log(Level.SEVERE, null, ex);
                }
                unaVentana.show();
                unaVentana.setLocationRelativeTo(null);
            */
            }
        });

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPasswordField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
    public Empleado logeado() {
        usuarioActual = unUsuario;
        return unUsuario;
    }

    public void Entrar() {
        if (unaEmpresa.isEmptyUsuarios()) {
            usuario = jTextField2.getText();
            contraseña = jTextField1.getText();

            unUsuario = unaEmpresa.esUsuario(usuario, contraseña);
            if (unUsuario != null) {
                usuarioActual = logeado();
                Rol unRol = unUsuario.getUnRol();

                try {
                    GuiPrincipal unPrinc = new GuiPrincipal(unaEmpresa);
                    this.dispose();
                    permiso = unRol.getPermiso();

                    if (!permiso[0]) { //empleado
                        unPrinc.tbpPrincipal.remove(4);
                    }
                    if (!permiso[1]) { //seguridad
                        unPrinc.tbpPrincipal.remove(6);
                    }
                    if (!permiso[2]) { //venta
                        unPrinc.tbpPrincipal.remove(1);
                    }
                    if (!permiso[3]) { //articulo
                        unPrinc.tbpPrincipal.remove(2);
                    }
                    /* if (!permiso[4]){//auditoria
                        unPrinc.tbp.setEnabled(true);
                    }
                    if (!permiso[5]){//back up
                        unPrinc.tbp.setEnabled(true);
                    }*/
                    if (!permiso[6]) { //caja
                        unPrinc.tbpPrincipal.remove(5);
                    }
                    if (!permiso[7]) { //compra
                        unPrinc.tbpEntradas.setVisible(false);
                        unPrinc.btnFacturaCompras.setVisible(false);
                        unPrinc.tbpmodificar.remove(0);
                        unPrinc.tbpmodificar.setSelectedIndex(1);
                    }
                    if (!permiso[8]) { //proveedores
                        unPrinc.tbpProveedores.setVisible(false);
                        unPrinc.btnProveedores.setVisible(false);
                        unPrinc.tbpmodificar.remove(1);
                    }
                    /*if (!permiso[9]){//turnos
                        unPrinc.tbpCompra.setEnabled(true);*/
                    if ((!permiso[7]) && (!permiso[8])) {
                        unPrinc.tbpPrincipal.remove(0);
                        unPrinc.tbpPrincipal.setSelectedIndex(1);
                    }
                    unPrinc.setVisible(true);
                    unaEmpresa.generarAuditoria("loguear", "logueo", usuarioActual.getUsser(), "", usuarioActual.getUsser());
                } catch (Exception ex) {
                    Logger.getLogger(GuiIngresar.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre de Usuario o Contraseña no es Correcto");
                jTextField2.requestFocus();
                jTextField1.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningun usuario! Comuniquese con su Administrador de Sistema");
        }
    }

    private void setComponentsEnabled(java.awt.Container c, boolean en) {
        Component[] components = c.getComponents();
        for (Component comp : components) {
            if (comp instanceof java.awt.Container)
                setComponentsEnabled((java.awt.Container) comp, en);
            comp.setEnabled(en);
        }
    }

    /* @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/iconoprograma.png"));
        return retValue;
    }*/

}
