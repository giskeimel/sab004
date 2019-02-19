/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.db.CargarEmpleado;
import com.mycompany.tusalud.db.ConsultaPaciente;
import com.mycompany.tusalud.db.ConsultaCuenta;
import com.mycompany.tusalud.excepciones.TuSaludException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.VistaRegistrarse;

/**
 *
 * @author Nati
 */
public class AgregarCuentaService {

    private TuSalud tuSalud;
    private ConsultaCuenta cuentaNueva = new ConsultaCuenta();
    private ConsultaPaciente pacienteNuevo = new ConsultaPaciente();
    private CargarEmpleado empleadoNuevo = new CargarEmpleado();

    public AgregarCuentaService(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public Paciente AgregarCuentaPaciente(String nombre, String apellido,
             int historia_clinica,String usuario, String contaceña,String email) throws TuSaludException {
        Cuenta cuenta = new Cuenta();
        Paciente paciente = new Paciente();
        this.tuSalud = tuSalud;
        cuenta = cuentaNueva.crearCuenta(usuario, contaceña);
        paciente = pacienteNuevo.crearPaciente(cuenta, nombre, apellido, historia_clinica, email);
        return paciente;
    }

    public Empleado AgregarCuentaEmpleado( String nombre, String apellido, long telefono,
            String email, Direccion direccion, int legajoEmpleado, Lugar lugarDesignado,
            String usuario, String contaceña) throws TuSaludException {
        Cuenta cuenta = new Cuenta();
        Empleado empleado = new Empleado();
        this.tuSalud = tuSalud;
        cuenta = cuentaNueva.crearCuenta(usuario, contaceña);
        empleado = empleadoNuevo.crearEmpleado(cuenta, nombre, apellido, telefono, email, direccion,
                legajoEmpleado, lugarDesignado);
        return empleado;
    }
    
    public void volverALogin(VistaRegistrarse vistaRegistrarse) {        
        vistaRegistrarse.ocultar();
        tuSalud.getNavegacion().crearLogin();
    }
}