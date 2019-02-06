/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.interfaces.VistaAlmanaque;
import com.mycompany.tusalud.interfaces.VistaLogin;
import com.mycompany.tusalud.interfaces.VistaMenu;
import com.mycompany.tusalud.interfaces.VistaSeleccionarEspecialidad;

/**
 *
 * @author gkeimel
 * Cada pantalla tiene su metodo de creacion y deberia setear invisible el resto de las pantallas
 */
public class Navegacion {
    
    VistaLogin login;
    VistaMenu menu;
    VistaSeleccionarEspecialidad especialidad;
    VistaAlmanaque almanaque;
    
    public void crearLogin() {
        if (login == null) {
            login = new VistaLogin();
        }
        login.setVisible(true);
    }
    
    public void crearMenu(){
        if (menu == null){
            menu = new VistaMenu();
        }
        login.setVisible(false);
        menu.setVisible(true);
    }
    
    public void crearSeleccionEspecialidad(){
        if (especialidad == null) {
            especialidad = new VistaSeleccionarEspecialidad();
        }
        menu.setVisible(false);
        especialidad.setVisible(true);
    }
    
    public void crearAlmanaque(){
        if (almanaque == null) {
            almanaque = new VistaAlmanaque();
        }
        especialidad.setVisible(false);
        almanaque.setVisible(true);
    }
    
    public void volverAMenu(){
        especialidad.dispose();
        menu.setVisible(true);
    }
    
    public void cerrarSesion(){
        menu.dispose();
        login.setVisible(true);
    }
}
