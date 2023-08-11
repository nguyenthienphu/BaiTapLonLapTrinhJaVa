/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntp.pojo.Room;
import com.ntp.repository.RoomRepository;
import com.ntp.service.RoomService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Room> getRoom(Map<String, String> params) {
        return this.roomRepo.getRoom(params);
    }

    @Override
    public int coutRoom() {
        return this.roomRepo.coutRoom();
    }

    @Override
    public boolean addOrUpdateRoom(Room r) {
        if (!r.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(r.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                r.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(RoomServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.roomRepo.addOrUpdateRoom(r);
    }

    @Override
    public Room getRoomById(int id) {
         return this.roomRepo.getRoomById(id);
    }

    @Override
    public boolean deleteRoom(int id) {
        return this.roomRepo.deleteRoom(id);
    }

}
