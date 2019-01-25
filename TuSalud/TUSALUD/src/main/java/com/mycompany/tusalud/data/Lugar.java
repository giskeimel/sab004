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
public class Lugar {
    
   private Integer idLugar; 
   private String nombre;
   private Direccion direccion; 
   private List<Especialidad> especialidades = new ArrayList<>();
   private List<Turno> turnos = new ArrayList<>();

   
    public Lugar() {
    }
    
    public Integer getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Integer idLugar) {
        this.idLugar = idLugar;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public String toString() {
        return "Lugar{" + "idLugar=" + idLugar + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
}
