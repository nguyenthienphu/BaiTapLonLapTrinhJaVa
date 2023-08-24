/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.repository;

import com.ntp.pojo.User;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UserRepository {
    User getUserByUsername(String username);
    boolean addOrUpdateUser(User user);
    List<User> getUser();
    User getUserById(int id);
    boolean authUser(String username, String password);
    User addUser(User user);

}
