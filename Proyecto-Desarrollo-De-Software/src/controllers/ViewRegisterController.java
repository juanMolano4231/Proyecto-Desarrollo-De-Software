/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;

import views.ViewRegister;

/**
 *
 * @author Juan Jose Molano Franco
 */
public class ViewRegisterController {
    public String pideNombreUsuario() {
        ViewRegister register = new ViewRegister();
        return register.pideNombreUsuario();
    }
    
    public int usuarioInvalido() {
        ViewRegister register = new ViewRegister();
        return register.usuarioInvalido();
    }
    
    public int usuarioOcupado() {
        ViewRegister register = new ViewRegister();
        return register.usuarioOcupado();
    }
    
    public String pidePin() {
        ViewRegister register = new ViewRegister();
        return register.pidePin();
    }
    
    public int pinInvalido() {
        ViewRegister register = new ViewRegister();
        return register.pinInvalido();
    }
    
    public int exito() {
        ViewRegister register = new ViewRegister();
        return register.exito();
    }
}
