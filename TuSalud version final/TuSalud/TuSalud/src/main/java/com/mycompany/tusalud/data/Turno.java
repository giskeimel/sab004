/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.data;

import java.sql.Time;
import java.util.Date;

/**
 * * @author Nati
 */
public class Turno {
    
    private Integer id; 
    private Date fecha;
    private Time hora;
    private boolean libre;
    private Lugar lugar;
    private Especialidad especialidad;
    private Paciente paciente;
    private Derivacion derivacion;
    private Profesional profesional;
    private boolean alta;
    
    public Turno(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
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
    
    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return hora.toString() ;
    }
}
