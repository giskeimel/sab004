/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Profesional;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Alumno
 */
public class ProfesionalService {
    
    public List<Profesional> getListaDeProfesionalesDeLugar(Integer idLugar) {
        List<Profesional> profesionales = null;
        
        Session session = null;
        try{
            
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Profesional p WHERE p.lugarDesignado.id = :idLugar order by p.especialidad.id asc");
            query.setParameter("idLugar", idLugar);
            
            profesionales = (List<Profesional>) query.list();
            
            if (profesionales.isEmpty()){
                MiDialogo.mostrar("La lista de profesionales esta vacia", "Mensaje");
            }
            
        } catch (HibernateException e) {
            e.printStackTrace();
            MiDialogo.mostrar(e, "Error lista de profesionales");
        } finally {
            if (session.isOpen())
                session.close();
        }
        return profesionales;
    }
}
