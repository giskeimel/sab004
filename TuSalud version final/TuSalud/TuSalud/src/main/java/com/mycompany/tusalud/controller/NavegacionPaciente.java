/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.VistaSeleccionarEspecialidad;
import com.mycompany.tusalud.interfaces.VistaAlmanaqueP;
import com.mycompany.tusalud.interfaces.VistaCancelarTurno;
import com.mycompany.tusalud.interfaces.VistaMenu;
import com.mycompany.tusalud.interfaces.VistaNotificacion;
import com.mycompany.tusalud.interfaces.VistaRegistrarse;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author gkeimel
 * Cada pantalla tiene su metodo de creacion y deberia setear invisible el resto de las pantallas
 */
public class NavegacionPaciente extends Navegacion {
    
    private VistaMenu menu;
    private VistaSeleccionarEspecialidad especialidad;
    private VistaAlmanaqueP almanaque;
    private VistaCancelarTurno cancelarTurnos;
    private VistaRegistrarse vistaRegistrarse;
    private VistaNotificacion notificacion;
    
    public NavegacionPaciente(TuSalud tuSalud) {
        super(tuSalud);
    }
    
    public void crearMenu(){
        if (menu == null){
            menu = new VistaMenu(new MenuController(tuSalud));
        }
        menu.setVisible(true);
    }
    
    public void crearSeleccionEspecialidad(List<Especialidad> lista){
        especialidad = new VistaSeleccionarEspecialidad(new SeleccionarEspecialidadController(tuSalud), lista);
        
        menu.setVisible(false);
        especialidad.setVisible(true);
    }
    
    public void crearAlmanaque(List<Turno> lista){
        almanaque = new VistaAlmanaqueP(new AlmanaqueController(tuSalud), lista);
        
        especialidad.setVisible(false);
        especialidad = null;
        almanaque.setVisible(true);
    }
    
    public void crearNotificaciones(List<Object[]> lista){
        notificacion = new VistaNotificacion(new NotificacionController(tuSalud), lista);
        
        menu.setVisible(false);
        notificacion.setVisible(true);
    }
    
    public void crearCancelarTurnos(List<Turno> lista, JFrame ventanaAnterior){
        cancelarTurnos = new VistaCancelarTurno(new CancelarTurnoController(tuSalud), lista);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        cancelarTurnos.setVisible(true);
        cancelarTurnos = null;
    }
    
    public void volverAMenu(JFrame ventana){
        ventana.dispose();
        menu.setVisible(true);
    }
    
    public void cerrarSesion(){
        menu.dispose();
        menu = null;
    }
    
    public void registrarNuevaCuenta(JFrame ventanaAnterior) throws BDException {
        vistaRegistrarse = new VistaRegistrarse(new AgregarCuentaController(tuSalud));        
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        vistaRegistrarse.setVisible(true);
        vistaRegistrarse = null;
    }
}
