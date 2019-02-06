/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.init;

import com.mycompany.tusalud.controller.Navegacion;
import com.mycompany.tusalud.data.Paciente;

/**
 *
 * @author gkeimel
 * Esta va a ser la clase principal desde donde se llama el login y empieza el flujo.
 */
public class MainClass {
    public static Navegacion navegacion  = new Navegacion();
    
    public Paciente paciente;
        public static void main(String[] args) {
            navegacion.crearLogin();
        }
}
