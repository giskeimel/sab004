/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.consultaturno;
import com.mycompany.tusalud.db.ConsultaLugar;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;

/**
 *
 * @author Alumno
 */
public class AlmanaqueService {
    private consultaturno consultaTurno;
    private final TuSalud tuSalud;
    
    public AlmanaqueService(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void guardarTurno(Turno turno) throws BDException{
        
        try{
            turno.setPaciente(tuSalud.getPaciente());
            consultaTurno.guardarTurno(turno);
        }catch(BDException ex) {
            ex.printStackTrace();
        }
    }
}
