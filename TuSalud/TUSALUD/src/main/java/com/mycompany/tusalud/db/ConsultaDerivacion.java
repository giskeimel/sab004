/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.excepciones.BDException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Alumno
 */
public class ConsultaDerivacion {
    
    public void guardarDerivacionEnBD(Derivacion derivacion) throws BDException {
        Session session = null;
        try {
            session =  HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.saveOrUpdate(derivacion);
            //ver por que me salta al catch
            
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new BDException("Error al guardar la derivación", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
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
}
