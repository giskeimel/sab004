/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.init;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.*;
import com.mycompany.tusalud.controladores.ControladorLogin;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.mycompany.tusalud.Exceptiones.BDException;
import org.hibernate.HibernateException;

/**
 *
 * @author Nati
 */
public class TestTuSalud {

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        // TODO code application logic here
        try{
            Session session = HibernateUtilities.getSession();
            session.beginTransaction();

            Empleado e = (Empleado) session.get(Empleado.class, 1);
            System.out.println("");
            System.out.println(e);

            session.getTransaction().commit();
            session.close();
            HibernateUtilities.cerrarSessionFactory();
        }
        catch(HibernateException e){
            System.out.println("");
            e.printStackTrace();
        }
        System.exit(0);
    }*/

    public static void main(String[] args) throws BDException{
        // TODO code application logic here
        
        String usuario="Manuel";
        String contraseña="Manuel";
                
        ControladorLogin controlador = new ControladorLogin();
        boolean usuarioCorrecto = controlador.login(usuario, contraseña);
        System.out.print("el usuario es:"+usuarioCorrecto);
    }
}
