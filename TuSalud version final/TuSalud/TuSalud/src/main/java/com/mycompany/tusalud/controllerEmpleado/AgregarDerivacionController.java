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
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;


/**
 *
 * @author Nati
 */
public class AgregarDerivacionController {
    
    private final TuSalud tuSalud;
    private final DerivacionService derivacionService = new DerivacionService();
    private final PacienteService pacienteService = new PacienteService();
    private final EspecialidadService especialidadService = new EspecialidadService();
    
    
    public AgregarDerivacionController(TuSalud tusalud){
        this.tuSalud = tusalud;
    }
    
    public void agregarDerivacion(Paciente paciente, Especialidad especialidad, Date fecha, JFrame ventanaAnterior) throws BDException, LoginException{
        if ((paciente != null )&&(derivacionService.getDerivacion(paciente.getId(), especialidad.getId()) == null)){
            Derivacion derivacion = new Derivacion();
            derivacion.setAprobado(true);
            derivacion.setFecha(fecha);
            derivacion.setEspecialidad(especialidad);
            derivacion.setPaciente(paciente);
            
            derivacionService.guardarDerivacionEnBD(derivacion);
            
            volverACargarAgregarDerivacion(paciente, ventanaAnterior);
            
            MiDialogo.mostrar("Derivacion Aprobada", "Notificacion");
        }
        else{
            MiDialogo.mostrar("El paciente ya cuenta con esta derivacion", "");
        }
    }
    
    public void volverACargarAgregarDerivacion(Paciente paciente, JFrame ventanaAnterior) throws BDException, LoginException{
        List<Derivacion> derivaciones = derivacionService.getDerivacionesDePaciente(paciente);
        List<Especialidad> especialidades = especialidadService.getListaDeEspecialidadesEnDB();
        tuSalud.getNavegacionEmpleado().crearAgregarDerivacion(paciente, derivaciones, especialidades, ventanaAnterior);
    }
    
    public void eliminarDerivacion(Derivacion derivacion, Paciente paciente, JFrame ventanaAnterior) throws BDException, LoginException{
        derivacionService.eliminarDerivacionEnBD(derivacion);
        volverACargarAgregarDerivacion(paciente, ventanaAnterior);
        MiDialogo.mostrar("Derivacion eliminada con exito", "Notificacion");
    }
    
    public void volverAPacientesHabilitarDerivacion(JFrame ventanaAnterior){
       List<Object[]> lista = pacienteService.getListaDePacientesPorIndice(tuSalud.getEmpleado().getLugarDesignado().getId(), "");
       tuSalud.getNavegacionEmpleado().crearVistaPacientesHabilitarDerivacion(lista, ventanaAnterior);
    }
    
    public void volverAMenu(JFrame ventanaAnterior){
        tuSalud.getNavegacionEmpleado().volverAMenu(ventanaAnterior);
    }
}
