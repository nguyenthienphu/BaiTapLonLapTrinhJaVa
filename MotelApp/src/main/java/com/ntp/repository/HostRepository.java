/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntp.repository;

import com.ntp.pojo.Host;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface HostRepository {
    List<Host> getHost(Map<String, String> params);
    boolean addOrUpdateHost(Host h);
    Host getHostById(int id);
}
