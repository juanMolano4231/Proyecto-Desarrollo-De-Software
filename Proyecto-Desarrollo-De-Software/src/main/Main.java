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
                    System.out.println(ruta);
                    data = login_pideNombreUsuario();
                    ruta = (String) data[0]; // ruta
                    aux[0] = data[1]; // nombre de usuario
                    break;
                case "Login_UsuarioInvalido":
                    // implementar
                    break;
                case "Login_pidePin":
                    System.out.println(ruta);
                    data = login_pidePin();
                    ruta = (String) data[0]; // ruta
                    aux[2] = data[1]; // pin
                    break;
                case "Login_PinInvalido":
                    System.out.println(ruta);
                    ruta = login_pinInvalido();
                    break;
                default:
                    throw new Error ("No hay una ruta establecida para la ruta \"" 
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
                throw new Error ("No hay una ruta establecida para seleccion \"" 
                        + selection + "\"");
        }
    }
    
    //ViewLogin
    private static Object[] login_pideNombreUsuario() {
        // crea ViewLoginController y llama al diálogo de pideNombreUsuario
        // hace lógica y decide a qué ruta sigue
        // puede retornar ruta "Login_usuarioInvalido" o "Login_pidePin"
        
        // Supongamos que hay lógica y el usuario pasa juan123 como nombre de 
        // usuario y es válido
        String input = "juan123";
        return new Object[]{"Login_pidePin", input};
    }
    
    private static Object[] login_pidePin() {
        String input = "123 4"; // se saca el input de la vista
        // posibles rutas: "Login_pinInvalido", "Login_datosInexistentes",
        // "GestionCine_verSalas", "GestionPerfil_perfil"
        return new Object[]{"Login_PinInvalido", input};
    }
    
    private static String login_pinInvalido() {
        // Llama al controlador de login y le pide abrir la ventana de ViewLogin pinInvalido
        return "Login_pidePin";
    }
}
