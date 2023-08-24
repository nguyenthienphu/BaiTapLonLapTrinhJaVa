/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.pojo.Host;
import com.ntp.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class HostController {
    
    @Autowired
    private HostService hostSer;
    
    @RequestMapping("/listhost")
    public String listHost(Model model) {
        model.addAttribute("hosts", this.hostSer.getHost());
        
        return "listhost";
    }
    
    @GetMapping("/host")
    public String host(Model model) {
        model.addAttribute("host", new Host());
        
        return "host";
    }
    @GetMapping("/host/{hostId}")
    public String update(Model model, @PathVariable(value = "hostId") int id) {
        model.addAttribute("host", this.hostSer.getHostById(id));
        
        return "host";
    }
    
    @PostMapping("/host")
    public String addHost(@ModelAttribute(value = "host")Host h ){
        if(this.hostSer.addOrUpdateHost(h) == true)
            return "redirect:/listhost";
        return "host"; 
    }
}
