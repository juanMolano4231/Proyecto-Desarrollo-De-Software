/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import views.ViewLogin;

/**
 *
 * @author johan
 */
public class ViewLoginController {
        public String pideNombreUsuario() {
        ViewLogin login = new ViewLogin();
        return login.pideNombreUsuario();
    }
    
    public int usuarioInvalido() {
        ViewLogin login = new ViewLogin();
        return login.usuarioInvalido();
    }
    
    public int usuarioNoEncontrado() {
        ViewLogin login = new ViewLogin();
        return login.usuarioNoEncontrado();
    }
    
    public String pidePin() {
        ViewLogin login = new ViewLogin();
        return login.pidePin();
    }
    
    public int pinIncorrecto() {
        ViewLogin login = new ViewLogin();
        return login.pinIncorrecto();
    }
    
    public int pinInvalido() {
        ViewLogin login = new ViewLogin();
        return login.pinInvalido();
    }
    
    public int exito() {
        ViewLogin login = new ViewLogin();
        return login.exito();
    }
}
