/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import controllers.ViewBienvenidaController;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class Main {
    public static void main(String[] args) {
        iniciar();
    }
    
    private static void iniciar() {
        ViewBienvenidaController controller = new ViewBienvenidaController();
        String selection = controller.iniciarBienvenida();
        if (selection == null) {
            System.exit(0);
        }
        switch (selection) {
            case "Cerrar":
                System.exit(0);
                break;
            case "Iniciar sesión":
                // Hacer un ViewLoginController y usarlo para llamar al ViewLogin
                break;
            case "Registrarse":
                // Hacer un VIewRegisterController y usarlo para llamar al ViewRegister
                break;
            default:
                throw new Error("Opcion \"" + selection + "\" seleccionada");
        }
    }
}
