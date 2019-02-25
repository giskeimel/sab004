/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.CancelarTurnosService;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class VistaCancelarTurnos extends javax.swing.JFrame {
    
    CancelarTurnosService cancelarTurnosService;
    private Map<Integer, Turno> tablaBotonTurno = new HashMap<>();
    List<Turno> lista;
    
    private ActionListener listenerBoton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Turno turno = tablaBotonTurno.get(jTable.getSelectedRow());
            try {
                if(turno != null){
                    cancelarTurnosService.cancelarTurno(turno);
                    cerrar();
                }
                else{
                    System.out.println("No ha seleccionado turno a cancelar");
                }
            } catch (BDException ex) {
                ex.printStackTrace();
            }
        }
    };
    
    public VistaCancelarTurnos(CancelarTurnosService cancelarTurnosService, List<Turno> lista) {
        this.cancelarTurnosService = cancelarTurnosService;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonVolverAMenu.setText("Volver a Menu");
        jButtonVolverAMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAMenuActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            getMatrizObject(getArregloString().length),
            getArregloString()
        ));
        jScrollPane1.setViewportView(jTable);

        jButtonCancelarTurno.setText("Cancelar Turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancelarTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVolverAMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelarTurno)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVolverAMenu))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverAMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAMenuActionPerformed
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jButtonVolverAMenuActionPerformed
    
    private Object[][] getMatrizObject(Integer tamaño){
        Object[][] matriz = new Object[lista.size()][tamaño];
        
        for(int fila=0; fila<lista.size(); fila++){
            
            matriz[fila][0] = lista.get(fila).getFecha().toLocalDateTime().toLocalDate();
            matriz[fila][1] = lista.get(fila).getHora();
            matriz[fila][2] = lista.get(fila).getEspecialidad().getNombre();
            
            tablaBotonTurno.put(fila, lista.get(fila));
        }
        
        jButtonCancelarTurno.addActionListener(listenerBoton);
        
        return matriz;
    }
    
    private String[] getArregloString(){
        String[] arreglo = {"Fecha", "Hora", "Especialidad"};
        
        return arreglo;
    }
    
    public void cerrar() {
        cancelarTurnosService.volverAMenu(this);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarTurno;
    private javax.swing.JButton jButtonVolverAMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
