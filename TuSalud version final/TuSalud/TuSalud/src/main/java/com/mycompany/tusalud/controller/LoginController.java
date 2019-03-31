/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Persona;
import com.mycompany.tusalud.db.LoginService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.MiDialogo;
import javax.swing.JFrame;


/**
 *
 * @author naty
 */
public class LoginController {
    
    private final LoginService loginService = new LoginService();
    private final TuSalud tuSalud;
    
    public LoginController(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void login(String usuario, String password) throws LoginException {
        Persona persona = loginService.login(usuario, password);
        tuSalud.setPersonaLogueada(persona);
        tuSalud.getNavegacion().ocultarLogin();
        
        if (persona instanceof Paciente){
            tuSalud.getNavegacionPaciente().crearMenu();
        }
        else{
            if (persona instanceof Empleado){
                tuSalud.getNavegacionEmpleado().crearMenu();
            }
        }
        
    }
    
    public void registrarCuenta(JFrame ventanaAnterior) {
        try {
            tuSalud.getNavegacionPaciente().registrarNuevaCuenta(ventanaAnterior);
        } catch (BDException ex) {
            MiDialogo.mostrar(ex, "Error");
        }
    }
}
