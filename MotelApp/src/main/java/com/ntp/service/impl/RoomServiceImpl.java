/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.service.impl;

import com.ntp.pojo.Room;
import com.ntp.repository.RoomRepository;
import com.ntp.service.RoomService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepo;
    
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
        r.setImage("https://xaydungthuanphuoc.com/wp-content/uploads/2022/09/mau-phong-tro-co-gac-lung-dep2022-5.jpg");
        return this.roomRepo.addOrUpdateRoom(r);
    }
    
}
