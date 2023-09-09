/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntp.service;

import com.ntp.pojo.Room;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface RoomService {
    List<Room> getRoom(Map<String, String> params);
    int coutRoom();
    boolean addOrUpdateRoom(Room r);
    Room getRoomById(int id);
    boolean deleteRoom(int id);
    Room addRoom(Map<String, String> params, MultipartFile image);
    
}
