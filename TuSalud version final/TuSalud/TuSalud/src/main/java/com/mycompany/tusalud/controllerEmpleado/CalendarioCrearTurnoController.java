/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controllerEmpleado;

import com.mycompany.tusalud.data.Especialidad;
import com.mycompany.tusalud.data.Profesional;
import com.mycompany.tusalud.data.Turno;
import com.mycompany.tusalud.db.EspecialidadService;
import com.mycompany.tusalud.db.LugarService;
import com.mycompany.tusalud.db.ProfesionalService;
import com.mycompany.tusalud.db.TurnoService;
import com.mycompany.tusalud.excepciones.BDException;
import com.mycompany.tusalud.init.TuSalud;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Alumno
 */
public class CalendarioCrearTurnoController {
    
    private final TuSalud tuSalud;
    private final EspecialidadService especialidadService = new EspecialidadService();
    private final TurnoService turnoService = new TurnoService();
    private final LugarService lugarService = new LugarService();
    private final ProfesionalService profesionalService = new ProfesionalService();
    
    public CalendarioCrearTurnoController(TuSalud tuSalud){
        this.tuSalud = tuSalud;
    }
    
    public void crearTurno(LocalDate fechaSeleccionada, JFrame ventanaAnterior) throws BDException{
        List<Especialidad> listaDeEspecialidades = especialidadService.getListaDeEspecialidadesEnDB();
        List<Profesional> listaDeProfesionales = profesionalService.getListaDeProfesionalesDeLugar(tuSalud.getEmpleado().getLugarDesignado().getId());
        tuSalud.getNavegacionEmpleado().crearVistaCrearTurno(listaDeEspecialidades, listaDeProfesionales, fechaSeleccionada, ventanaAnterior);
    }
    
    public void eliminarTurno(Turno turno, JFrame ventana) throws BDException{
        turnoService.eliminarTurnoEnBD(turno);
        List<Turno> lista = lugarService.getListaTurnosDeLugarPorNombre(tuSalud.getEmpleado().getLugarDesignado().getNombre());
        tuSalud.getNavegacionEmpleado().crearCalendarioCrearTurno(lista, ventana);
    }
    
    public void volverAMenu(JFrame ventana){
        tuSalud.getNavegacionEmpleado().volverAMenu(ventana);
    }
}
