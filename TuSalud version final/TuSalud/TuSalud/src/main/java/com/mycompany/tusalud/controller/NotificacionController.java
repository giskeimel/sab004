/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.MiDialogo;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class NotificacionController {

    private final TuSalud tuSalud;
    
    public NotificacionController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void mostrarMensaje(String mensaje){
        MiDialogo.mostrar(mensaje, "Notificacion");
    }
    
    public void volverAMenu(JFrame ventana){
        tuSalud.getNavegacionPaciente().volverAMenu(ventana);
    }
}
