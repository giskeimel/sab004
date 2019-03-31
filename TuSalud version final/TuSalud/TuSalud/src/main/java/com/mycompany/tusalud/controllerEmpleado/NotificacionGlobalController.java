/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.NotificacionService;
import com.mycompany.tusalud.db.PacienteService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class NotificacionGlobalController {
    
    private final TuSalud tuSalud;
    private final PacienteService pacienteService = new PacienteService();
    private final NotificacionService notificacionService = new NotificacionService();
    
    public NotificacionGlobalController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void mostrarMensaje(String mensaje){
        MiDialogo.mostrar(mensaje, "Notificacion");
    }
    
    public void crearNotificaciones(JFrame ventanaAnterior){
        tuSalud.getNavegacionEmpleado().crearVistaCrearNotificacion(null, tuSalud.getEmpleado().getLugarDesignado(), ventanaAnterior);
    }
    
    public void crearNotificacionesDePaciente(JFrame ventanaAnterior){
        List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), "");
        tuSalud.getNavegacionEmpleado().crearPacientesDeLugar(lista, ventanaAnterior);
    }
    
    public void eliminarNotificacion(Integer idNotificacion, JFrame ventanaAnterior) throws BDException{
        notificacionService.eliminarNotificacionEnBD(idNotificacion);
        List<Object[]> lista = notificacionService.getNotificacion(null, tuSalud.getEmpleado().getLugarDesignado().getId());
        tuSalud.getNavegacionEmpleado().crearNotificacionGlobal(lista, ventanaAnterior);
    }
    
    public Lugar getLugar(){
        return tuSalud.getEmpleado().getLugarDesignado();
    }
    
    public void volverAMenu(JFrame ventanaAnterior){
        tuSalud.getNavegacionEmpleado().volverAMenu(ventanaAnterior);
    }
}
