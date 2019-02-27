/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * * @author Nati
 */
public class Turno {
    
    private Integer id; 
    private Timestamp fecha;
    private boolean libre;
    private Lugar lugar;
    private Especialidad especialidad;
    private Paciente paciente;
    private Derivacion derivacion;
    
    public Turno(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }
    
    public LocalTime getHora(){
        return fecha.toLocalDateTime().toLocalTime();
    }
    
    public boolean isLibre() {
        return libre;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Derivacion getDerivacion() {
        return derivacion;
    }

    public void setDerivacion(Derivacion derivacion) {
        this.derivacion = derivacion;
    }

    @Override
    public String toString() {
        return getHora().toString() ;
    }  
}
