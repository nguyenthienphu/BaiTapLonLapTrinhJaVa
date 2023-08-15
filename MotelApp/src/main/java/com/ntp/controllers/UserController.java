/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.pojo.User;
import com.ntp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UserController {
    
    @Autowired
    UserService userSer;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String add(Model model, @ModelAttribute(value = "register") User user ){
        String errMsg = "";
        if(user.getPassword().equals(user.getConfirmPassword())){
            if(this.userSer.addOrUpdateUser(user) == true)
                return "redirect:/login";
            else
                errMsg = "Hệ thống đang lỗi";
        } else
            errMsg = "Mật khẩu không khớp!";
        
        model.addAttribute("errMsg", errMsg);
        
        return "register"; 
    }
}
