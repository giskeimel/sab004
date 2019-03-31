/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.EspecialidadService;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.db.NotificacionService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class MenuController {
    
    private final EspecialidadService especialidadService = new EspecialidadService();
    private final LugarService lugarService = new LugarService();
    private final NotificacionService notificacionService = new NotificacionService();
    private final TuSalud tuSalud;
    
    public MenuController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void crearSeleccionEspecialidad() throws BDException, LoginException {
        try{
            List<Especialidad> lista = especialidadService.consultarEspecialidadAp(tuSalud.getPaciente());
            if(lista == null){
                throw new BDException("La lista esta vacia");
            }
            tuSalud.getNavegacionPaciente().crearSeleccionEspecialidad(lista);
        } catch(BDException e) {
            MiDialogo.mostrar("No hay turnos disponibles", "Mensaje");
            e.printStackTrace();
        }
    }
    
    public void crearNotificaciones(){
        List<Object[]> lista = notificacionService.getNotificacion(tuSalud.getPaciente().getId(), tuSalud.getPaciente().getLugarDesignado().getId());
        if(lista == null){
            System.out.println("Lista null");
        }
        tuSalud.getNavegacionPaciente().crearNotificaciones(lista);
    }
    
    public void crearCancelarTurnos(JFrame ventanaAnterior) throws BDException{
        try{
            List<Turno> turnosACancelar = lugarService.getListaTurnosDePaciente(tuSalud.getPaciente().getId());
            if(turnosACancelar == null){
                throw new BDException("La lista esta vacia");
            }
            tuSalud.getNavegacionPaciente().crearCancelarTurnos(turnosACancelar, ventanaAnterior);
        } catch(BDException e) {
            MiDialogo.mostrar("No has adquirido ningun turno", "Mensaje");
            e.printStackTrace();
        }
    }
    
    public Paciente getUsuario(){
        return tuSalud.getPaciente();
    }
    
    public void cerrarSesion(){
        tuSalud.setPersonaLogueada(null);
        tuSalud.getNavegacionPaciente().cerrarSesion();
        tuSalud.getNavegacion().crearLogin();
    }
}
