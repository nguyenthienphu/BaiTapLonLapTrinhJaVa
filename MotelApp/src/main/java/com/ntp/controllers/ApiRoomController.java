/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiRoomController {
    
    @Autowired
    private RoomService roomSer;
    
     @DeleteMapping("/room/{roomId}")
     @ResponseStatus(HttpStatus.NO_CONTENT)
    public String update(Model model, @PathVariable(value = "roomId") int id ){
        this.roomSer.deleteRoom(id);
        
        return "room";
    }
    
}
