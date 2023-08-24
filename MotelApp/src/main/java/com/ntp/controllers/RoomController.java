/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.pojo.Room;
import com.ntp.service.RoomService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class RoomController {
    
    @Autowired
    private RoomService roomSer;
    @Autowired
    private Environment env;
    
    @RequestMapping("/listroom")
    public String index(Model model,@RequestParam Map<String, String> params) {
        model.addAttribute("rooms",this.roomSer.getRoom(params));
        
        int count = this.roomSer.coutRoom();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages",Math.ceil(count*1.0/pageSize));
        
        return "listroom";
    }
    
    @GetMapping("/room")
    public String createRoom(Model model) {
        model.addAttribute("room", new Room());
        
        return "room";
    }
    
    @GetMapping("/room/{roomId}")
    public String update(Model model, @PathVariable(value = "roomId") int id ){
        model.addAttribute("room", this.roomSer.getRoomById(id));
        
        return "room";
    }
    
    @PostMapping("/room")
    public String add(@ModelAttribute(value = "room") @Valid Room r, BindingResult rs ){
        if(!rs.hasErrors())
            if(this.roomSer.addOrUpdateRoom(r) == true)
                return "redirect:/listroom";
        return "room"; 
    }
}
