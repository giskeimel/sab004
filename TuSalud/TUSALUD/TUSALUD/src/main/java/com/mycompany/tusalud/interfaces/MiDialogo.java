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
public class MiDialogo {
    
    public static void mostrar(String mensaje, String titulo){ 
        JOptionPane.showMessageDialog(null,mensaje,titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void mostrar(Exception e, String titulo){ 
        StringBuilder sb = new StringBuilder();
        sb.append(e.getMessage());
        sb.append("\n");        
        if (e.getCause() != null) {
            sb.append(e.getCause().getMessage());    
        }        
        JOptionPane.showMessageDialog(null,sb.toString(), titulo, JOptionPane.ERROR_MESSAGE);
    }
}