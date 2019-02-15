/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Persona;
import com.mycompany.tusalud.excepciones.LoginException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class CrearCuenta {
    
     public Cuenta crearCuenta(String usuario, String password) throws LoginException {
        Persona persona = null;
        Cuenta cuenta =null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Paciente p WHERE p.cuenta.usuario = :usuario AND p.cuenta.contraseña = :contraseña");
            query.setParameter("usuario", usuario);
            query.setParameter("contraseña", password);
            persona = (Paciente) query.uniqueResult();             
            session.getTransaction().commit();
                        
            if (persona == null) {
                session.beginTransaction();
                query = session.createQuery("FROM Empleado e WHERE e.cuenta.usuario = :usuario AND e.cuenta.contraseña = :contraseña");
                query.setParameter("usuario", usuario);
                query.setParameter("contraseña", password);
                persona = (Empleado) query.uniqueResult();
                session.getTransaction().commit();
                
            }
            
            if (persona == null) {
                cuenta.setUsuario(usuario);
                cuenta.setIdCuenta(Integer.SIZE);
                cuenta.setContraseña(password);
                 
            }
            else{
                 throw new LoginException("La Cuenta ya Exixte");

                }
            return cuenta;
        } catch (LoginException e) {
            e.printStackTrace();
            throw new LoginException("Error al pedir la Cuenta", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
    }
}

    

