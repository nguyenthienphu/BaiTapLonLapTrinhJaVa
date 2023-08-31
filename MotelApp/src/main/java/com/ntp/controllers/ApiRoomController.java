/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.pojo.Comment;
import com.ntp.pojo.Room;
import com.ntp.service.CommentService;
import com.ntp.service.RoomService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private CommentService commentService;

    @DeleteMapping("/room/{roomId}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable(value = "roomId") int id) {
        this.roomSer.deleteRoom(id);
    }

    @RequestMapping(path = "/room/{roomId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Room> details(@PathVariable(value = "roomId") int id) {
        return new ResponseEntity<>(this.roomSer.getRoomById(id), HttpStatus.OK);

    }
//    @PostMapping(path = "/room", consumes = {
//        MediaType.MULTIPART_FORM_DATA_VALUE,
//        MediaType.APPLICATION_JSON_VALUE
//    })

    @GetMapping("/room/")
    @CrossOrigin
    public ResponseEntity<List<Room>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.roomSer.getRoom(params), HttpStatus.OK);
    }

    @GetMapping("/room/{roomId}/comment/")
    @CrossOrigin
    public ResponseEntity<List<Comment>> listComments(@PathVariable(value = "roomId") int id) {
        return new ResponseEntity<>(this.commentService.getComment(id), HttpStatus.OK);
    }
    
    @PostMapping(path="/comment/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment c = this.commentService.addComment(comment);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

}
