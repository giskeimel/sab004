/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.VistaLogin;

/**
 *
 * @author Nati
 */
public class Navegacion {
    
    protected final TuSalud tuSalud;
    protected VistaLogin login;
    
    public Navegacion(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void crearLogin() {
        if (login == null) {
            login = new VistaLogin(new LoginController(tuSalud));
        }
        login.setVisible(true);
    }
    
    public void ocultarLogin(){
        login.setVisible(false);
        login.dispose();
        login = null;
    }
}
