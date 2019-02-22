/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.excepciones.TuSaludException;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class ConsultaPaciente {
     
    public Paciente crearPaciente(Cuenta cuenta, String nombre, String apellido, int historia_clinica, String email, Direccion direccion, Lugar lugar) throws TuSaludException {
        //LA IDEA ES QUE CUANDO CREA UN PACIENTE LE CREE UNA DERIVACION APROVADA DE FAMILIA
        Paciente paciente = new Paciente();
        paciente.setApellido(apellido);
        paciente.setCuenta(cuenta);
        paciente.setHistoria_clinica(historia_clinica);
        paciente.setNombre(nombre);
        paciente.setEmail(email);
        paciente.setDireccion(direccion);
        paciente.setObservaciones(email);
        paciente.setLugarDeAtencion(lugar);

        Session session = null;

        Especialidad especialidad = new Especialidad();
        int id = 1;
        especialidad.setId(id);
        String nom = "De familia";
        especialidad.setNombre(nom);
        
        Date fecha = new Date();
        Derivacion derivacion = null;
        derivacion.setAprobado(true);
        derivacion.setPaciente(paciente);
        derivacion.setEspecialidad(especialidad);
        derivacion.setFecha(fecha);
        ConsultaDerivacion derivFamilia = new ConsultaDerivacion();
        derivFamilia.guardarDerivacionEnBD(derivacion);
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            session.saveOrUpdate(paciente);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TuSaludException("Error al pedir el paciente", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return paciente;
    }
}
