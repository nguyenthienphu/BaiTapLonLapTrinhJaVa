/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.pojo.Room;
import com.ntp.service.RoomService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class RoomController {
    
    @Autowired
    private RoomService roomSer;
    
    @RequestMapping("/room")
    public String createRoom(Model model) {
        model.addAttribute("room", new Room());
        
        return "room";
    }
    
    @PostMapping("/room")
    public String add(@ModelAttribute(value = "room") @Valid Room r, BindingResult rs ){
        if(!rs.hasErrors())
            if(this.roomSer.addOrUpdateRoom(r) == true)
                return "redirect:/";
        return "room"; 
    }
}
