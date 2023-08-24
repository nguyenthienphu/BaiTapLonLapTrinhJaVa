/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntp.pojo.Host;
import com.ntp.repository.HostRepository;
import com.ntp.service.HostService;
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
public class HostServiceImpl implements HostService{
    @Autowired
    private HostRepository hostRepo;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Host> getHost() {
        return this.hostRepo.getHost();
    }

    @Override
    public boolean addOrUpdateHost(Host h) {
         if (!h.getFile().isEmpty()){
            try {
                Map res = this.cloudinary.uploader().upload(h.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                h.setImage(res.get("secure_url").toString());
         } catch (IOException ex) {
             Logger.getLogger(HostServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
        return this.hostRepo.addOrUpdateHost(h);
    }

    @Override
    public Host getHostById(int id) {
        return this.hostRepo.getHostById(id);
    }
    
}
