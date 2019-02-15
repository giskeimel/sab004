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
public class LoginException extends TuSaludException {
    
    public LoginException() {}
    
    public LoginException(String mensaje) {
        super(mensaje);
    }    
    
    public LoginException(String mensaje, Exception e) {
        super(mensaje, e);
    }    
}
