/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.excepciones.TuSaludException;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class CuentaService {
    
     public Cuenta crearCuenta(String usuario, String password) throws TuSaludException {
        Cuenta cuenta = new Cuenta(usuario, password);
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            session.saveOrUpdate(cuenta);            
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TuSaludException("Error al pedir la Cuenta", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
        
        return cuenta;
    }
}

    

