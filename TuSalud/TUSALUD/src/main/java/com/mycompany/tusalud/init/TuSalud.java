/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.init;

import com.mycompany.tusalud.HibernateClase.HibernateUtilities;
import com.mycompany.tusalud.controller.Navegacion;
import com.mycompany.tusalud.data.Empleado;
import com.mycompany.tusalud.data.Paciente;
import com.mycompany.tusalud.data.Persona;
import com.mycompany.tusalud.excepciones.TuSaludException;

/**
 *
 * @author gkeimel Esta va a ser la clase principal desde donde se llama el
 * login y empieza el flujo.
 */
public class TuSalud {

    private Navegacion navegacion;

    private Persona personaLogueada = null;

    public TuSalud() {
        navegacion = new Navegacion(this);
    }

    public Empleado getEmpleado() {
        if (personaLogueada == null) {
            return null;
        } 

        if (this.personaLogueada instanceof Empleado) {
            return (Empleado) personaLogueada;
        } else 
            return null;
    }
    
    public Paciente getPaciente() {
        if (personaLogueada == null) {
            return null;
        } 

        if (this.personaLogueada instanceof Paciente) {
            return (Paciente) personaLogueada;
        } else 
            return null;
    }

    public Persona getPersonaLogueada() {
        return personaLogueada;
    }

    public void setPersonaLogueada(Persona personaLogueada) {
        this.personaLogueada = personaLogueada;
    }

    public void inicializar() {
        try {
            HibernateUtilities.inicializar();
        } catch (TuSaludException ex) {
            ex.printStackTrace();
            //Mostrar el error.
            System.exit(0);
        }
    }

    public void ejecutar() {
        navegacion.crearLogin();
    }

    public void cerrar() {
        HibernateUtilities.cerrarSessionFactory();
    }

    public Navegacion getNavegacion() {
        return navegacion;
    }
}
