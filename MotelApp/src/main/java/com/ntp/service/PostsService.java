/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntp.service;

import com.ntp.pojo.Posts;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface PostsService {
    List<Posts> getPosts();
    Posts addPosts(Posts p);
    Posts getPostsById(int id);
}
