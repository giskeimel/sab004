/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.ConsultaTurno;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class CancelarTurnosService {
    
    private final TuSalud tuSalud;
    private ConsultaTurno consultaTurno = new ConsultaTurno();
    
    public CancelarTurnosService(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void cancelarTurno(Turno turno) throws BDException{
        try{
            consultaTurno.cancelarTurno(turno);
        }catch(BDException ex) {
            ex.printStackTrace();
        }
    }
    
    public void volverAMenu(JFrame ventana){
        tuSalud.getNavegacion().volverAMenu(ventana);
    }
}