/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.excepciones.BDException;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class LugarService {
    
    public LugarService(){}
    
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

            Query query = session.createQuery("FROM Turno t WHERE t.especialidad.nombre = :especialidad AND t.lugar.id = :idLugar AND t.libre = true order by t.hora asc");
            query.setParameter("especialidad", especialidad);
            query.setParameter("idLugar", idLugar);
            turnosLibres = (List<Turno>) query.list();
            
            session.getTransaction().commit();
            
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
                        
            session.getTransaction().commit();
            
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
    
    public List<Lugar> getListaDeLugares() throws BDException {
        List<Lugar> lugares = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Lugar  ");
            lugares = (List<Lugar>) query.list();
                        
            session.getTransaction().commit();
            
            
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista Lugares", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return lugares;
    }
    public List<Turno> getListaTurnosDeLugarPorNombreYFecha(String nombreLugar,Date fecha) throws BDException{
        List<Turno> turnosDeLugarPorNombre = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Turno t WHERE t.lugar.nombre = :nombreLugar "
                    + "                       AND t.fecha = fecha AND t.libre = false "
                    + "                       order by t.hora,t.paciente.id asc");
            query.setParameter("nombreLugar", nombreLugar);
            query.setParameter("fecha", fecha);
            turnosDeLugarPorNombre = (List<Turno>) query.list();
            
            session.getTransaction().commit();
            
           
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista de turnos", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return turnosDeLugarPorNombre;
    }

    
    public List<Turno> getListaTurnosDeLugarPorNombre(String nombreLugar) throws BDException{
        List<Turno> turnosDeLugarPorNombre = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Turno t WHERE t.lugar.nombre = :nombreLugar AND t.libre = true AND t.derivacion = null order by t.hora,t.especialidad.id asc");
            query.setParameter("nombreLugar", nombreLugar);
            turnosDeLugarPorNombre = (List<Turno>) query.list();
            
            session.getTransaction().commit();
            
            
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista de turnos", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        return turnosDeLugarPorNombre;
    }
}
