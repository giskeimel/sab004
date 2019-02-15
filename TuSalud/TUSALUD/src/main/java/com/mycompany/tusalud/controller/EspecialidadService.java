/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.controller;

import com.mycompany.tusalud.db.ConsultaLugar;
import com.mycompany.tusalud.init.TuSalud;

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
    
     
    
}
