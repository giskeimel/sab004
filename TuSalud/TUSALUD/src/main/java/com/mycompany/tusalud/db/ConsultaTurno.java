/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;



import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.data.Paciente;
import java.util.Date;
import org.hibernate.Session;





public class ConsultaTurno {

    private Date fecha;

    public void asignarTurno(Turno turno, Paciente paciente) throws Exception {

          Session session = HibernateUtilities.getSession();
            session.beginTransaction();

        turno.setFecha(fecha);       
        turno.setPaciente(paciente);

        try {
            
            session.save(turno);
            System.out.println("Turno Ingresado con Exito");
           
        } catch (final Exception e) {  
         
        }

    }

 
}

