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
public class Empleado extends Persona{
   
   private Integer legajoEmpleado;
   private Cuenta cuenta;
   private Lugar lugarDesignado;

    public Empleado() {
        super();
    }

    public int getLegajoEmpleado() {
        return legajoEmpleado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

   
    public Lugar getLugarDesignado() {
        return lugarDesignado;
    }

    public void setLegajoEmpleado(int legajoEmpleado) {
        this.legajoEmpleado = legajoEmpleado;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

   
    public void setLugarDesignado(Lugar lugarDesignado) {
        this.lugarDesignado = lugarDesignado;
    }
    
    @Override
    public String toString() {
        return super.toString()+ "" + "Empleado{" + "legajoEmpleado=" + legajoEmpleado + ", cuenta=" + cuenta + ", lugarDesignado=" + lugarDesignado + '}';
    }
}
