/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package views;

import javax.swing.*;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class ViewBienvenida {
    
    public static String iniciarBienvenida() {
        String[] options = { "Cerrar", "Iniciar sesión", "Registrarse" };
        String message = "Bienvenido al sistema de gestión de cine. Por favor eliga una opción:";
        
        return (String) JOptionPane.showInputDialog(null,
             message, "Bienvenida",
             JOptionPane.INFORMATION_MESSAGE, null,
             options, options[0]);
    }
}
