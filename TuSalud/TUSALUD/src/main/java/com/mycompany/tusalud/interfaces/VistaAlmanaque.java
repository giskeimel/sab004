/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.AlmanaqueService;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author User
 */
public class VistaAlmanaque extends javax.swing.JFrame {
    
    private AlmanaqueService almanaque;
    private Map<String, Turno> tablaBotonTurno = new HashMap<String, Turno>();

    private ActionListener listenerBoton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           JButton boton = (JButton) ae.getSource();
           Turno turno = tablaBotonTurno.get(boton.toString());
            try {
               almanaque.guardarTurno(turno);
            } catch (BDException ex) {
              ex.printStackTrace();
            }
        }
    };
    
    public VistaAlmanaque(AlmanaqueService almanaque, List<Turno> lista) {
        this.almanaque = almanaque;
        initComponents();
        generarBotones(lista);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarBotones(List<Turno> lista){
        
        int xl = 10;
        int y = 10;
        int anchoBoton = 100;
        int anchoLabel = 100;
        int altoBoton = 20;
        int altoLabel = 20;
        
        for(Turno objetoT:lista) {

            JLabel horario = new JLabel("adsasdasd");
            horario.setBounds(xl , y, anchoLabel, altoLabel);
            
            JButton boton = new JButton("Tomar turno");
            boton.setBounds(xl + anchoLabel + 10, y, anchoBoton, altoBoton);
            boton.addActionListener(listenerBoton);
            tablaBotonTurno.put(boton.toString(), objetoT);
            this.add(boton);
            this.add(horario);            
            
            y = y + 50;
        }    
    }
    
    public void mostrar() {
        this.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
