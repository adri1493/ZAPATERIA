
package Interfaz;

import java.awt.Toolkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import project1.Backup;
import project1.Empresa;
import project1.Persistencia;

public class GuiBackups extends javax.swing.JFrame {
    public Empresa unaEmpresa;
    String direccion;
    String direccion2;

    public GuiBackups(Empresa unaEmpresa) {
        this.unaEmpresa = unaEmpresa;
        initComponents();
        reloj();
        lblUsuarioActual1.setText(GuiIngresar.getUsuario());
        txtField.setText(unaEmpresa.getFile());
        spnDias.setValue(unaEmpresa.getDias());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblUsuarioActual1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardarNueMarca = new javax.swing.JButton();
        btnCancelarMarca = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtField = new javax.swing.JTextField();
        btnRuta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnDias = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Back Up");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/iconoprograma.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/backup.png"))); // NOI18N
        jLabel1.setText("Gestion de Copias de Seguridad");

        btnIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1412329636_button_16.png"))); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1412371184_519668-173_CurvedArrowLeftUp-24.png"))); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel13.setText("Usuario: ");

        lblUsuarioActual1.setText("label");

        jLabel14.setText("fecha:");

        lblFecha.setText("Usuario: ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarioActual1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addGap(82, 82, 82))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14)
                .addComponent(lblFecha)
                .addComponent(jLabel13)
                .addComponent(lblUsuarioActual1))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnGuardarNueMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1404955973_Save.png"))); // NOI18N
        btnGuardarNueMarca.setText("Guardar");
        btnGuardarNueMarca.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardarNueMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarNueMarcaActionPerformed(evt);
            }
        });

        btnCancelarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1404956598_Delete.png"))); // NOI18N
        btnCancelarMarca.setText("Cancelar");
        btnCancelarMarca.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardarNueMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarMarca)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarNueMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnCancelarMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos para el guardado automatico"));

        jLabel2.setText("Ruta donde se guardaran los backups");

        txtField.setEditable(false);

        btnRuta.setText("....");
        btnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaActionPerformed(evt);
            }
        });

        jLabel3.setText("Cada cuantos dias desea realizar backup");

        jLabel4.setText("Dias");

        spnDias.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        spnDias.setValue(1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnDias, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(159, 159, 159))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 235, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRuta))
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spnDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestaurar)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnRestaurar))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) { //GEN-FIRST:event_formWindowActivated

    } //GEN-LAST:event_formWindowActivated

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnIniciarActionPerformed
        unaEmpresa.realizarBackup();
    } //GEN-LAST:event_btnIniciarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnRestaurarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de Restauración", "backup"));
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            direccion2 = fileChooser.getSelectedFile().getAbsolutePath();
        }
        /* try {
            List<String> commd = new ArrayList<String>();
            ProcessBuilder pbuilder;
            //Realiza la construccion del comando
            pbuilder = new ProcessBuilder("pg_restore", "-i", "-h", "localhost", "-p", "5432", "-U", "postgres", "-d", "ZAPATERIA", "-v", direccion2);
            //Se ingresa el valor del password a la variable de entorno de postgres
            pbuilder.environment().put("PGPASSWORD", "1234");
            pbuilder.environment().put("PGHOME", "C:\\Program Files\\PostgreSQL\\9.3");
            pbuilder.redirectErrorStream(true);
            pbuilder.environment().put("PGHOST", "localhost");
            //Ejecuta el proceso
            pbuilder.start();
            commd.add("C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_restore.exe");
            commd.add("-i");
            commd.add("-h");
            commd.add("localhost");
            commd.add("-p");
            commd.add("5432");
            commd.add("-U");
            commd.add("postgres");
            commd.add("-F");
            commd.add("c");
            commd.add("-b");
            commd.add("-v");
            commd.add("-f");
            commd.add("\"C:\\Users\\Adrian\\Desktop\\(20_10_2014_13_32).backup\"");
            commd.add("ZAPATERIA");
            ProcessBuilder PrcBld = new ProcessBuilder(commd);
            Map<String, String> Envm = PrcBld.environment();
            Envm.put("PGPASSWORD", "1234");
            Process process = PrcBld.start();
            elimnarBD();
        } catch (Exception e) {
            e.printStackTrace()
        };*/
        Empresa.persistencia.eliminar();

    } //GEN-LAST:event_btnRestaurarActionPerformed

    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Directorio");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            direccion = chooser.getSelectedFile().toString();
            txtField.setText(direccion);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Directorio para guardar la copia de Respaldo.");
        }
    }//GEN-LAST:event_btnRutaActionPerformed

    private void btnGuardarNueMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarNueMarcaActionPerformed
        unaEmpresa.backup("",direccion, Calendar.getInstance(), Integer.parseInt(spnDias.getValue().toString()));
    }//GEN-LAST:event_btnGuardarNueMarcaActionPerformed

    private void btnCancelarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMarcaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarMarcaActionPerformed

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
            java.util.logging.Logger.getLogger(GuiBackups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiBackups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiBackups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiBackups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GuiEmpleado(unaEmpresa).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarMarca;
    private javax.swing.JButton btnGuardarNueMarca;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnRuta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUsuarioActual1;
    private javax.swing.JSpinner spnDias;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables

    public void elimnarBD() {
        try {
            List<String> commd = new ArrayList<String>();
            commd.add("C:\\Program Files\\PostgreSQL\\9.3\\bin\\dropdb.exe");
            commd.add("ZAPATERIA");
            ProcessBuilder PrcBld = new ProcessBuilder(commd);
            Map<String, String> Envm = PrcBld.environment();
            Envm.put("PGPASSWORD", "1234");
            Process process = PrcBld.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void crearBD() {

    }

    private void reloj() {
        javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                lblFecha.setText(Calendar.getInstance().getTime().toLocaleString());
            }
        });
        timer.start();
    }
}
