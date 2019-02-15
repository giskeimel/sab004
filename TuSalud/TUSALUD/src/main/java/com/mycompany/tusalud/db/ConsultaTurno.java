/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import org.hibernate.HibernateException;
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
        try {
            turno.setLibre(true);
            turno.setPaciente(null);
            guardarTurno(turno);
        } catch (BDException e) {
            e.printStackTrace();
            throw new BDException("Error al cancelar el turno", e);
        }
    }

    public void guardarTurno(Turno turno) throws BDException {
        //validaciones
        
        try {
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
            session.saveOrUpdate(turno);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el turno", e);
        }
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
