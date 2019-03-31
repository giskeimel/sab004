/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.CancelarTurnoController;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class VistaCancelarTurno extends javax.swing.JFrame {
    
    CancelarTurnoController cancelarTurnosController;
    private Map<Integer, Turno> tablaBotonTurno = new HashMap<>();
    List<Turno> lista;
    
    private ActionListener listenerBoton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Turno turno = tablaBotonTurno.get(jTable.getSelectedRow());
            try {
                if(turno != null){
                    cancelarTurnosController.cancelarTurno(turno, estaVentana());
                }
                else{
                    System.out.println("No ha seleccionado turno a cancelar");
                }
            } catch (BDException ex) {
                ex.printStackTrace();
            }
        }
    };
    
    public VistaCancelarTurno(CancelarTurnoController cancelarTurnosController, List<Turno> lista) {
        this.cancelarTurnosController = cancelarTurnosController;
        this.lista = lista;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonVolverAMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonCancelarTurno = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonVolverAMenu.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVolverAMenu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonVolverAMenu.setText("Volver a Menu");
        jButtonVolverAMenu.setBorder(null);
        jButtonVolverAMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVolverAMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 160, 30));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            getMatrizObject(getArregloString().length),
            getArregloString()
        ));
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 520, 460));

        jButtonCancelarTurno.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelarTurno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCancelarTurno.setText("Cancelar Turno");
        jButtonCancelarTurno.setBorder(null);
        jButtonCancelarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 160, 40));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesL2/FondoListas.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAMenuActionPerformed
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jButtonVolverAMenuActionPerformed

    private void jButtonCancelarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarTurnoActionPerformed
    
 

    private Object[][] getMatrizObject(Integer tamaño){
        Object[][] matriz = new Object[lista.size()][tamaño];
        
        for(int fila=0; fila<lista.size(); fila++){
            
            matriz[fila][0] = lista.get(fila).getFecha();
            matriz[fila][1] = lista.get(fila).getHora().toLocalTime();
            matriz[fila][2] = lista.get(fila).getEspecialidad().getNombre();
            if (lista.get(fila).getProfesional() != null){
                matriz[fila][3] = lista.get(fila).getProfesional().getNombre() + " " + lista.get(fila).getProfesional().getApellido();
            }
            
            tablaBotonTurno.put(fila, lista.get(fila));
        }
        
        jButtonCancelarTurno.addActionListener(listenerBoton);
        
        return matriz;
    }
    
    private String[] getArregloString(){
        String[] arreglo = {"Fecha", "Hora", "Especialidad", "Profesional"};
        
        return arreglo;
    }
    
    public JFrame estaVentana(){
        return this;
    }
    
    public void cerrar() {
        cancelarTurnosController.volverAMenu(this);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jButtonCancelarTurno;
    private javax.swing.JButton jButtonVolverAMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
