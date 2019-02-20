/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.ConsultaLugar;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.Dialogo;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class EspecialidadService {
    
    private TuSalud tuSalud;
    private ConsultaLugar consultaLugar = new ConsultaLugar();
    
    public EspecialidadService(TuSalud tuSalud) {
        this.tuSalud = tuSalud;
    }
    
    public void crearAlmanaque(String especialidad) throws BDException{
        try{
            List<Turno> turnosLibres = consultaLugar.getListaDeTurnosLibres(especialidad, tuSalud.getPaciente().getLugarDeAtencion().getId());
            tuSalud.getNavegacion().crearAlmanaque(turnosLibres);
        } catch(BDException e) {
            Dialogo.mostrar("La lista esta vacia", "Mensaje");
            e.printStackTrace();
        }
    }
    
    public void volverAMenu(JFrame ventana){
        tuSalud.getNavegacion().volverAMenu(ventana);
    }
}
