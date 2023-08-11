/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.service.impl;

import com.ntp.pojo.Host;
import com.ntp.repository.HostRepository;
import com.ntp.service.HostService;
import java.util.List;
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
    
    @Override
    public List<Host> getHost() {
        return this.hostRepo.getHost();
    }
    
}
