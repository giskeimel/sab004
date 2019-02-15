/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.interfaces;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

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
        ventana.setPreferredSize(new Dimension(500, 500));
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setTitle("Nueva cuenta");
        ventana.setLayout(null);
        
        int xEtiqueta = 10;
        int xComponente = 110;
        int anchoEtiqueta = 110;
        int alto = 20;
        
        //////////////////////////////////////////Usuario//////////////////////////////////////////
        JLabel lblUsuario = new JLabel();
        lblUsuario.setBounds(xEtiqueta, 10, anchoEtiqueta, alto);
        lblUsuario.setText("Usuario");
        ventana.getContentPane().add(lblUsuario);
        
        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(xComponente, 10, anchoEtiqueta, alto);
        ventana.getContentPane().add(txtUsuario);
        //////////////////////////////////////////Usuario//////////////////////////////////////////
        
        //////////////////////////////////////////Contrasenia//////////////////////////////////////////
        JLabel lblContrasenia = new JLabel();
        lblContrasenia.setBounds(xEtiqueta, 40, anchoEtiqueta, alto);
        lblContrasenia.setText("Contraceña");
        ventana.getContentPane().add(lblContrasenia);
        
        JTextField txtContrasenia = new JTextField();
        txtContrasenia.setBounds(xComponente, 40, anchoEtiqueta, alto);
        ventana.getContentPane().add(txtContrasenia);
        //////////////////////////////////////////Contrasenia//////////////////////////////////////////
      
 
     //////////////////////////////////////////Nombre//////////////////////////////////////////
        JLabel lblNombre = new JLabel();
        lblNombre.setBounds(xEtiqueta, 70, anchoEtiqueta, alto);
        lblNombre.setText("Nombre");
        ventana.getContentPane().add(lblNombre);
        
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(xComponente, 70, anchoEtiqueta, alto);
        ventana.getContentPane().add(txtNombre);
        //////////////////////////////////////////Nombre//////////////////////////////////////////
 
    //////////////////////////////////////////Apellido//////////////////////////////////////////
        JLabel lblApellido = new JLabel();
        lblApellido.setBounds(xEtiqueta, 100, anchoEtiqueta, alto);
        lblApellido.setText("Apellido");
        ventana.getContentPane().add(lblApellido);
        
        JTextField txtApellido = new JTextField();
        txtApellido.setBounds(xComponente, 100, anchoEtiqueta, alto);
        ventana.getContentPane().add(txtApellido);
        //////////////////////////////////////////Apellido//////////////////////////////////////////
 
        /////////////////////////////////////////nroHistoria_Clinica//////////////////////////////////////////
        JLabel lblNroHClinica = new JLabel();
        lblNroHClinica.setBounds(xEtiqueta, 130, anchoEtiqueta, alto);
        lblNroHClinica.setText("Nro Hist. Clinica");
        ventana.getContentPane().add(lblNroHClinica);
        
        JTextField txtNroHClinica= new JTextField();
        txtNroHClinica.setBounds(xComponente, 130, anchoEtiqueta, alto);
        ventana.getContentPane().add(txtNroHClinica);
        //////////////////////////////////////////nroHistoria_Clinica//////////////////////////////////////////
       /////////////////botones registro y salida//////////////////////////////////////
         
         JButton btRegistrar = new JButton();
         btRegistrar.setText("Registrarse");
         btRegistrar.setBounds(xComponente, 190, anchoEtiqueta, alto);
         ventana.getContentPane().add(btRegistrar);
         
         JButton btvolver = new JButton();
         btvolver.setText("Volver");
         btvolver.setBounds(380, 430, anchoEtiqueta, alto);
         ventana.getContentPane().add(btvolver);
         
        JLabel lblMensaje = new JLabel();
        lblMensaje.setBounds(xEtiqueta,300, 570, alto);
        lblMensaje.setText("Dirijase al centro de salud mas cercano para verificar y completar datos");
        ventana.getContentPane().add(lblMensaje);
        
       /////////////////botones registro y salida//////////////////////////////////////

    }
    
    public void ocultar() {
        this.ventana.dispose();
    }
}
