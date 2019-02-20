/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.ConsultaEspecialidad;
import com.mycompany.tusalud.db.ConsultaLugar;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.excepciones.LoginException;
import com.mycompany.tusalud.init.TuSalud;
import com.mycompany.tusalud.interfaces.Dialogo;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class MenuService {
    
    private ConsultaEspecialidad consultaEspecialidad = new ConsultaEspecialidad();
    private ConsultaLugar consultaLugar = new ConsultaLugar();
    private final TuSalud tuSalud;
    
    public MenuService(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void crearSeleccionEspecialidad() throws LoginException {
        try{
            List<Especialidad> lista = consultaEspecialidad.consultarEspecialidadAp(tuSalud.getPaciente());
            tuSalud.getNavegacion().crearSeleccionEspecialidad(lista);
        } catch(LoginException e) {
            Dialogo.mostrar("La lista esta vacia", "Mensaje");
            e.printStackTrace();
        }
    }    
    
    public void crearCancelarTurnos() throws BDException{
        try{
            List<Turno> turnosACancelar = consultaLugar.getListaTurnosDePaciente(tuSalud.getPaciente().getId());
            tuSalud.getNavegacion().crearCancelarTurnos(turnosACancelar);
        } catch(BDException e) {
            Dialogo.mostrar("La lista esta vacia", "Mensaje");
            e.printStackTrace();
        }
    }
    
    public void cerrarSesion(){
        tuSalud.getNavegacion().cerrarSesion();
    }
}
