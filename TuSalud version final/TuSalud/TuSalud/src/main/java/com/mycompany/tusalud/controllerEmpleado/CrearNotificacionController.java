/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.NotificacionService;
import com.mycompany.tusalud.init.TuSalud;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class CrearNotificacionController {
    
    private final TuSalud tuSalud;
    private final NotificacionService notificacionService = new NotificacionService();
    
    public CrearNotificacionController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void crearNotificacion(Date fechaVigenciaInicial, Date fechaVigenciaFinal, String texto, Paciente paciente, Lugar lugar, JFrame ventanaAnterior){
        
        if (paciente != null){
            notificacionService.crearNotificacion(fechaVigenciaInicial, fechaVigenciaFinal, texto, paciente.getId(), null);
        }
        else{
            notificacionService.crearNotificacion(fechaVigenciaInicial, fechaVigenciaFinal, texto, null, lugar.getId());
        }
        volverACargarNotificaciones(paciente, ventanaAnterior);
    }
    
    public void volverACargarNotificaciones(Paciente paciente, JFrame ventanaAnterior){
        
        if (paciente != null){
            List<Object[]> lista1 = notificacionService.getNotificacion(paciente.getId(), null);
            tuSalud.getNavegacionEmpleado().crearNotificacionesDePaciente(lista1, paciente, ventanaAnterior);
        }
        else{
            List<Object[]> lista2 = notificacionService.getNotificacion(null, tuSalud.getEmpleado().getLugarDesignado().getId());
            tuSalud.getNavegacionEmpleado().crearNotificacionGlobal(lista2, ventanaAnterior);
        }
    }
}
