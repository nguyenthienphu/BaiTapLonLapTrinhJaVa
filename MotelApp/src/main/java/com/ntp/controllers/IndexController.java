/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;


import com.ntp.service.HostService;
import com.ntp.service.RoomService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class IndexController {
    @Autowired
    private HostService hostSer;
    @Autowired
    private RoomService roomSer;
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void commonAttr(Model model, @RequestParam Map<String, String> params){
        model.addAttribute("hosts", this.hostSer.getHost(params));
    }
    
    @RequestMapping("/")
    public String index(Model model,@RequestParam Map<String, String> params) {
        model.addAttribute("rooms",this.roomSer.getRoom(params));
        
        int count = this.roomSer.coutRoom();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages",Math.ceil(count*1.0/pageSize));
        
        return "index";
    }
}
