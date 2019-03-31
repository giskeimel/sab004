/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Alumno
 */
public class DerivacionService {
    
    public void guardarDerivacionEnBD(Derivacion derivacion) throws BDException {
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.saveOrUpdate(derivacion);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new BDException("Error al guardar la derivación", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
    
    public void eliminarDerivacionEnBD(Derivacion derivacion) throws BDException {
        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.delete(derivacion);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el turno", e);
        } if(session.isOpen()){
            session.close();
        }
    }
    
    public Derivacion getDerivacion(Integer idPaciente, Integer idEspecialidad) throws BDException {
        Derivacion derivacion = null;
        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Derivacion d WHERE d.paciente.id = :idPaciente AND d.especialidad.id = :idEspecialidad");
            query.setParameter("idPaciente", idPaciente);
            query.setParameter("idEspecialidad", idEspecialidad);
            derivacion = (Derivacion) query.uniqueResult();
            
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new BDException("Error al buscar la derivación", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return derivacion;
    }
    
    public List<Derivacion> getDerivacionesDePaciente(Paciente paciente) throws LoginException {
        List<Derivacion> derivaciones = null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Derivacion d WHERE d.paciente.id = :idPaciente ORDER BY d.especialidad.id ASC");
            query.setParameter("idPaciente", paciente.getId());
            derivaciones = query.list();

            session.getTransaction().commit();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return derivaciones;
    }
}
