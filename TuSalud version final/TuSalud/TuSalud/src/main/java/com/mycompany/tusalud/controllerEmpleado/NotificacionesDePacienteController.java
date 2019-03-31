/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

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
public class NotificacionesDePacienteController {
    
    private final TuSalud tuSalud;
    private final PacienteService pacienteService = new PacienteService();
    private final NotificacionService notificacionService = new NotificacionService();
    
    public NotificacionesDePacienteController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void crearNotificacion(Paciente paciente, JFrame ventanaAnterior){
        tuSalud.getNavegacionEmpleado().crearVistaCrearNotificacion(paciente, null, ventanaAnterior);
    }
    
    public void eliminarNotificacion(Paciente paciente, Integer idNotificacion, JFrame ventanaAnterior) throws BDException{
        notificacionService.eliminarNotificacionEnBD(idNotificacion);
        List<Object[]> lista1 = notificacionService.getNotificacion(paciente.getId(), null);
        tuSalud.getNavegacionEmpleado().crearNotificacionesDePaciente(lista1, paciente, ventanaAnterior);
    }
    
    public void mostrarMensaje(String mensaje){
        MiDialogo.mostrar(mensaje, "Notificacion");
    }
    
    public void volverASeleccionarPaciente(JFrame ventanaAnterior){
       List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), "");
       tuSalud.getNavegacionEmpleado().crearPacientesDeLugar(lista, ventanaAnterior);
    }
}
