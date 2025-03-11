/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import views.ViewBienvenida;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewBienvenidaService {
    
    public String bienvenida() {
        ViewBienvenida bienvenida = new ViewBienvenida();
        String selection = bienvenida.bienvenida();
        if (selection == null) {
            return "salida";
        }
        switch (selection) {
            case "Cerrar":
                return "salida";
            case "Iniciar sesión":
                return "Login_pideNombreUsuario";
            case "Registrarse":
                return "Register_pideNombreUsuario";
            default:
                throw new Error("No hay una ruta establecida para seleccion \""
                        + selection + "\"");
        }
    }
}
