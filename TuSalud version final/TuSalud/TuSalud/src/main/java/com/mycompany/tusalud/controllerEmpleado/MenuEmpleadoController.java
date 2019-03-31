/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.db.NotificacionService;
import com.mycompany.tusalud.db.PacienteService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class MenuEmpleadoController {
    
    private final TuSalud tuSalud;
    private final LugarService lugarService = new LugarService();
    private final NotificacionService notificacionService = new NotificacionService();
    private final PacienteService pacienteService = new PacienteService();
    
    public MenuEmpleadoController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void crearCalendarioDeTurnos(JFrame ventana) throws BDException{
        List<Turno> lista = lugarService.getListaTurnosDeLugarPorNombre(tuSalud.getEmpleado().getLugarDesignado().getNombre());
        tuSalud.getNavegacionEmpleado().crearCalendarioCrearTurno(lista, ventana);
    }
    
    public void cargarEmpleado(JFrame ventanaAnterior) throws BDException{
        tuSalud.getNavegacionEmpleado().crearAgregarEmpleado(ventanaAnterior);
    }
    
    public void crearVistaPacientesHabilitarDerivacion(JFrame ventanaAnterior){
       List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), "");
       tuSalud.getNavegacionEmpleado().crearVistaPacientesHabilitarDerivacion(lista, ventanaAnterior);
    }
    
    public void crearNotificacionesGlobales(JFrame ventanaAnterior){
        List<Object[]> lista = notificacionService.getNotificacion(null, tuSalud.getEmpleado().getLugarDesignado().getId());
        tuSalud.getNavegacionEmpleado().crearNotificacionGlobal(lista, ventanaAnterior);
    }
    
    public void crearVistaPacientesAModificar(JFrame ventanaAnterior){
        List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), "");
        tuSalud.getNavegacionEmpleado().crearVistaSeleccionarPacienteAModificar(lista, ventanaAnterior);
    }
    
    public Empleado getUsuario(){
        return tuSalud.getEmpleado();
    }
    
    public void cerrarSesion(){
        tuSalud.setPersonaLogueada(null);
        tuSalud.getNavegacionEmpleado().cerrarSesion();
        tuSalud.getNavegacion().crearLogin();
    }
}
