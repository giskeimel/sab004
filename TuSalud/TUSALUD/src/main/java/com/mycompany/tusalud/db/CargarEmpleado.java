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
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nati
 */
public class CargarEmpleado {
    
    public Empleado crearEmpleado(Cuenta cuenta,String nombre,String apellido,long telefono,
                                  String email, Direccion direccion,int  legajoEmpleado,
                                  Lugar lugarDesignado)throws LoginException {
        Empleado empleado = null;
        Session session = null;
        try {
            session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Empleado e WHERE e.legajoEmpleado = :legajoEmpleado ");
            query.setParameter("legajoEmpleado", legajoEmpleado);
            empleado =(Empleado) query.uniqueResult();             
            session.getTransaction().commit();
                        
            if (empleado == null) {
                empleado.setApellido(apellido);
                empleado.setCuenta(cuenta);
                empleado.setDireccion(direccion);
                empleado.setEmail(email);
                empleado.setLegajoEmpleado(legajoEmpleado);
                empleado.setId(Integer.SIZE);
                empleado.setLugarDesignado(lugarDesignado);
                empleado.setNombre(nombre);
                empleado.setTelefono(telefono);
            }
            else{
                 throw new LoginException("El Empleado ya Exixte");

                }
            return empleado;
        } catch (LoginException e) {
            e.printStackTrace();
            throw new LoginException("Error al pedir la Cuenta", e);
        } finally {
            if (session.isOpen())
                session.close();
        }
    }

    
}

   
