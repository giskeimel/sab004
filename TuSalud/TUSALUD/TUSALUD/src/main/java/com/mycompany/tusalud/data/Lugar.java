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
    
   private Integer id; 
   private String nombre;
   private Direccion direccion; 
   private List<Especialidad> especialidades;
   private List<Turno> turnos;

   
    public Lugar() {
        especialidades = new ArrayList<>();
        turnos = new ArrayList<>();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "Lugar{" + "idLugar=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
}
