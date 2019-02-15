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
import com.mycompany.tusalud.db.CargarPasiente;
import com.mycompany.tusalud.db.CrearCuenta;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.init.TuSalud;
import java.util.List;

/**
 *
 * @author Nati
 */
public class AgregarCuenta {

    private TuSalud tuSalud;
    private CrearCuenta cuentaNueva = new CrearCuenta();
    private CargarPasiente pacienteNuevo = new CargarPasiente();
    private CargarEmpleado empleadoNuevo = new CargarEmpleado();

    public Paciente AgregarCuentaPaciente(TuSalud tuSalud, String nombre, String apellido,
             int historia_clinica,String usuario, String contaceña) throws LoginException {
        Cuenta cuenta = new Cuenta();
        Paciente paciente = new Paciente();
        this.tuSalud = tuSalud;
        cuenta = cuentaNueva.crearCuenta(usuario, contaceña);
        paciente = pacienteNuevo.crearPaciente(cuenta, nombre, apellido, historia_clinica);

        return paciente;
    }

    public Empleado AgregarCuentaEmpleado(TuSalud tuSalud, String nombre, String apellido, long telefono,
            String email, Direccion direccion, int legajoEmpleado, Lugar lugarDesignado,
            String usuario, String contaceña) throws LoginException {
        Cuenta cuenta = new Cuenta();
        Empleado empleado = new Empleado();
        this.tuSalud = tuSalud;
        cuenta = cuentaNueva.crearCuenta(usuario, contaceña);
        empleado = empleadoNuevo.crearEmpleado(cuenta, nombre, apellido, telefono, email, direccion,
                legajoEmpleado, lugarDesignado);
        return empleado;
    }
}
