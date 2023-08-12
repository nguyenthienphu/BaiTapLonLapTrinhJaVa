/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntp.service;

import com.ntp.pojo.Host;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface HostService {
    List<Host> getHost();
    boolean addOrUpdateHost(Host h);
}
