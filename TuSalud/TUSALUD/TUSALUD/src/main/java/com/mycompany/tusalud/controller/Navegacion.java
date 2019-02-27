/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.VistaLogin;
import com.mycompany.tusalud.interfaces.VistaMenu;
import com.mycompany.tusalud.interfaces.VistaSeleccionarEspecialidad;
import com.mycompany.tusalud.interfaces.VistaAlmanaque;
import com.mycompany.tusalud.interfaces.VistaCancelarTurnos;
import com.mycompany.tusalud.interfaces.VistaNotificacion;
import com.mycompany.tusalud.interfaces.VistaRegistrarse;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author gkeimel
 * Cada pantalla tiene su metodo de creacion y deberia setear invisible el resto de las pantallas
 */
public class Navegacion {
    
    private final TuSalud tuSalud;
    
    VistaLogin login;
    VistaMenu menu;
    VistaSeleccionarEspecialidad especialidad;
    VistaAlmanaque almanaque;
    VistaCancelarTurnos cancelarTurnos;
    VistaRegistrarse vistaRegistrarse;
    VistaNotificacion notificacion;
    
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
            menu = new VistaMenu(new MenuService(tuSalud));
        }
        login.setVisible(false);
        menu.setVisible(true);
    }
    
    public void crearSeleccionEspecialidad(List<Especialidad> lista){
        especialidad = new VistaSeleccionarEspecialidad(new EspecialidadService(tuSalud), lista);
        
        menu.setVisible(false);
        especialidad.setVisible(true);
    }
    
    public void crearAlmanaque(List<Turno> lista){
        almanaque = new VistaAlmanaque(new AlmanaqueService(tuSalud), lista);
        
        especialidad.dispose();
        almanaque.setVisible(true);
    }
    
    public void crearNotificaciones(List<Object[]> lista){
        notificacion = new VistaNotificacion(new NotificacionService(tuSalud), lista);
        
        menu.setVisible(false);
        notificacion.setVisible(true);
    }
    
    public void crearCancelarTurnos(List<Turno> lista){
        cancelarTurnos = new VistaCancelarTurnos(new CancelarTurnosService(tuSalud), lista);
        menu.setVisible(false);
        cancelarTurnos.setVisible(true);
    }
    
    public void volverAMenu(JFrame ventana){
        ventana.dispose();
        menu.setVisible(true);
    }
    
    public void cerrarSesion(){
        menu.dispose();
        menu = null;
        login.setVisible(true);
    }
    
    public void registrarNuevaCuenta() {
        vistaRegistrarse = new VistaRegistrarse(new AgregarCuentaService(tuSalud), login);        
        
        vistaRegistrarse.mostrar();
        vistaRegistrarse = null;
    }
}
