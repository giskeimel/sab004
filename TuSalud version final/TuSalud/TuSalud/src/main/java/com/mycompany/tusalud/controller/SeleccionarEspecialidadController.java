/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.MiDialogo;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class SeleccionarEspecialidadController {
    
    private final TuSalud tuSalud;
    private final LugarService lugarService = new LugarService();
    
    public SeleccionarEspecialidadController(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void crearAlmanaque(String especialidad) throws BDException{
        try{
            List<Turno> turnosLibres = lugarService.getListaDeTurnosLibres(especialidad, tuSalud.getPaciente().getLugarDesignado().getId());
            tuSalud.getNavegacionPaciente().crearAlmanaque(turnosLibres);
        } catch(BDException e) {
            MiDialogo.mostrar("La lista esta vacia", "Mensaje");
            e.printStackTrace();
        }
    }
    
    public void volverAMenu(JFrame ventana){
        tuSalud.getNavegacionPaciente().volverAMenu(ventana);
    }
}
