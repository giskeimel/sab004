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
public class Persona {
    
  private Integer id;
  private String nombre;
  private String apellido;
  private long telefono;
  private String email;
  private Direccion direccion;
  private Lugar lugarDesignado;

    public Persona() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer idPersona) {
        this.id = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Lugar getLugarDesignado() {
        return lugarDesignado;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setLugarDesignado(Lugar lugarDeAtencion) {
        this.lugarDesignado = lugarDeAtencion;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + '}';
    }
}
