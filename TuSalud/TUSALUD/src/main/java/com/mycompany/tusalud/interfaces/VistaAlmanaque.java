/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.AlmanaqueService;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class VistaAlmanaque extends javax.swing.JFrame {
    
    AlmanaqueService almanaqueService;
    private Map<Integer, Turno> tablaBotonTurno = new HashMap<>();
    
    private ActionListener listenerBoton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton boton = (JButton) ae.getSource();
            Turno turno = (Turno) tablaBotonTurno.get(boton.hashCode());
            try {
                almanaqueService.guardarTurno(turno);
                cerrar();
            } catch (BDException ex) {
                ex.printStackTrace();
            }
        }
    };
    
    public VistaAlmanaque(AlmanaqueService almanaqueService, List<Turno> lista) {
        this.almanaqueService = almanaqueService;
        initComponents();
        generarBotones(lista);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jButtonCancelar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jButtonCancelar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void generarBotones(List<Turno> lista){
        
        int xl = 10;
        int y = 10;
        int anchoBoton = 110;
        int anchoLabel = 200;
        int altoBoton = 20;
        int altoLabel = 20;
        
        for(Turno objetoT: lista) {

            JLabel horario = new JLabel(objetoT.toString());
            horario.setBounds(xl , y, anchoLabel, altoLabel);
            
            JButton boton = new JButton("Tomar turno");
            boton.setBounds(xl + anchoLabel + 10, y, anchoBoton, altoBoton);
            tablaBotonTurno.put(boton.hashCode(), objetoT);
            boton.addActionListener(listenerBoton);
            this.add(boton);
            this.add(horario);            
            
            y = y + 50;
        }    
        System.out.println(tablaBotonTurno);
    }
    
    public void cerrar() {
        almanaqueService.volverAMenu(this);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    // End of variables declaration//GEN-END:variables
}
