/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Profesional;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.db.TurnoService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class CrearTurnoController {
    
    private final TuSalud tuSalud;
    private final TurnoService turnoService = new TurnoService();
    private final LugarService lugarService = new LugarService();
    
    public CrearTurnoController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void guardarTurno(Especialidad especialidad, Date fecha, Time hora, Profesional profesional) throws BDException{
        Turno turno = new Turno();
        
        try{
            turno.setEspecialidad(especialidad);
            turno.setFecha(fecha);
            turno.setHora(hora);
            turno.setProfesional(profesional);
            turno.setLugar(tuSalud.getEmpleado().getLugarDesignado());
            turno.setDerivacion(null);
            turno.setLibre(true);
            turno.setPaciente(null);
            
            turnoService.guardarTurnoEnBD(turno);
        }catch(BDException ex) {
            ex.printStackTrace();
        }
    }
    
    public void volverACargarCalendario(JFrame ventana) throws BDException{
        List<Turno> lista = lugarService.getListaTurnosDeLugarPorNombre(tuSalud.getEmpleado().getLugarDesignado().getNombre());
        tuSalud.getNavegacionEmpleado().crearCalendarioCrearTurno(lista, ventana);
    }
}
