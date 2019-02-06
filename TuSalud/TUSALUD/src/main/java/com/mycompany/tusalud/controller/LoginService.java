/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.db.ConsultaLogin;
import com.mycompany.tusalud.init.MainClass;

/**
 *
 * @author gkeimel
 */
public class LoginService {
    private ConsultaLogin consultaLogin = new ConsultaLogin();
    
    public void login(String usuario, String password) {
        if (consultaLogin.login(usuario, password)) {
            //Aca deberia ir al menu.
            
            MainClass.navegacion.crearMenu();
        } else {
            //deberiamos mostrar un mensaje de error.
        }
        
    }
}
