/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.tusalud.db;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Cuenta;
import com.mycompany.tusalud.data.Direccion;
import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Lugar;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.excepciones.TuSaludException;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class EmpleadoService {
    
    public Empleado crearEmpleado(Cuenta cuenta,String nombre,String apellido,long telefono,
                                  String email, Direccion direccion,int  legajoEmpleado,
                                  Lugar lugarDesignado)throws LoginException, TuSaludException {
       
        
        
        Empleado empleado = null;
        empleado = new Empleado();
        empleado.setApellido(apellido);
        empleado.setCuenta(cuenta);
        empleado.setDireccion(direccion);
        empleado.setEmail(email);
        empleado.setLegajoEmpleado(legajoEmpleado);
        empleado.setLugarDesignado(lugarDesignado);
        empleado.setNombre(nombre);
        empleado.setTelefono(telefono);

        Session session = null;
        
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();
            session.saveOrUpdate(empleado);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new TuSaludException("Error al pedir la Cuenta", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }

        return empleado;
    }

    
}

   
