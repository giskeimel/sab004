/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Persona;
import com.mycompany.tusalud.db.ConsultaLogin;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.init.TuSalud;

import javax.swing.JOptionPane;

/**
 *
 * @author gkeimel
 */
public class LoginService {
    
    private ConsultaLogin consultaLogin = new ConsultaLogin();
    private final TuSalud tuSalud;
    
    public LoginService(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void login(String usuario, String password) throws LoginException {
            Persona persona = consultaLogin.login(usuario, password);
            tuSalud.setPersonaLogueada(persona);
            tuSalud.getNavegacion().crearMenu();
    }
}
