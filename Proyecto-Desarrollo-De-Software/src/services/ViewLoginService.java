/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package services;

import controllers.ViewLoginController;
import views.ViewLogin;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewLoginService {
    
    public Object[] pideNombreUsuario() {
        ViewLogin login = new ViewLogin();
        String input = login.pideNombreUsuario();
        
        if (input == null) {
            return new Object[]{"Bienvenida_bienvenida", null};
        }
        if (!nombreUsuarioValido(input)) {
            return new Object[]{"Login_usuarioInvalido", null};
        } else if (input.equals("juan1234")) {
            return new Object[]{"Login_pidePin", input};
        } else {
            return new Object[]{"Login_usuarioNoEncontrado", null};
        }
    }
    
    public String usuarioInvalido() {
        ViewLogin login = new ViewLogin();
        int selection = login.usuarioInvalido();
        if (selection == 0) {
            return "Login_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion" + selection + "sin ruta");
        }
    }
    
    public String usuarioNoEncontrado() {
        ViewLogin login = new ViewLogin();
        int selection = login.usuarioNoEncontrado();
        if (selection == 0) {
            return "Login_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion" + selection + "sin ruta");
        }
    }
    
    public Object[] pidePin() {
        ViewLogin login = new ViewLogin();
        String input = login.pidePin();
        if (input == null) {
            return new Object[]{"Bienvenida_bienvenida", null};
        }
        int pin = -1;
        try {
            pin = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return new Object[]{"Login_pinInvalido", null};
        }
        if (pin == 1234) {
            return new Object[]{"Login_exito", 1234};
        } else {
            return new Object[]{"Login_pinIncorrecto", null};
        }
    }
    
    public String pinIncorrecto() {
        ViewLogin login = new ViewLogin();
        int selection = login.pinIncorrecto();
        if (selection == 0) {  // Presiona OK
            return "Login_pidePin";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String pinInvalido() {
        ViewLogin login = new ViewLogin();
        int selection = login.pinInvalido();
        if (selection == 0) {  // Presiona OK
            return "Login_pidePin";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    public String exito() {
        ViewLogin login = new ViewLogin();
        int selection = login.exito();
        if (selection == 0 || selection == 2 || selection == -1) {  // Presiona OK, CANCEL o cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }
    
    // Validaciones
    private static boolean nombreUsuarioValido(String usu) {
        if (usu == null || usu.isBlank()) {
            return false;
        }
        for (int i = 0; i < usu.length(); i++) {
            if (Character.isWhitespace(usu.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
