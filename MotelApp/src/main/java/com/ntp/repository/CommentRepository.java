/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntp.repository;

import com.ntp.pojo.Comment;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CommentRepository {
    List<Comment> getComment(int roomId);
    Comment addComment(Comment c);
}
