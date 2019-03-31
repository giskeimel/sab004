/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.TuSaludException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class DireccionService {

    public void guardarDireccionEnBD(Direccion direccion) throws BDException {
        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            
            session.saveOrUpdate(direccion);
            
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al guardar el paciente", e);
        } if(session.isOpen()){
            session.close();
        }
    }
    
    public Direccion crearDireccion(String calle, Integer numero, Integer piso, String departamento) throws TuSaludException {

        Direccion direccion = new Direccion();
        direccion.setCalle(calle);
        direccion.setNumero(numero);
        direccion.setPiso(piso);
        direccion.setDepartamento(departamento);

        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            session.saveOrUpdate(direccion);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TuSaludException("Error al guardar la dirección", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return direccion;
    }

}
