/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class ConsultaLugar {
    
    public ConsultaLugar(){}
    
    public Lugar getLugar(Integer idLugar) throws BDException{
        Session session = null;
        try{
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            Lugar lugar = (Lugar) session.get(Lugar.class, idLugar);          
            session.getTransaction().commit();
            
            if (lugar == null){
                throw new BDException("No se encontró");
            }
            return lugar;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir el lugar", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
    }
    
    public void guardarLugar(Lugar lugar) throws BDException {
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.saveOrUpdate(lugar);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el lugar", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
    }
    
    public List getListaEspecialidades(Lugar lugar) throws BDException{
        
        if (! lugar.getEspecialidades().isEmpty()){
            return lugar.getEspecialidades();
        }else{
            throw new BDException("La lista de especialidades esta vacia");
        }
    }
    
    public List<Turno> getListaDeTurnosLibres(String especialidad, Integer idLugar) throws BDException{
        List<Turno> turnosLibres = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Turno t WHERE t.especialidad.nombre = :especialidad AND t.lugar.id = :idLugar AND t.libre = true");
            query.setParameter("especialidad", especialidad);
            query.setParameter("idLugar", idLugar);
            turnosLibres = (List<Turno>) query.list();
                        
            if (turnosLibres.isEmpty()){
                throw new BDException("La lista esta vacia");
            }
            
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista de turnos", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return turnosLibres;
    }
    
    public List<Turno> getListaTurnosDePaciente(Integer idPaciente) throws BDException{
        List<Turno> turnosLibres = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Turno t WHERE t.paciente.id = :idPaciente AND t.libre = false AND t.derivacion.aprobado = false ");
            query.setParameter("idPaciente", idPaciente);
            turnosLibres = (List<Turno>) query.list();
                        
            if (turnosLibres.isEmpty()){
                throw new BDException("La lista esta vacia");
            }
            
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista de turnos", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return turnosLibres;
    }
    
    public List<Lugar> getListaDeLugares() {
        List<Lugar> lugares = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Lugar  ");
            lugares = (List<Lugar>) query.list();
                        
            if (lugares.isEmpty()){
                //throw new BDException("La lista esta vacia");
            }
            
        } catch (HibernateException e) {
            e.printStackTrace();
    //        throw new BDException("Error al pedir la lista Lugares", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return lugares;
    }
}
