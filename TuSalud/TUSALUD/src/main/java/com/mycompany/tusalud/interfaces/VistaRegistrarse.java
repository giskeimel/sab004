/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.controller.AgregarCuentaService;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.db.ConsultaLugar;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.TuSaludException;
import java.awt.Dimension;
import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author Nati
 */
public class VistaRegistrarse {

    private AgregarCuentaService cuentaNueva;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField textContraceña;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField txtNroHClinica;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textnumero;
    private javax.swing.JTextField  textPiso;
    private javax.swing.JTextField textDepto;
    private JDialog ventana;
    private Window ventanaAnterior;
    private ConsultaLugar consulta = new ConsultaLugar();
    private List<Lugar> lista;
    private JComboBox jcLugares;

    public VistaRegistrarse(AgregarCuentaService cuentaNueva, Window ventanaAnterior) {
        
            this.cuentaNueva = cuentaNueva;
            this.ventanaAnterior = ventanaAnterior;            
            this.lista = consulta.getListaDeLugares();
            initComponents();
        
    }

    public void mostrar() {
        ventana.setVisible(true);
    }
 
    public void ocultar() {
        ventana.setVisible(false);
        ventana.dispose();
    }

    private void initComponents() {
          if (ventanaAnterior != null) {
              if (ventanaAnterior instanceof JDialog) {
                ventana = new JDialog((JDialog)ventanaAnterior, true);
            }   else {
                ventana = new JDialog((JFrame)ventanaAnterior, true);
            }            
        } else {
            ventana = new JDialog();
        }
                
        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        txtUsuario = new JTextField();
        txtUsuario.setBounds(xComponente, 10, anchoEtiqueta, alto);
        ventana.getContentPane().add(txtUsuario);
        //////////////////////////////////////////Usuario//////////////////////////////////////////

        //////////////////////////////////////////Contrasenia//////////////////////////////////////////
        JLabel lblContrasenia = new JLabel();
        lblContrasenia.setBounds(xEtiqueta, 40, anchoEtiqueta, alto);
        lblContrasenia.setText("Contraseña");
        ventana.getContentPane().add(lblContrasenia);

        textContraceña = new JTextField();
        textContraceña.setBounds(xComponente, 40, anchoEtiqueta, alto);
        ventana.getContentPane().add(textContraceña);
        //////////////////////////////////////////Contrasenia//////////////////////////////////////////

        //////////////////////////////////////////Nombre//////////////////////////////////////////        
        JLabel lblNombre = new JLabel();
        lblNombre.setBounds(xEtiqueta, 70, anchoEtiqueta, alto);
        lblNombre.setText("Nombre");
        ventana.getContentPane().add(lblNombre);

        textNombre = new JTextField();
        textNombre.setBounds(xComponente, 70, anchoEtiqueta, alto);
        ventana.getContentPane().add(textNombre);
        //////////////////////////////////////////Nombre//////////////////////////////////////////

        //////////////////////////////////////////Apellido//////////////////////////////////////////
        JLabel lblApellido = new JLabel();
        lblApellido.setBounds(xEtiqueta, 100, anchoEtiqueta, alto);
        lblApellido.setText("Apellido");
        ventana.getContentPane().add(lblApellido);

        textApellido = new JTextField();
        textApellido.setBounds(xComponente, 100, anchoEtiqueta, alto);
        ventana.getContentPane().add(textApellido);
        //////////////////////////////////////////Apellido//////////////////////////////////////////

     
        /////////////////////////////////////////nroHistoria_Clinica//////////////////////////////////////////
        JLabel lblNroHClinica = new JLabel();
        lblNroHClinica.setBounds(xEtiqueta, 130, anchoEtiqueta, alto);
        lblNroHClinica.setText("Nro Hist. Clinica");
        ventana.getContentPane().add(lblNroHClinica);

        txtNroHClinica = new JTextField();
        txtNroHClinica.setBounds(xComponente, 130, anchoEtiqueta, alto);
        ventana.getContentPane().add(txtNroHClinica);
        //////////////////////////////////////////nroHistoria_Clinica//////////////////////////////////////////
        //////////////////////////////////////////email//////////////////////////////////////////
        JLabel lblEmail = new JLabel();
        lblEmail.setBounds(xEtiqueta, 160, anchoEtiqueta, alto);
        lblEmail.setText(" Email");
        ventana.getContentPane().add(lblEmail);

        textEmail = new JTextField();
        textEmail.setBounds(xComponente, 160, anchoEtiqueta, alto);
        ventana.getContentPane().add(textEmail);
        //////////////////////////////////////////Email//////////////////////////////////////////
        //////////////////////////////////////////Direccion//////////////////////////////////////////
        JLabel lblDireccion = new JLabel();
        lblDireccion.setBounds(xEtiqueta, 210, anchoEtiqueta, alto);
        lblDireccion.setText(" Direccion");
        ventana.getContentPane().add(lblDireccion);
       
        JLabel lblnombCalle = new JLabel();
        lblnombCalle.setBounds(xComponente, 190, anchoEtiqueta, alto);
        lblnombCalle.setText("Calle");
        ventana.getContentPane().add(lblnombCalle);
      
        JLabel lblnum = new JLabel();
        lblnum.setBounds(xComponente+125, 190,60, alto);
        lblnum.setText(" Numero ");
        ventana.getContentPane().add(lblnum);
        
        JLabel lblpiso = new JLabel();
        lblpiso.setBounds(xComponente+190, 190, 50, alto);
        lblpiso.setText(" Piso ");
        ventana.getContentPane().add(lblpiso);
        
        JLabel lblDepto = new JLabel();
        lblDepto.setBounds(xComponente+255, 190, 50, alto);
        lblDepto.setText(" DpTo.");
        ventana.getContentPane().add(lblDepto); 
       
        textDireccion = new JTextField();
        textDireccion.setBounds(xComponente, 210, anchoEtiqueta, alto);
        ventana.getContentPane().add(textDireccion);
      
        
        textnumero = new JTextField();
        textnumero .setBounds(xComponente+125, 210, 50, alto);
        ventana.getContentPane().add(textnumero);
        
       

        textPiso = new JTextField();
        textPiso.setBounds(xComponente+190, 210,50, alto);
        ventana.getContentPane().add(textPiso);
        
        textDepto = new JTextField();
        textDepto.setBounds(xComponente+255, 210,50, alto);
        ventana.getContentPane().add(textDepto);
        //////////////////////////////////////////Direccion//////////////////////////////////////////
        
        /////////////////botones registro y salida//////////////////////////////////////
        JButton btRegistrar = new JButton();
        btRegistrar.setText("Registrarse");
        btRegistrar.setBounds(xComponente, 430, anchoEtiqueta, alto);
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar();
            }
        });
        ventana.getContentPane().add(btRegistrar);

        JButton btvolver = new JButton();
        btvolver.setText("Volver");
        btvolver.setBounds(380, 430, anchoEtiqueta, alto);
        btvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverALogin();
            }
        });
        ventana.getContentPane().add(btvolver);

        JLabel lblMensaje = new JLabel();
        lblMensaje.setBounds(xEtiqueta,400, 570, alto);
        lblMensaje.setText("Dirijase al centro de salud mas cercano para verificar y completar datos");
        ventana.getContentPane().add(lblMensaje);
        /////////////////botones registro y salida//////////////////////////////////////
        //////////////////Combo lugatres///////////////////////////////////////////////
        JLabel lbllugares = new JLabel();
        lbllugares.setBounds(xEtiqueta, 240, 200, alto);
        lbllugares.setText("Seleccione Lugar de Atencion");
        ventana.getContentPane().add(lbllugares);
        
        jcLugares= new JComboBox(getArrayLugares());
        jcLugares.setBounds(xComponente,270,anchoEtiqueta,alto);
        ventana.getContentPane().add(jcLugares);
        }

    private void registrar() {
        //Aca se hace la llamada a registrse.
        String nombre, apellido, usuario, contraceña,email,calle,depto;

        int numHistClinica,numero,piso;
        try {
            numHistClinica = new Integer(txtNroHClinica.getText());
        } catch (Exception e) {
            MiDialogo.mostrar("Error", "La historia clinica debe ser un valor numerico");
            return;
        }
         try {
            numero = new Integer(textnumero.getText());
            piso=new Integer(textPiso.getText());
        } catch (Exception e) {
            MiDialogo.mostrar("Error", "Debe ser un valor numerico");
            return;
        }
        nombre = textNombre.getText();
        apellido = textApellido.getText();
        usuario = txtUsuario.getText();
        contraceña = textContraceña.getText();
        email=textEmail.getText();
        calle=textDireccion.getText();
        depto=textDepto.getText();        
        Lugar lugar = getLugarSeleccionado();
        
        Paciente paciente = null;
        try {
            paciente = cuentaNueva.AgregarCuentaPaciente(nombre, apellido, numHistClinica, usuario, contraceña, email, calle, numero, piso, depto, lugar);
        } catch (TuSaludException ex) {
            MiDialogo.mostrar(ex, "Error al crear el Paciente");
            return;
        }
        MiDialogo.mostrar("Su cuenta fue creada con Exito", "Bienvenido!!!");
        cuentaNueva.volverALogin(this);
    }  
    
    private String[] getArrayLugares() {
        String[] lugares = new String[lista.size()];
        for(int i=0; i<lista.size();i++) { 
            lugares[i] = lista.get(i).getNombre();
        }
        return lugares;
    }
    
    private void volverALogin() {
        cuentaNueva.volverALogin(this);
    }

    private Lugar getLugarSeleccionado() {
        return lista.get(this.jcLugares.getSelectedIndex());
    }
}
