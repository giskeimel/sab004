/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.db;


import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.data.Paciente;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class ConsultaTurno {

    private Date fecha;

    public int asignarTurno(Turno turno, Paciente paciente) {

        SessionFactory factory;
        int seleccionado;

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (final HibernateException a1) {

            System.out.println("Ocurrio un error en la inicializacion de la SessionFactory: " + a1);
            throw new ExceptionInInitializerError(a1);
        }

        final Session session = factory.openSession();

        Transaction transaction = null;

        transaction = session.beginTransaction();

        turno.setFecha(fecha);       
        turno.setPaciente(paciente);

        try {
            session.save(turno);
            seleccionado = 1;
            System.out.println("Turno Ingresado con Exito");
            return seleccionado;
        } catch (final Exception e) {
            System.out.println(e.getMessage());
            seleccionado = 0;
            return seleccionado;
        }
    }

}

