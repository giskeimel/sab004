/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.data.Turno;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author User
 */
public class ConsultaListaDeTurnos {
    
    public ConsultaListaDeTurnos(){
        try{
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            Query query = session.createQuery("SELECT t.id_Lugar FROM Turno t");
            Lugar l = new Lugar();
            
            List<Turno> listaTurnos = l.getTurnos();
            listaTurnos = query.list();
            
            for (Turno t : listaTurnos) {
                System.out.println(t.toString());
                System.out.println("");
            }
            
            session.getTransaction().commit();
            session.close();
            HibernateUtilities.cerrarSessionFactory();
        }
        catch (HibernateException e) {
            System.out.println("Fallo");
            e.printStackTrace();
        }
    }
}
