/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.init;

import Interfaces.Login2;

/**
 *
 * @author gkeimel
 * Esta va a ser la clase principal desde donde se llama el login y empieza el flujo.
 */
public class MainClass {
        public static void main(String[] args) {
            Login2 login = new Login2();
            login.setVisible(true);
        }
}
