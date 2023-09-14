/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.controllers;

import com.ntp.pojo.Comment;
import com.ntp.pojo.Posts;
import com.ntp.service.CommentService;
import com.ntp.service.PostsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiPostsController {
    @Autowired
    private PostsService postSer;
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/posts/")
    @CrossOrigin
    public ResponseEntity<List<Posts>> listPosts() {
        return new ResponseEntity<>(this.postSer.getPosts(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/posts/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Posts> details(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.postSer.getPostsById(id), HttpStatus.OK);

    }
    
    @PostMapping(path="/posts/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Posts> addComment(@RequestBody Posts posts) {
        Posts p = this.postSer.addPosts(posts);
        
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
    
    @GetMapping("/posts/{id}/comment/")
    @CrossOrigin
    public ResponseEntity<List<Comment>> listComments(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.commentService.getCommentPosts(id), HttpStatus.OK);
    }
    
  
}
