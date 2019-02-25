/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.MenuService;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class VistaMenu extends javax.swing.JFrame {

    MenuService menuService;

    /**
     * Creates new form Menu
     * @param menuService
     */
    public VistaMenu(MenuService menuService) {
        this.menuService = menuService;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanelInferior = new javax.swing.JPanel();
        jButtonCerrarSesion = new javax.swing.JButton();
        jPanelSuperior = new javax.swing.JPanel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jPanelMedio = new javax.swing.JPanel();
        jButtonSacarTurno = new javax.swing.JButton();
        jButtonNotificaciones = new javax.swing.JButton();
        jButtonTurnosAdquiridos = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(238, 112, 82));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelInferior.setBackground(new java.awt.Color(238, 112, 82));

        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jButtonCerrarSesion)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInferiorLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jButtonCerrarSesion)
                .addContainerGap())
        );

        getContentPane().add(jPanelInferior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 235, 550, -1));

        jPanelSuperior.setBackground(new java.awt.Color(238, 112, 82));

        jLabelNombreUsuario.setBackground(new java.awt.Color(255, 102, 0));
        jLabelNombreUsuario.setText("Usuario: " + getNombreDeUsuario());

        jLabelFecha.setText(getFechaDeHoy());

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabelNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(jLabelFecha)
                .addContainerGap())
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreUsuario)
                    .addComponent(jLabelFecha))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, -1));

        jPanelMedio.setBackground(new java.awt.Color(255, 255, 255));

        jButtonSacarTurno.setBackground(new java.awt.Color(238, 112, 82));
        jButtonSacarTurno.setText("Sacar Turno");
        jButtonSacarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacarTurnoActionPerformed(evt);
            }
        });

        jButtonNotificaciones.setBackground(new java.awt.Color(238, 112, 82));
        jButtonNotificaciones.setText("Notificaciones");
        jButtonNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNotificacionesActionPerformed(evt);
            }
        });

        jButtonTurnosAdquiridos.setBackground(new java.awt.Color(238, 112, 82));
        jButtonTurnosAdquiridos.setText("Turnos Adquiridos");
        jButtonTurnosAdquiridos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTurnosAdquiridosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMedioLayout = new javax.swing.GroupLayout(jPanelMedio);
        jPanelMedio.setLayout(jPanelMedioLayout);
        jPanelMedioLayout.setHorizontalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMedioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButtonSacarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButtonNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButtonTurnosAdquiridos)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanelMedioLayout.setVerticalGroup(
            jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMedioLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanelMedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSacarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTurnosAdquiridos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelMedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 550, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSacarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacarTurnoActionPerformed
        try {
            menuService.crearSeleccionEspecialidad();
        } catch (LoginException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonSacarTurnoActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        menuService.cerrarSesion();
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jButtonTurnosAdquiridosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTurnosAdquiridosActionPerformed
        // TODO add your handling code here:
        try {
            menuService.crearCancelarTurnos();
        } catch (BDException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonTurnosAdquiridosActionPerformed

    private void jButtonNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNotificacionesActionPerformed
        menuService.crearNotificaciones();
    }//GEN-LAST:event_jButtonNotificacionesActionPerformed

    public String getFechaDeHoy(){
        LocalDate fechaDeHoy = LocalDate.now();
        return fechaDeHoy.toString();
    }
    
    public String getNombreDeUsuario(){
        Paciente paciente = menuService.getUsuario();
        return paciente.getNombre() + " " + paciente.getApellido();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonNotificaciones;
    private javax.swing.JButton jButtonSacarTurno;
    private javax.swing.JButton jButtonTurnosAdquiridos;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelMedio;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
