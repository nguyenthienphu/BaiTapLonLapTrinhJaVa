/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;


import com.ntp.pojo.Host;
import com.ntp.pojo.Room;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class IndexController {
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @RequestMapping("/")
    @Transactional
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        List<Host> hts = List.of(new Host(1,"tây thạnh"), new Host(2,"tân phú"));
        
        model.addAttribute("hosts", hts);
        
//        List<Room> roomss = List.of(
//                new Room(1,"phòng 1m"),
//                new Room(2,"phòng 2m"),
//                new Room(3,"lầu 1m")
//        );
        
//        String kw = params.get("kw");
//        if(kw != null && !kw.isEmpty())
//            model.addAttribute("rooms",roomss.stream().filter(p -> p.getName().contains(kw)).toArray());
//        else
        Session s = this.factory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("From Host");
        model.addAttribute("rooms",q.getResultList());
        return "index";
    }
}
