/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.DireccionService;
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
public class ModificarDatosDePacienteController {
    
    private final TuSalud tuSalud;
    private final PacienteService pacienteService = new PacienteService();
    private final DireccionService direccionService = new DireccionService();
    private final LugarService lugarService = new LugarService();
    
    public ModificarDatosDePacienteController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void guardarEnBD(Paciente paciente, Direccion direccion, Lugar lugar, JFrame ventanaAnterior) throws BDException{
        direccionService.guardarDireccionEnBD(direccion);
        lugarService.guardarLugar(lugar);
        pacienteService.guardarPacienteEnBD(paciente);
        volverASeleccionarPaciente(ventanaAnterior);
    }
    
    public void volverASeleccionarPaciente(JFrame ventanaAnterior){
        List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), "");
        tuSalud.getNavegacionEmpleado().crearVistaSeleccionarPacienteAModificar(lista, ventanaAnterior);
    }
    
    public void volverAMenu(JFrame ventanaAnterior){
        tuSalud.getNavegacionEmpleado().volverAMenu(ventanaAnterior);
    }
}
