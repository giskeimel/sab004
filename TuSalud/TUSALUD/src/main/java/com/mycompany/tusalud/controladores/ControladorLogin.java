/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controladores;

/**
 *
 * @author Nati
 */
import com.mycompany.tusalud.data.Cuenta;
import org.hibernate.Session;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import com.mycompany.tusalud.Exceptiones.BDException;
import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import org.hibernate.HibernateException;


public class ControladorLogin { 
   
    
    public boolean login(String usuario,String contraseña)throws BDException{
        Cuenta cuenta = obtenerCuentaPorNombreDeUsuario(usuario);
       if ((cuenta!=null) & (usuario.equals(cuenta.getUsuario())))
           if (contraseña.equals(cuenta.getContraseña())){
               JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado "
               + "satisfactoriamente al sistema", "Mensaje de bienvenida",
               JOptionPane.INFORMATION_MESSAGE);

               return true;
           }
           else {
               JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
               JOptionPane.ERROR_MESSAGE);
               return false;
           }
       else {
           JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
           + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
           JOptionPane.ERROR_MESSAGE);
           return false;
       }
    }
   
    public boolean CrearCuenta(String usuario,String contraceña)throws BDException{
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Cuenta cuentaNueva= new Cuenta();
        boolean var=false;
        if (obtenerCuentaPorNombreDeUsuario(usuario) == null){
            //agregar
            cuentaNueva.setUsuario(usuario);
            cuentaNueva.setContraseña(contraceña);
            
            session.saveOrUpdate(cuentaNueva);
            
            JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado "
            + "satisfactoriamente al sistema", "Mensaje de bienvenida",
            JOptionPane.INFORMATION_MESSAGE);
            var= true;
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
            + "Su usuario ya existe ", "Acceso denegado",
            JOptionPane.ERROR_MESSAGE);
           
            
        }
        session.getTransaction().commit();
        session.close();            
        return var;    
    }
    public boolean removerCuenta(String usuario,String contraceña)throws BDException{
    
        Session session = HibernateUtilities.getSession();
        session.beginTransaction();
        Cuenta cuenta = obtenerCuentaPorNombreDeUsuario(usuario);
        boolean var=false;    
        if (cuenta != null){
            //remover
            session.delete(cuenta);
            var= true;
        }
        else{
             JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
            + " Cuenta inexistente ", "Acceso denegado",
            JOptionPane.ERROR_MESSAGE);
           
        }
            
            session.getTransaction().commit();
            session.close();            
            return var;
    }
    public Cuenta obtenerCuentaPotId(int id) {
        //PK = 1
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();
            Cuenta cuenta = (Cuenta) session.get(Cuenta.class,id);
            session.getTransaction().commit();
            session.close();            
            
            if (cuenta != null)
                return cuenta;
            else
                return null;
                
         }
    
    public Cuenta obtenerCuentaPorNombreDeUsuario(String usuario) throws BDException  {
        try {
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Cuenta c WHERE c.usuario=:usuario");
            query.setParameter("usuario", usuario);
            Cuenta cuenta = (Cuenta) query.uniqueResult();

            session.getTransaction().commit();
            session.close();

            if (cuenta == null) {
                 throw new BDException("Cuenta Inexistente");
            }
            return cuenta;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new BDException("Error al pedir la Cuenta", e);
        }
    }
}
