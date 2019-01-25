/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.data;

import java.util.Date;

/**
 * * @author Nati
 */
public class Turno {
    
    private Integer idTurno; 
    private Date fecha;
    private boolean libre;
    private Lugar lugar;
    private Especialidad especialidad;
    private Paciente paciente;
  
    public Turno(){
        
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Integer idTurno) {
        this.idTurno = idTurno;
    }

    
    public Date getFecha() {
        return fecha;
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

    public void setFecha(Date fecha) {
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
  
    @Override
    public String toString() {
        return "Turno{" + "fecha=" + fecha + ", libre=" + libre + ", lugar=" + lugar + ", especialidad=" + especialidad + ", paciente=" + paciente + '}';
    }  
}
