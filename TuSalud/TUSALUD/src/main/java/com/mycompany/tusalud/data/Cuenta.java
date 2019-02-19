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
public class Cuenta {

    private Integer idCuenta = null;
    private String usuario;
    private String contraseña;

    public Cuenta() {
    }

    public Cuenta(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }
    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
}
