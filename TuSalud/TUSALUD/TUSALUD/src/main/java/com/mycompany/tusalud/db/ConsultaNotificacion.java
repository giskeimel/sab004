/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Alumno
 */
public class ConsultaNotificacion {
    
    public List<Object[]> getNotificacion(Integer idPaciente, Integer idLugar) throws HibernateException{
        Session session = null;
        List<Object[]> lista =  new ArrayList<>();
        LocalDate fechaDeHoy = LocalDate.now();
        
        try{
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            Query query = session.createSQLQuery("SELECT id,fechaVigenciaInicial,fechaVigenciaFinal,texto FROM notificacion WHERE (((id_lugar is null) AND (id_paciente is null)) OR ((id_lugar = :idLugar) AND (id_paciente is null)) OR ((id_paciente = :idPaciente) AND (id_lugar is null))) AND (:fechaDeHoy BETWEEN fechaVigenciaInicial AND fechaVigenciaFinal) AND (mostrar = true) ORDER BY id DESC");
            query.setParameter("idPaciente", idPaciente);
            query.setParameter("idLugar", idLugar);
            query.setParameter("fechaDeHoy", fechaDeHoy.toString());
            
            lista = (List<Object[]>) query.list();
            
            session.getTransaction().commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
        } if(session.isOpen()){
            session.close();
        }
        return lista;
    }
}
