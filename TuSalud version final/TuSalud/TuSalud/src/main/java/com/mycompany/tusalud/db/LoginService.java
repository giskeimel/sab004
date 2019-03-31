/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Persona;
import com.mycompany.tusalud.excepciones.LoginException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gkeimel
 */
public class LoginService {
    
    public Persona login(String usuario, String password) throws LoginException {
        Persona persona = null;
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
                 throw new LoginException("Cuenta Inexistente");
            }
            
            return persona;
        } catch (LoginException e) {
            e.printStackTrace();
            throw new LoginException("Error al pedir la Cuenta", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
    }
}
