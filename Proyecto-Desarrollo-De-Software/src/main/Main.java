/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controllers.ViewBienvenidaController;
import controllers.ViewLoginController;
import controllers.ViewRegisterController;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class Main {

    public static void main(String[] args) {
        /* Guarda la ruta a la que se irá en la siguiente iteración del ciclo
        en cierta View y cierto Diálogo (cada método es un diálogo */
        String ruta = "Bienvenida_bienvenida";  // Ruta default, ViewBienvenida método bienvenida
        /* Guarda toda la data que se va a pasar entre diálogos y views
        Se puede incrementar el tamaño del array si es necesario */
        Object[] aux = new Object[16];
        /* Para cargar la data de los métodos y usarla, siempre se sobrescribe */
        Object[] data;
        while (true) {
            switch (ruta) {
                // Salida
                case "salida":
                    System.exit(0);
                // ViewBienvenida
                case "Bienvenida_bienvenida":
                    ruta = bienvenida_bienvenida();
                    break;
                // ViewLogin
                case "Login_pideNombreUsuario":
                    data = login_pideNombreUsuario();
                    ruta = (String) data[0]; // ruta
                    aux[0] = data[1]; // nombre de usuario
                    break;
                case "Login_usuarioInvalido":
                    ruta = login_usuarioInvalido();
                    break;
                case "Login_usuarioNoEncontrado":
                    ruta = login_usuarioNoEncontrado();
                    break;
                case "Login_pidePin":
                    data = login_pidePin();
                    ruta = (String) data[0]; // ruta
                    aux[1] = data[1]; // pin
                    break;
                case "Login_pinIncorrecto":
                    ruta = login_pinIncorrecto();
                    break;
                case "Login_pinInvalido":
                    ruta = login_pinInvalido();
                    break;
                case "Login_exito":
                    ruta = login_exito();
                    break;
                // ViewRegister
                case "Register_pideNombreUsuario":
                    data = register_pideNombreUsuario();
                    ruta = (String) data[0];
                    aux[0] = data[1]; // Guarda nombre de usuario para registro
                    break;
                case "Register_usuarioInvalido":
                    ruta = register_usuarioInvalido();
                    break;
                case "Register_usuarioOcupado":
                    ruta = register_usuarioOcupado();
                    break;
                case "Register_pidePin":
                    data = register_pidePin();
                    ruta = (String) data[0];
                    aux[1] = data[1]; // Guarda pin del usuario para registro
                    break;
                case "Register_pinInvalido":
                    ruta = register_pinInvalido();
                    break;
                case "Register_exito":
                    ruta = register_exito();
                    break;
                default:
                    throw new Error("No hay una ruta establecida para la ruta \""
                            + ruta + "\"");
            }
        }
    }

    // ViewBienvenida
    private static String bienvenida_bienvenida() {
        ViewBienvenidaController controller = new ViewBienvenidaController();
        String selection = controller.bienvenida();
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

    //ViewLogin
    private static Object[] login_pideNombreUsuario() {
        ViewLoginController controller = new ViewLoginController();
        String input = controller.pideNombreUsuario();
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

    private static String login_usuarioInvalido() {
        ViewLoginController controller = new ViewLoginController();
        int selection = controller.usuarioInvalido();
        if (selection == 0) {
            return "Login_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion" + selection + "sin ruta");
        }
    }

    private static String login_usuarioNoEncontrado() {
        ViewLoginController controller = new ViewLoginController();
        int selection = controller.usuarioNoEncontrado();
        if (selection == 0) {
            return "Login_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion" + selection + "sin ruta");
        }
    }

    private static Object[] login_pidePin() {
        ViewLoginController controller = new ViewLoginController();
        String input = controller.pidePin();
        int pin = -1;
        try {
            pin = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return new Object[]{"Login_pinInvalido", null};
        }
        if (pin == 1234) {
            return new Object[]{"Login_exito", null};
        } else {
            return new Object[]{"Login_pinIncorrecto", null};
        }
    }

    private static String login_pinIncorrecto() {
        ViewLoginController controller = new ViewLoginController();
        int selection = controller.pinIncorrecto();
        if (selection == 0) {  // Presiona OK
            return "Login_pidePin";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    private static String login_pinInvalido() {
        ViewLoginController controller = new ViewLoginController();
        int selection = controller.pinInvalido();
        if (selection == 0) {  // Presiona OK
            return "Login_pidePin";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    private static String login_exito() {
        ViewLoginController controller = new ViewLoginController();
        int selection = controller.exito();
        if (selection == 0 || selection == 2 || selection == -1) {  // Presiona OK, CANCEL o cierra la ventana
            return "salida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    // ViewRegister
    private static Object[] register_pideNombreUsuario() {
        ViewRegisterController controller = new ViewRegisterController();
        String input = controller.pideNombreUsuario();
        if (input == null) {
            return new Object[]{"Bienvenida_bienvenida", null};
        }
        if (!nombreUsuarioValido(input)) {
            return new Object[]{"Register_usuarioInvalido", null};
        } else if (input.equals("juan1234")) {  // Usuario admin quemado
            return new Object[]{"Register_usuarioOcupado", null};
        } else {
            return new Object[]{"Register_pidePin", input};
        }
    }

    private static String register_usuarioInvalido() {
        ViewRegisterController controller = new ViewRegisterController();
        int selection = controller.usuarioInvalido();
        if (selection == 0) {  // Presiona OK
            return "Register_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    private static String register_usuarioOcupado() {
        ViewRegisterController controller = new ViewRegisterController();
        int selection = controller.usuarioOcupado();
        if (selection == 0) {  // Presiona OK
            return "Register_pideNombreUsuario";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    private static Object[] register_pidePin() {
        ViewRegisterController controller = new ViewRegisterController();
        String input = controller.pidePin();
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return new Object[]{"Register_pinInvalido", null};
        }
        return new Object[]{"Register_exito", input};
    }

    private static String register_pinInvalido() {
        ViewRegisterController controller = new ViewRegisterController();
        int selection = controller.pinInvalido();
        if (selection == 0) {  // Presiona OK
            return "Register_pidePin";
        } else if (selection == 2 || selection == -1) {  // Presiona CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
        } else {
            throw new Error("Seleccion \"" + selection + "\" sin ruta");
        }
    }

    private static String register_exito() {
        ViewRegisterController controller = new ViewRegisterController();
        int selection = controller.exito();
        if (selection == 0 || selection == 2 || selection == -1) {  // Presiona OK, CANCEL o cierra la ventana
            return "Bienvenida_bienvenida";
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
