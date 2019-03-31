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
public class TurnoService {

    public void guardarTurnoEnBD(Turno turno) throws BDException {
        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.saveOrUpdate(turno);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el turno", e);
        } if(session.isOpen()){
            session.close();
        }
    }
       
    public void eliminarTurnoEnBD(Turno turno) throws BDException {
        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.delete(turno);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el turno", e);
        } if(session.isOpen()){
            session.close();
        }
    }
    
    public Turno getTurno(Integer idTurno) throws BDException {
        Session session = null;
        Turno turno;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            turno = (Turno) session.get(Turno.class, idTurno);
            
            session.getTransaction().commit();
            
            if (turno == null)
                throw new BDException("No se encontró");
        } catch (BDException | HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el turno", e);
        } if(session.isOpen()){
            session.close();
        }
        return turno;
    }
}
