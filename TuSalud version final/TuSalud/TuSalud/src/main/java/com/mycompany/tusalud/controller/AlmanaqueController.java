/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.DerivacionService;
import com.mycompany.tusalud.db.TurnoService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class AlmanaqueController {
    
    private final TurnoService turnoService = new TurnoService();
    private final DerivacionService derivacionService = new DerivacionService();
    private final TuSalud tuSalud;
    
    public AlmanaqueController(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void guardarTurno(Turno turno) throws BDException{
        try{
            Derivacion derivacion = derivacionService.getDerivacion(tuSalud.getPaciente().getId(), turno.getEspecialidad().getId());
            
            derivacion.setAprobado(false);
            derivacionService.guardarDerivacionEnBD(derivacion);
            
            turno.setDerivacion(derivacion);
            turno.setLibre(false);
            turno.setPaciente(tuSalud.getPaciente());
            turnoService.guardarTurnoEnBD(turno);
        }catch(BDException ex) {
            ex.printStackTrace();
        }
    }
    
    public void volverAMenu(JFrame ventana){
        tuSalud.getNavegacionPaciente().volverAMenu(ventana);
    }
}
