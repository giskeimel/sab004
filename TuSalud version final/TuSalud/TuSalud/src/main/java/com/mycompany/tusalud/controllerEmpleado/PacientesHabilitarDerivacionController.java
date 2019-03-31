/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.DerivacionService;
import com.mycompany.tusalud.db.EspecialidadService;
import com.mycompany.tusalud.db.PacienteService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.init.TuSalud;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class PacientesHabilitarDerivacionController {
    
    private final TuSalud tuSalud;
    private final PacienteService pacienteService = new PacienteService();
    private final EspecialidadService especialidadService = new EspecialidadService();
    private final DerivacionService derivacionService = new DerivacionService();
    
    public PacientesHabilitarDerivacionController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void buscarPacientePorIndice(String valor, JFrame ventanaAnterior){
        List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), valor);
        tuSalud.getNavegacionEmpleado().crearVistaPacientesHabilitarDerivacion(lista, ventanaAnterior);
    }
    
    public void idPacienteSeleccionado(Integer idPaciente, JFrame ventanaAnterior) throws BDException, LoginException{
        Paciente paciente = pacienteService.getPacientePorId(idPaciente);
        List<Derivacion> derivaciones = derivacionService.getDerivacionesDePaciente(paciente);
        List<Especialidad> especialidades = especialidadService.getListaDeEspecialidadesEnDB();
        tuSalud.getNavegacionEmpleado().crearAgregarDerivacion(paciente, derivaciones, especialidades, ventanaAnterior);
    }
    
    public void volverAMenu(JFrame ventanaAnterior){
        tuSalud.getNavegacionEmpleado().volverAMenu(ventanaAnterior);
    }
}
