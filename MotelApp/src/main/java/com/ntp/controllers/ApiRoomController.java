/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.pojo.Room;
import com.ntp.service.RoomService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiRoomController {

    @Autowired
    private RoomService roomSer;

    @DeleteMapping("/room/{roomId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteRoom(@PathVariable(value = "roomId") int id) {
        this.roomSer.deleteRoom(id);

        return "room";
    }
    
    @GetMapping("/room/")
    @CrossOrigin
    public ResponseEntity<List<Room>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.roomSer.getRoom(params), HttpStatus.OK);
    }

}
