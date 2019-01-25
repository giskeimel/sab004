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
public class Direccion {
    
    private Integer idDireccion;
    private Integer numero;
    private String calle;
    private Integer piso;
    private String departamento;

    public Direccion() {
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getNumero() {
        return numero;
    }

    public String getCalle() {
        return calle;
    }

    public int getPiso() {
        return piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idDireccion=" + idDireccion + ", numero=" + numero + ", calle=" + calle + ", piso=" + piso + ", departamento=" + departamento + '}';
    }
}
