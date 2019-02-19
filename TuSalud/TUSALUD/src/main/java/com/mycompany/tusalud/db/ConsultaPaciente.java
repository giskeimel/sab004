/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.TuSaludException;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class ConsultaPaciente {
     
    public Paciente crearPaciente(Cuenta cuenta,String nombre,String apellido,int historia_clinica, String email) throws TuSaludException {    
        Paciente paciente = new Paciente();
        paciente.setApellido(apellido);
        paciente.setCuenta(cuenta);
        paciente.setHistoria_clinica(historia_clinica);
        paciente.setNombre(nombre);
        paciente.setEmail(email);
        
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            session.saveOrUpdate(paciente);
            session.getTransaction().commit();                                
        } catch (Exception e) {
            e.printStackTrace();
            throw new TuSaludException("Error al pedir el paciente", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return paciente;
    }
}
