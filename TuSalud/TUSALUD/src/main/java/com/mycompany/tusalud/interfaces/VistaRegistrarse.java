/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.interfaces;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Nati
 */
public class VistaRegistrarse {
    
    private JFrame ventana;
    
    public VistaRegistrarse() {
        initComponents();
    }
    
    public void mostrar() {
        ventana.setVisible(true);
    }

    private void initComponents() {
        ventana = new JFrame();
        
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ventana.setPreferredSize(new Dimension(800, 600));
        ventana.pack();
        //ventana.setLocationRelativeTo(parent);
        ventana.setResizable(false);
        ventana.setTitle("Nueva cuenta");
        ventana.setLayout(null);
        
        int xEtiqueta = 10;
        int xComponente = 60;
        int anchoEtiqueta = 50;
        int alto = 20;
        
        //////////////////////////////////////////Usuario//////////////////////////////////////////
        JLabel lblUsuario = new JLabel();
        lblUsuario.setBounds(xEtiqueta, 10, anchoEtiqueta, alto);
        lblUsuario.setText("Usuario");
        ventana.getContentPane().add(lblUsuario);
        
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(xComponente, 10, 100, alto);
        ventana.getContentPane().add(txtUsuario);
        //////////////////////////////////////////Usuario//////////////////////////////////////////
        
        //////////////////////////////////////////Contrasenia//////////////////////////////////////////
        JLabel lblContrasenia = new JLabel();
        lblContrasenia.setBounds(xEtiqueta, 40, anchoEtiqueta, alto);
        lblContrasenia.setText("Usuario");
        ventana.getContentPane().add(lblContrasenia);
        
        JTextField txtContrasenia = new JTextField();
        txtContrasenia.setBounds(xComponente, 10, 100, alto);
        ventana.getContentPane().add(txtContrasenia);
        //////////////////////////////////////////Contrasenia//////////////////////////////////////////
    }
    
    public void ocultar() {
        this.ventana.dispose();
    }
}
