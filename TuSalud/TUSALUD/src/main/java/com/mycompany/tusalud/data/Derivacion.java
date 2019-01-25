/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.data;

import java.util.Date;

/**
 *
 * @author Nati
 */
public class Derivacion {
    
   private Integer idDerivacion;
   private Date fecha;
   private Boolean aprobado;
   private Especialidad especialidad;
   private Paciente paciente;

    public Derivacion() {
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Integer getIdDerivacion() {
        return idDerivacion;
    }

    public void setIdDerivacion(Integer idDerivacion) {
        this.idDerivacion = idDerivacion;
    }

    @Override
    public String toString() {
        return "Derivacion{" + "idDerivacion=" + idDerivacion + ", fecha=" + fecha + ", aprobado=" + aprobado + ", especialidad=" + especialidad + ", paciente=" + paciente + '}';
    }
}
