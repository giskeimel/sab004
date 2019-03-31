/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.db.PacienteService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class SeleccionarPacienteAModificarController {
    
    private final TuSalud tuSalud;
    private final PacienteService pacienteService = new PacienteService();
    private final LugarService lugarService = new LugarService();
    
    public SeleccionarPacienteAModificarController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void buscarPacientePorIndice(String valor, JFrame ventanaAnterior){
        List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), valor);
        tuSalud.getNavegacionEmpleado().crearVistaSeleccionarPacienteAModificar(lista, ventanaAnterior);
    }
    
    public void idPacienteAModificar(Integer idPaciente, JFrame ventanaAnterior) throws BDException{
        Paciente paciente = pacienteService.getPacientePorId(idPaciente);
        List<Lugar> lugares = lugarService.getListaDeLugares();
        tuSalud.getNavegacionEmpleado().crearModificarDatosDePaciente(paciente, lugares, ventanaAnterior);
    }
    
    public void eliminarPaciente(Integer idPaciente, JFrame ventanaAnterior) throws BDException{
        Paciente paciente = pacienteService.getPacientePorId(idPaciente);
        pacienteService.eliminarPacienteEnBD(paciente);
        List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), "");
        tuSalud.getNavegacionEmpleado().crearVistaSeleccionarPacienteAModificar(lista, ventanaAnterior);
    }
    
    public void volverAMenu(JFrame ventanaAnterior){
        tuSalud.getNavegacionEmpleado().volverAMenu(ventanaAnterior);
    }
}
