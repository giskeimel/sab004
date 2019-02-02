/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.excepciones.BDException;
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
    
    public Lugar getLugarPorNombre(String nombre) throws BDException{
        try{
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            Query query = session.createQuery("FROM Lugar l WHERE l.nombre = :nombre");
            query.setParameter("nombre", nombre);
            
            Lugar lugar = (Lugar) query.uniqueResult();
            
            session.getTransaction().commit();
            session.close();
            
            if (lugar == null){
                throw new BDException("No se encontró");
            }
            
            return lugar;
        }catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir el lugar", e);
        }
    }
    
    public Lugar getLugar(Integer idLugar) throws BDException{
        try{
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            Lugar lugar = (Lugar) session.get(Lugar.class, idLugar);          
            
            session.getTransaction().commit();
            session.close();
            
            if (lugar == null){
                throw new BDException("No se encontró");
            }
            
            return lugar;
        }catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir el lugar", e);
        }
    }
    
    public void guardarLugar(Lugar lugar) throws BDException {
        try {
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.saveOrUpdate(lugar);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el lugar", e);
        }
    }
    
    public List getListaEspecialidades(Lugar lugar) throws BDException{
        
        if (! lugar.getEspecialidades().isEmpty()){
            return lugar.getEspecialidades();
        }else{
            throw new BDException("La lista de especialidades esta vacia");
        }
    }
    
    public List getListaTurnos(Lugar lugar) throws BDException{
        
        if (! lugar.getTurnos().isEmpty()){
            return lugar.getTurnos();
        }else{
            throw new BDException("La lista de turnos esta vacia");
        }
    }
}