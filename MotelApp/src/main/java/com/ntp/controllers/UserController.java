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
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/listuser")
    public String listUser(Model model) {
        model.addAttribute("listuser", this.userSer.getUser());

        return "listuser";
    }

    @GetMapping("/user/{userId}")
    public String update(Model model, @PathVariable(value = "userId") int id) {
        model.addAttribute("user", this.userSer.getUserById(id));

        return "register";
    }

    @GetMapping("/adduser")
    public String adduser(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String add(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userSer.addOrUpdateUser(user) == true) {
                return "redirect:/login";
            } else {
                errMsg = "Hệ thống đang lỗi";
            }
        } else {
            errMsg = "Mật khẩu không khớp!";
        }

        model.addAttribute("errMsg", errMsg);

        return "register";
    }
}
