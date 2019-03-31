/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.controller.AgregarCuentaController;
import com.mycompany.tusalud.controller.Navegacion;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Profesional;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfacesEmpleado.VistaAgregarDerivacion;
import com.mycompany.tusalud.interfacesEmpleado.VistaAgregarEmpleado;
import com.mycompany.tusalud.interfacesEmpleado.VistaCrearTurno;
import com.mycompany.tusalud.interfacesEmpleado.VistaCalendarioCrearTurno;
import com.mycompany.tusalud.interfacesEmpleado.VistaCrearNotificacion;
import com.mycompany.tusalud.interfacesEmpleado.VistaMenuEmpleado;
import com.mycompany.tusalud.interfacesEmpleado.VistaModificarDatosDePaciente;
import com.mycompany.tusalud.interfacesEmpleado.VistaNotificacionGlobal;
import com.mycompany.tusalud.interfacesEmpleado.VistaNotificacionesDePaciente;
import com.mycompany.tusalud.interfacesEmpleado.VistaPacientesDeLugar;
import com.mycompany.tusalud.interfacesEmpleado.VistaPacientesHabilitarDerivacion;
import com.mycompany.tusalud.interfacesEmpleado.VistaSeleccionarPacienteAModificar;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Nati
 */
public class NavegacionEmpleado extends Navegacion {
    
    private VistaMenuEmpleado menu;
    private VistaCalendarioCrearTurno calendarioCrearTurno;
    private VistaCrearTurno crearTurno;
    private VistaAgregarEmpleado agregarEmpleado;
    private VistaNotificacionGlobal notificacionGlobal;
    private VistaCrearNotificacion crearNotificacion;
    private VistaPacientesDeLugar pacientesDeLugar;
    private VistaNotificacionesDePaciente notificacionesDePaciente;
    private VistaAgregarDerivacion agregarDerivacion;
    private VistaSeleccionarPacienteAModificar seleccionarPacienteAModificar;
    private VistaModificarDatosDePaciente modificarDatosDePaciente;
    private VistaPacientesHabilitarDerivacion pacientesHabilitarDerivacion;
    
    /**
     *
     * @param tuSalud
     */
    public NavegacionEmpleado(TuSalud tuSalud) {
        super(tuSalud);
    }
    
    public void crearMenu(){
        if (menu == null){
            menu = new VistaMenuEmpleado(new MenuEmpleadoController(tuSalud));
        }
        menu.setVisible(true);
    }
    
    public void crearCalendarioCrearTurno(List<Turno> lista, JFrame ventanaAnterior){
        calendarioCrearTurno = new VistaCalendarioCrearTurno(new CalendarioCrearTurnoController(tuSalud), lista);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        calendarioCrearTurno.setVisible(true);
        calendarioCrearTurno = null;
    }
    
    public void crearVistaCrearTurno(List<Especialidad> listaDeEspecialidades, List<Profesional> listaDeProfesionales, LocalDate fechaSeleccionada, JFrame ventanaAnterior){
        crearTurno = new VistaCrearTurno(new CrearTurnoController(tuSalud), listaDeEspecialidades, listaDeProfesionales, fechaSeleccionada);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        crearTurno.setVisible(true);
        crearTurno = null;
    }
    
    public void crearAgregarEmpleado(JFrame ventanaAnterior) throws BDException{
        agregarEmpleado = new VistaAgregarEmpleado(new AgregarCuentaController(tuSalud));        
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        agregarEmpleado.setVisible(true);
        agregarEmpleado = null;
    }
    
    public void crearAgregarDerivacion(Paciente paciente, List<Derivacion> derivaciones, List<Especialidad> especialidades, JFrame ventanaAnterior){
        agregarDerivacion = new VistaAgregarDerivacion(new AgregarDerivacionController(tuSalud), paciente, derivaciones, especialidades);        
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        agregarDerivacion.setVisible(true);
        agregarDerivacion = null;
    }
    
    public void crearNotificacionGlobal(List<Object[]> lista, JFrame ventanaAnterior){
        notificacionGlobal = new VistaNotificacionGlobal(new NotificacionGlobalController(tuSalud), lista);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        notificacionGlobal.setVisible(true);
        notificacionGlobal = null;
    }
    
    public void crearVistaCrearNotificacion(Paciente paciente, Lugar lugar, JFrame ventanaAnterior){
        crearNotificacion = new VistaCrearNotificacion(new CrearNotificacionController(tuSalud), paciente, lugar);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        crearNotificacion.setVisible(true);
        crearNotificacion = null;
    }
    
    public void crearPacientesDeLugar(List<Object[]> lista, JFrame ventanaAnterior){
        pacientesDeLugar = new VistaPacientesDeLugar(new PacientesDeLugarController(tuSalud), lista);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        pacientesDeLugar.setVisible(true);
        pacientesDeLugar = null;
    }
    
    public void crearNotificacionesDePaciente(List<Object[]> lista, Paciente paciente, JFrame ventanaAnterior){
        notificacionesDePaciente = new VistaNotificacionesDePaciente(new NotificacionesDePacienteController(tuSalud), lista, paciente);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        notificacionesDePaciente.setVisible(true);
        notificacionesDePaciente = null;
    }
    
    public void crearVistaSeleccionarPacienteAModificar(List<Object[]> lista, JFrame ventanaAnterior){
        seleccionarPacienteAModificar = new VistaSeleccionarPacienteAModificar(new SeleccionarPacienteAModificarController(tuSalud), lista);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        seleccionarPacienteAModificar.setVisible(true);
        seleccionarPacienteAModificar = null;
    }
    
    public void crearModificarDatosDePaciente(Paciente paciente, List<Lugar> lugares, JFrame ventanaAnterior){
        modificarDatosDePaciente = new VistaModificarDatosDePaciente(new ModificarDatosDePacienteController(tuSalud), paciente, lugares);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        modificarDatosDePaciente.setVisible(true);
        modificarDatosDePaciente = null;
    }
    
    public void crearVistaPacientesHabilitarDerivacion(List<Object[]> lista, JFrame ventanaAnterior){
        pacientesHabilitarDerivacion = new VistaPacientesHabilitarDerivacion(new PacientesHabilitarDerivacionController(tuSalud), lista);
        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        pacientesHabilitarDerivacion.setVisible(true);
        pacientesHabilitarDerivacion = null;
    }
    
    public void volverAMenu(JFrame ventanaAnterior){
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        menu.setVisible(true);
    }
    
    public void cerrarSesion(){
        menu.dispose();
        menu = null;
    }
}
