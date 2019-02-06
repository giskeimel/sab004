/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.Exceptiones;

/**
 *
 * @author Nati
 */
public class BDException extends Exception {
    public BDException() {}
    
    public BDException(String mensaje) {
        super(mensaje);
    }   
    
    public BDException(String mensaje, Exception e) {
        super(mensaje, e);
    }   
}


