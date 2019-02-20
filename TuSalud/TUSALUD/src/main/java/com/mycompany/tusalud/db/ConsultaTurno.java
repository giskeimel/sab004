/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class ConsultaTurno {

    /**
     * 
     * @param turno
     * @throws BDException 
     */
    public void cancelarTurno(Turno turno) throws BDException {
        Session session = null;
        Derivacion derivacion = getDerivacion(turno.getPaciente().getId(), turno.getEspecialidad().getId());
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            turno.setLibre(true);
            turno.setPaciente(null);
            turno.setDerivacion(null);
            
            derivacion.setAprobado(true);
            
            session.saveOrUpdate(turno);
            
            session.saveOrUpdate(derivacion);
            
        session.getTransaction().commit();
        } catch (Exception e) {
            throw new BDException("Error al Cancelar el turno", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public void asociarTurnoaPaciente(Turno turno) throws BDException {
        //validaciones
        
        Derivacion derivacion = getDerivacion(turno.getPaciente().getId(), turno.getEspecialidad().getId());
        
        try {
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
           
            derivacion.setAprobado(false);
            
            turno.setDerivacion(derivacion);
            
            session.saveOrUpdate(turno);
            
            session.saveOrUpdate(derivacion);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el turno", e);
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
        
    public Turno getTurno(Integer idTurno) throws BDException {
        
        try {
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
            Turno turno = (Turno) session.get(Turno.class, idTurno);
            session.getTransaction().commit();
            session.close();
            
            if (turno == null)
                throw new BDException("No se encontró");
            
            return turno;
        } catch (BDException | HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el turno", e);
        }
    }
}
