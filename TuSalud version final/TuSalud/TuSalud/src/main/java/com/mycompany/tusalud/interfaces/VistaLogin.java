
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.LoginController;
import com.mycompany.tusalud.excepciones.LoginException;
import javax.swing.JOptionPane;


public class VistaLogin extends javax.swing.JFrame {
    
    LoginController loginController;
    
    public VistaLogin(LoginController loginController) {
        this.loginController = loginController;
        initComponents();
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        IniciarSesión = new javax.swing.JButton();
        Regístrate = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Usuario = new javax.swing.JTextField();
        Contraseña = new javax.swing.JPasswordField();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IniciarSesión.setBackground(new java.awt.Color(255, 255, 255));
        IniciarSesión.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        IniciarSesión.setText("Iniciar Sesión");
        IniciarSesión.setBorder(null);
        IniciarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesiónActionPerformed(evt);
            }
        });
        jPanel1.add(IniciarSesión, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 200, 60));

        Regístrate.setBackground(new java.awt.Color(36, 47, 70));
        Regístrate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Regístrate.setForeground(new java.awt.Color(92, 212, 195));
        Regístrate.setText("Regístrate");
        Regístrate.setBorder(null);
        Regístrate.setBorderPainted(false);
        Regístrate.setContentAreaFilled(false);
        Regístrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegístrateActionPerformed(evt);
            }
        });
        jPanel1.add(Regístrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 715, 110, 20));

        Salir.setBackground(new java.awt.Color(36, 47, 70));
        Salir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("X");
        Salir.setBorder(null);
        Salir.setBorderPainted(false);
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(943, 10, 50, 40));

        Usuario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Usuario.setForeground(new java.awt.Color(36, 46, 71));
        Usuario.setBorder(null);
        Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel1.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 400, 40));

        Contraseña.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Contraseña.setForeground(new java.awt.Color(36, 46, 71));
        Contraseña.setBorder(null);
        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 400, 40));

        Fondo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesL2/fondo.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 750));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void IniciarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesiónActionPerformed
                String usuario = Usuario.getText();
        String password = new String(Contraseña.getPassword());
       
        try {
            loginController.login(usuario, password);
        } catch (LoginException ex) {
             JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_IniciarSesiónActionPerformed

    private void RegístrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegístrateActionPerformed
       loginController.registrarCuenta(this);
    }//GEN-LAST:event_RegístrateActionPerformed

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton IniciarSesión;
    private javax.swing.JButton Regístrate;
    private javax.swing.JButton Salir;
    private javax.swing.JTextField Usuario;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
