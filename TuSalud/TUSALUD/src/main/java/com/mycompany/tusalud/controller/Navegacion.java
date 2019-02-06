/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.interfaces.VistaLogin;
import com.mycompany.tusalud.interfaces.VistaSeleccionarEspecialidad;

/**
 *
 * @author gkeimel
 * Cada pantalla tiene su metodo de creacion y deberia setear invisible el resto de las pantallas
 */
public class Navegacion {
    
    VistaLogin login;
    VistaSeleccionarEspecialidad especialidad;
    
    public void crearLogin() {
        if (login == null) {
            login = new VistaLogin();
        }
        login.setVisible(true);
    }
    
    public void crearSeleccionEspecialidad(){
        if (especialidad == null) {
            especialidad = new VistaSeleccionarEspecialidad();
        }
        login.setVisible(false);
        especialidad.setVisible(true);
    }
}
