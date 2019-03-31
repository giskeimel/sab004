package com.mycompany.tusalud.interfaces;

import com.mycompany.tusalud.controller.AgregarCuentaController;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.TuSaludException;
import java.util.List;
import javax.swing.JComboBox;

public class VistaRegistrarse extends javax.swing.JFrame {
    
    AgregarCuentaController agregarCuentaController;
    private LugarService consulta = new LugarService();
    private List <Lugar> lista;

    public VistaRegistrarse(AgregarCuentaController agregarCuentaController) throws BDException {

        this.agregarCuentaController = agregarCuentaController;
        this.lista = consulta.getListaDeLugares();
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void registrar() {
        //Aca se hace la llamada a registrse.
        String nombre, apellido, usuario, contraseña,email,calle,depto;
        int numHistClinica,numero,piso;

        try {
            numHistClinica = new Integer(nroHClinica.getText());
        } catch (Exception e) {
            MiDialogo.mostrar("Error", "La historia clinica debe ser un valor numerico");
            return;
        }
         try {
            numero = new Integer(this.numero.getText());
            piso=new Integer(this.piso.getText());
        } catch (Exception e) {
            MiDialogo.mostrar("Error", "Debe ser un valor numerico");
            return;
        }
        nombre = this.nombre.getText();
        apellido = this.apellido.getText();
        usuario = this.usuario.getText();
        contraseña = this.contraseña.getText();
        email= this.email.getText();
        calle= this.calle.getText();
        depto= this.dpto.getText();        
        Lugar lugar = getLugarSeleccionado();

        Paciente paciente = null;
        try {
            paciente = agregarCuentaController.AgregarCuentaPaciente(nombre, apellido, numHistClinica, usuario, contraseña, email, calle, numero, piso, depto, lugar);
        } catch (TuSaludException ex) {
            MiDialogo.mostrar(ex, "Error al crear el Paciente");
            return;
        }
        MiDialogo.mostrar("Su cuenta fue creada con Exito", "Bienvenido!!!");
        agregarCuentaController.volverALogin(this);
    }  
   
    private String[] getArrayLugares() {
        String[] lugares = new String[lista.size()];
        for(int i=0; i<lista.size();i++) { 
            lugares[i] = lista.get(i).getNombre();
        }
        return lugares;
    }
    
    private void volverALogin() {
        agregarCuentaController.volverALogin(this);
    }

    private Lugar getLugarSeleccionado() {
        return lista.get(this.lugares.getSelectedIndex());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        nroHClinica = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        calle = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        piso = new javax.swing.JTextField();
        dpto = new javax.swing.JTextField();
        registrarse = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        lugares = new JComboBox(getArrayLugares());
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 180, -1));
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 180, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 180, -1));
        getContentPane().add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 180, -1));
        getContentPane().add(nroHClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 180, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 180, -1));
        getContentPane().add(calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 200, -1));
        getContentPane().add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 90, -1));
        getContentPane().add(piso, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 380, 80, -1));
        getContentPane().add(dpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 80, -1));

        registrarse.setText("Registrarse");
        registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseActionPerformed(evt);
            }
        });
        getContentPane().add(registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, -1, -1));

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        getContentPane().add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 90, -1));

        getContentPane().add(lugares, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, 80, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesL2/Plantilla r.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseActionPerformed
        registrar();
    }//GEN-LAST:event_registrarseActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        volverALogin();
    }//GEN-LAST:event_atrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField apellido;
    private javax.swing.JButton atras;
    private javax.swing.JTextField calle;
    private javax.swing.JTextField contraseña;
    private javax.swing.JTextField dpto;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> lugares;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nroHClinica;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField piso;
    private javax.swing.JButton registrarse;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

}
