/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.AlmanaqueController;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class VistaAlmanaqueP extends javax.swing.JFrame {
    
    AlmanaqueController almanaqueController;
    private Map<Double, Turno> tablaBotonTurno = new HashMap<>();
    List<Turno> lista;
    
    private ActionListener listenerBoton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            Turno turno = (Turno) tablaBotonTurno.get(new Double(jTable.getSelectedRow()+"."+jTable.getSelectedColumn()));
            try {
                if(turno != null){
                    almanaqueController.guardarTurno(turno);
                    cerrar();
                }
                else{
                    System.out.println("No se ha seleccionado turno");
                }
            } catch (BDException ex) {
                ex.printStackTrace();
            }
        }
    };
    
    public VistaAlmanaqueP(AlmanaqueController almanaqueController, List<Turno> lista) {
        this.almanaqueController = almanaqueController;
        this.lista = lista;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonTomarTurno = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonTomarTurno.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTomarTurno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonTomarTurno.setText("Tomar turno");
        jButtonTomarTurno.setBorder(null);
        jButtonTomarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTomarTurnoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTomarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 130, 50));

        jButtonCancelar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorder(null);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 130, 50));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            getMatrizObject(getArregloLocalDate()),
            getArregloLocalDate()
        ));
        jScrollPane2.setViewportView(jTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 520, 460));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesL2/FondoListas.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonTomarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTomarTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTomarTurnoActionPerformed

    private Object[][] getMatrizObject(LocalDate[] arreglo){
        Object[][] matriz = new Object[20][arreglo.length];
        int fila = 0;
        
        for(int columna=0; columna<arreglo.length; columna++){
            
            for(int indice=0; indice<lista.size(); indice++){
                
                if(lista.get(indice).getFecha().compareTo((java.sql.Date.valueOf(arreglo[columna]))) == 0){

                    matriz[fila][columna] = lista.get(indice).getHora().toLocalTime();
                    tablaBotonTurno.put(new Double(fila+"."+columna),lista.get(indice));
                    
                    fila = fila + 1;
                }
            }
            fila = 0;
        }
        
        jButtonTomarTurno.addActionListener(listenerBoton);
        
        System.out.println(tablaBotonTurno);
        
        return matriz;
    }
    
    private LocalDate[] getArregloLocalDate(){
        LocalDate fecha = LocalDate.now();
        
        LocalDate[] arreglo = new LocalDate[5] ;
        
        for (int i=0;i<5;i++){
           arreglo[i] = fecha.plusDays(i);
        }
        return arreglo;
    }
    
    public void cerrar() {
        almanaqueController.volverAMenu(this);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonTomarTurno;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
