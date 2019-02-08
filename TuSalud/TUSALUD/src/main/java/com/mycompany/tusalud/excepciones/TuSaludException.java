/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.excepciones;

/**
 *
 * @author User
 */
public class TuSaludException extends Exception {
    
    public TuSaludException() {}
    
    public TuSaludException(String mensaje) {
        super(mensaje);
    }    
    
    public TuSaludException(String mensaje, Exception e) {
        super(mensaje, e);
    }    
}