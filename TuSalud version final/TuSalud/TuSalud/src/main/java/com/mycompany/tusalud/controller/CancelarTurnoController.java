/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Derivacion;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.DerivacionService;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.db.TurnoService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class CancelarTurnoController {
    
    private final TuSalud tuSalud;
    private final TurnoService turnoService = new TurnoService();
    private final DerivacionService derivacionService = new DerivacionService();
    private final LugarService lugarService = new LugarService();
    
    public CancelarTurnoController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void cancelarTurno(Turno turno, JFrame ventanaAnterior) throws BDException{
        try{
            Derivacion derivacion = derivacionService.getDerivacion(tuSalud.getPaciente().getId(), turno.getEspecialidad().getId());
            
            derivacion.setAprobado(true);
            derivacionService.guardarDerivacionEnBD(derivacion);
            
            turno.setDerivacion(null);
            turno.setLibre(true);
            turno.setPaciente(null);
            turnoService.guardarTurnoEnBD(turno);
            
            MiDialogo.mostrar("El Turno se ha eliminado con exito", "Notificacion");
            
            volverACancelarTurno(ventanaAnterior);
        }catch(BDException ex) {
            MiDialogo.mostrar(ex, "Error");
        }
    }
    
    public void volverACancelarTurno(JFrame ventanaAnterior){
        try{
            List<Turno> turnosACancelar = lugarService.getListaTurnosDePaciente(tuSalud.getPaciente().getId());
            if(turnosACancelar == null){
                throw new BDException("La lista esta vacia");
            }
            tuSalud.getNavegacionPaciente().crearCancelarTurnos(turnosACancelar, ventanaAnterior);
        } catch(BDException e) {
            tuSalud.getNavegacionPaciente().volverAMenu(ventanaAnterior);
        }
    }
    
    public void volverAMenu(JFrame ventana){
        tuSalud.getNavegacionPaciente().volverAMenu(ventana);
    }
}
