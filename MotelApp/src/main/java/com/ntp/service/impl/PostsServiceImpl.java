/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.service.impl;

import com.ntp.pojo.Posts;
import com.ntp.pojo.User;
import com.ntp.repository.PostsRepository;
import com.ntp.repository.UserRepository;
import com.ntp.service.PostsService;
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
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postsRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Posts> getPosts() {
        return this.postsRepo.getPosts();
    }

    @Override
    public Posts addPosts(Posts p) {
        p.setCreatedDate(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepo.getUserByUsername(authentication.getName());
        p.setUser(u);
        
        return this.postsRepo.addPosts(p);
    }

}
