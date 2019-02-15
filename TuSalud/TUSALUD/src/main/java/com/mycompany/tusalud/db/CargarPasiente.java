/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Persona;
import com.mycompany.tusalud.excepciones.LoginException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class CargarPasiente {
      public Paciente crearPaciente(Cuenta cuenta,String nombre,String apellido,int historia_clinica)throws LoginException {
        Paciente paciente = null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Paciente p WHERE p.historia_clinica = :historia_clinica ");
            query.setParameter("historia_clinica", historia_clinica);
            paciente = (Paciente) query.uniqueResult();             
            session.getTransaction().commit();
                        
            if (paciente == null) {
                paciente.setApellido(apellido);
                paciente.setCuenta(cuenta);
                paciente.setHistoria_clinica(historia_clinica);
                paciente.setId(Integer.SIZE);
                paciente.setNombre(nombre);
                }
            else{
                 throw new LoginException("El paciente ya Exixte");

                }
            return paciente;
        } catch (LoginException e) {
            e.printStackTrace();
            throw new LoginException("Error al pedir la Cuenta", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
    }

    
}
