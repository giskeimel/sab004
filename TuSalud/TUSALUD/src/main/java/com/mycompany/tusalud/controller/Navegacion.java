/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.init.TuSalud;
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
    
    private TuSalud tuSalud;
    
    VistaLogin login;
    VistaMenu menu;
    VistaSeleccionarEspecialidad especialidad;
    VistaAlmanaque almanaque;
    
    public Navegacion(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void crearLogin() {
        if (login == null) {
            login = new VistaLogin(new LoginService(tuSalud));
        }
        login.setVisible(true);
    }
    
    public void crearMenu(){
        if (menu == null){
            menu = new VistaMenu(tuSalud);
        }
        login.setVisible(false);
        menu.setVisible(true);
    }
    
    public void crearSeleccionEspecialidad(){
        if (especialidad == null) {
            especialidad = new VistaSeleccionarEspecialidad(new EspecialidadService(tuSalud));
        }
        menu.setVisible(false);
        especialidad.setVisible(true);
    }
    
    public void crearAlmanaque(){
        if (menu == null) {
            menu = new VistaMenu(tuSalud);
        }
        menu.setVisible(false);
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
