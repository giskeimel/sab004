/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.data;


/**
 *
 * @author Nati
 */
public class Profesional extends Persona {
    
    private Especialidad especialidad;

    public Profesional() {
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + "" + "Profesional{" + ", especialidad=" + especialidad + '}';
    }
}
