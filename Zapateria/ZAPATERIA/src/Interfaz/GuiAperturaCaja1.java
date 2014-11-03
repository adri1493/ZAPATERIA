
package Interfaz;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import java.util.Calendar;

import javax.swing.JOptionPane;

import project1.Empresa;

/**
 *
 * @author polaco
 */
public class GuiAperturaCaja1 extends javax.swing.JFrame {
    Empresa unaEmpresa;
    int codCaja;

    /** Creates new form AperturaCaja */
    public GuiAperturaCaja1() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        gradientPreviewPanel1 = new org.jdesktop.swingx.color.GradientPreviewPanel();
        jXColorSelectionButton1 = new org.jdesktop.swingx.JXColorSelectionButton();
        jXComboBox1 = new org.jdesktop.swingx.JXComboBox();
        jPanel1 = new javax.swing.JPanel();
        lblfecha = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSaldo = new javax.swing.JTextPane();
        lblFecha = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        gradientThumbRenderer1 = new org.jdesktop.swingx.color.GradientThumbRenderer();
        jXComboBox2 = new org.jdesktop.swingx.JXComboBox();
        jXColorSelectionButton2 = new org.jdesktop.swingx.JXColorSelectionButton();

        javax.swing.GroupLayout gradientPreviewPanel1Layout = new javax.swing.GroupLayout(gradientPreviewPanel1);
        gradientPreviewPanel1.setLayout(gradientPreviewPanel1Layout);
        gradientPreviewPanel1Layout.setHorizontalGroup(
            gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        gradientPreviewPanel1Layout.setVerticalGroup(
            gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jXColorSelectionButton1.setText("jXColorSelectionButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apertura Caja");
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/iconoprograma.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblfecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1405279692_678120-calendar-clock.png"))); // NOI18N
        lblfecha.setText("Fecha");

        lblusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1409707776_stock_person.png"))); // NOI18N
        lblusuario.setText("Usuario");

        lblSaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1405279775_Money_bag.png"))); // NOI18N
        lblSaldo.setText("Saldo Inicial:");

        txtSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtSaldo);

        lblFecha.setText("jLabel1");

        lblUsuario.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblusuario)
                            .addComponent(lblfecha))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblfecha)
                    .addComponent(lblFecha))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusuario)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

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
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        jXColorSelectionButton2.setText("jXColorSelectionButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addGap(60, 60, 60)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jXColorSelectionButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(gradientThumbRenderer1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(jXComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jXComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(gradientThumbRenderer1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jXColorSelectionButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) { //GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    } //GEN-LAST:event_btnCancelarMouseClicked

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_btnConfirmarActionPerformed

        try {

            Calendar cal1 = Calendar.getInstance();
            if (Double.parseDouble(txtSaldo.getText()) <= 0) {
                JOptionPane.showMessageDialog(null, "El Saldo de Apertura es menor o igual cero.");
                txtSaldo.requestFocus();
            } else {
                codCaja = unaEmpresa.agregarCaja(cal1, Double.parseDouble(txtSaldo.getText()), true, GuiIngresar.getUsuarioActual());
                JOptionPane.showMessageDialog(null, "Caja abierta.");
            }

            this.dispose();
        } catch (Exception ex) {
        }

    } //GEN-LAST:event_btnConfirmarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) { //GEN-FIRST:event_formWindowActivated
        Calendar cal1 = Calendar.getInstance();

        String horaApertura;
       horaApertura =
            ("" + cal1.get(Calendar.DATE) + "/" + cal1.get(Calendar.MONTH) + "/" + cal1.get(Calendar.YEAR) + " " + cal1.get(Calendar.HOUR) + ":" + cal1.get(Calendar.MINUTE));
        lblFecha.setText(horaApertura);
    } //GEN-LAST:event_formWindowActivated

    private void txtSaldoKeyTyped(java.awt.event.KeyEvent evt) { //GEN-FIRST:event_txtSaldoKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
            evt.consume();
        }
        if (c == '.' && txtSaldo.getText().contains(".")) {
            evt.consume();
        }
    } //GEN-LAST:event_txtSaldoKeyTyped

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
            java.util.logging.Logger.getLogger(GuiAperturaCaja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiAperturaCaja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiAperturaCaja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiAperturaCaja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiAperturaCaja1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private org.jdesktop.swingx.color.GradientPreviewPanel gradientPreviewPanel1;
    private org.jdesktop.swingx.color.GradientThumbRenderer gradientThumbRenderer1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXColorSelectionButton jXColorSelectionButton1;
    private org.jdesktop.swingx.JXColorSelectionButton jXColorSelectionButton2;
    private org.jdesktop.swingx.JXComboBox jXComboBox1;
    private org.jdesktop.swingx.JXComboBox jXComboBox2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JTextPane txtSaldo;
    // End of variables declaration//GEN-END:variables

}