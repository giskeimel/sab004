/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tusalud.interfaces;

import javax.swing.JOptionPane;

/**
 *
 * @author Nati
 */
public class dialogo {
    
    public static void mostrar(String mensaje,String titulo ){ 
               JOptionPane.showMessageDialog(null,mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
}