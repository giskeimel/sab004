/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.NotificacionService;
import com.mycompany.tusalud.db.PacienteService;
import com.mycompany.tusalud.init.TuSalud;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class PacientesDeLugarController {
    
    private final TuSalud tuSalud;
    private final NotificacionService notificacionService = new NotificacionService();
    private final PacienteService pacienteService = new PacienteService();
    
    public PacientesDeLugarController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void CargarNotificacionesDePaciente(Integer idPaciente, JFrame ventanaAnterior){
        Paciente paciente = pacienteService.getPacientePorId(idPaciente);
        List<Object[]> lista = notificacionService.getNotificacion(paciente.getId(), null);
        tuSalud.getNavegacionEmpleado().crearNotificacionesDePaciente(lista, paciente, ventanaAnterior);
    }
    
    public void buscarPacientePorIndice(String valor, JFrame ventanaAnterior){
        List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), valor);
        tuSalud.getNavegacionEmpleado().crearPacientesDeLugar(lista, ventanaAnterior);
    }
    
    public void volverANotificacionGlobal(JFrame ventanaAnterior){
        List<Object[]> lista = notificacionService.getNotificacion(null, tuSalud.getEmpleado().getLugarDesignado().getId());
        tuSalud.getNavegacionEmpleado().crearNotificacionGlobal(lista, ventanaAnterior);
    }
}
