/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nati
 */
public class Paciente extends Persona  {
    
   private int historia_clinica;
   private Cuenta cuenta;
   private String observaciones;
   private List<Paciente> personasACargo = new ArrayList<>();
   
    public Paciente() {
        super();
    }
   
    public void setHistoria_clinica(int historia_clinica) {
        this.historia_clinica = historia_clinica;
    }

    

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getHistoria_clinica() {
        return historia_clinica;
    }
    
    
    public Cuenta getCuenta() {
        return cuenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public List<Paciente> getPersonasACargo() {
        return personasACargo;
    }

    public void setPersonasACargo(List<Paciente> personasACargo) {
        this.personasACargo = personasACargo;
    }

    @Override
    public String toString() {
        return super.toString() + "" + "Paciente{" + "historia_clinica=" + historia_clinica + ", cuenta=" + cuenta + ", observaciones=" + observaciones + ", personasACargo=" + personasACargo + '}';
    }
}
