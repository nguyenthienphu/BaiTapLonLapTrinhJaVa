/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.service.impl;

import com.ntp.pojo.Comment;
import com.ntp.pojo.User;
import com.ntp.repository.CommentRepository;
import com.ntp.repository.UserRepository;
import com.ntp.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public List<Comment> getComment(int roomId) {
        return this.commentRepo.getComment(roomId);
    }

    @Override
    public Comment addComment(Comment c) {
        c.setCreatedDate(new Date());
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepo.getUserByUsername(authentication.getName());
        c.setUser(u);
        
        return this.commentRepo.addComment(c);
    }

    @Override
    public List<Comment> getCommentPosts(int id) {
       return this.commentRepo.getCommentPosts(id);
    }
    
}
