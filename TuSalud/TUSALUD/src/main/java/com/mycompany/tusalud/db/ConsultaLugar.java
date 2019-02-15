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
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class ConsultaLugar {
    
    public ConsultaLugar(){}
    
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
        } catch (HibernateException e) {
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
    
    public List<Turno> getListaDeTurnosLibres(String especialidad, List<Turno> lista) throws BDException{
        try{
            List<Turno> turnosLibres = new ArrayList<>();
        
            for(Turno objeto: lista){
                if((objeto.getPaciente() == null) && (objeto.getEspecialidad().getNombre().equalsIgnoreCase(especialidad))){
                    turnosLibres.add(objeto);
                }
            }
            
            if (turnosLibres.isEmpty()){
                throw new BDException("La lista esta vacia");
            }
            
            return turnosLibres;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista de turnos", e);
        }
    }
    
    public List<Turno> getListaTurnosDePaciente(Paciente paciente,List<Turno> lista) throws BDException{
        try{
            List<Turno> turnosACancelar = new ArrayList<>();
        
            for(Turno objeto: lista){
                if ((objeto.getPaciente() != null) && (objeto.getPaciente().getId().equals(paciente.getId()))) {
                    turnosACancelar.add(objeto);
                }
            }
            
            if (turnosACancelar.isEmpty()){
                throw new BDException("La lista esta vacia");
            }
            
            return turnosACancelar;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la lista de turnos", e);
        }
    }
}
