/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controllers;

import services.ViewTestService;

/**
 *
 * @author Juan José Molano Franco
 */
public class ViewTestController {
    
    private ViewTestService service;
    
    public ViewTestController() {
        this.service = new ViewTestService();
    }

    public String botones() {
        return service.botones();
    }
    
    
    
}
