/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.EmpleadoService;
import com.mycompany.tusalud.db.PacienteService;
import com.mycompany.tusalud.db.CuentaService;
import com.mycompany.tusalud.db.DerivacionService;
import com.mycompany.tusalud.db.DireccionService;
import com.mycompany.tusalud.db.EspecialidadService;
import com.mycompany.tusalud.excepciones.TuSaludException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.VistaRegistrarse;
import com.mycompany.tusalud.interfacesEmpleado.VistaAgregarDerivacion;
import com.mycompany.tusalud.interfacesEmpleado.VistaMenuEmpleado;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Nati
 */
public class AgregarCuentaController {

    private final TuSalud tuSalud;
    private final CuentaService cuentaService = new CuentaService();
    private final PacienteService pacienteService = new PacienteService();
    private final EmpleadoService empleadoService = new EmpleadoService();

    public AgregarCuentaController(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public Paciente AgregarCuentaPaciente(String nombre, String apellido, int historia_clinica,String usuario, String contaceña,String email, String calle,int numero,int piso,String depto, Lugar lugar) throws TuSaludException {
        
        Cuenta cuenta = new Cuenta();
        Paciente paciente = new Paciente();
        
        DireccionService consultaDireccion = new DireccionService();        
        Direccion direccion = consultaDireccion.crearDireccion(calle, numero, piso, depto);        
        
        cuenta = cuentaService.crearCuenta(usuario, contaceña);
        paciente = pacienteService.crearPaciente(cuenta, nombre, apellido, historia_clinica, email,direccion,lugar);
        
        EspecialidadService consultaEspecialidad=new EspecialidadService();
        Especialidad especialidad = new Especialidad();
        int id = 1;
        especialidad=consultaEspecialidad.consultarDeFamil(id);
        
        Date fecha = new Date();
        Derivacion derivacion = new Derivacion();
        derivacion.setAprobado(true);
        derivacion.setPaciente(paciente);
        derivacion.setEspecialidad(especialidad);
        derivacion.setFecha(fecha);
        DerivacionService derivFamilia = new DerivacionService();
        derivFamilia.guardarDerivacionEnBD(derivacion);
        
        return paciente;
        
    }

    public Empleado AgregarCuentaEmpleado(String nombre, String apellido, long telefono,
        String email,  String calle,int numero,int piso,String depto, int legajoEmpleado, Lugar lugarDesignado,
        String usuario, String contaceña ) throws TuSaludException {
       
        Cuenta cuenta = new Cuenta();
        Empleado empleado = new Empleado();
        DireccionService consultaDireccion = new DireccionService();
      
        
        cuenta = cuentaService.crearCuenta(usuario, contaceña);
        Direccion direccion = consultaDireccion.crearDireccion(calle, numero, piso, depto);
        empleado = empleadoService.crearEmpleado(cuenta, nombre, apellido, telefono, email, direccion,
        legajoEmpleado, lugarDesignado);
        return empleado;
    }
    
    public void volverALogin(VistaRegistrarse vistaRegistrarse) {        
        vistaRegistrarse.setVisible(false);
        vistaRegistrarse.dispose();
        tuSalud.getNavegacion().crearLogin();
    }
    
    public void volverALogin(VistaMenuEmpleado vistaMenuEmpleado) {        
        vistaMenuEmpleado.setVisible(false);
        vistaMenuEmpleado.dispose();
        tuSalud.getNavegacionEmpleado().crearLogin();
    }
    
    public void volverAMenu(JFrame ventanaAnterior) {        
        ventanaAnterior.setVisible(false);
        ventanaAnterior.dispose();
        tuSalud.getNavegacionEmpleado().crearMenu();
    }
}