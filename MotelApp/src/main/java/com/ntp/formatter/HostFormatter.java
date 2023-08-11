/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.formatter;

import com.ntp.pojo.Host;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class HostFormatter implements Formatter<Host>{

    @Override
    public String print(Host ht, Locale locale) {
        return String.valueOf(ht.getId());
    }

    @Override
    public Host parse(String htId, Locale locale) throws ParseException {
        return new Host(Integer.parseInt(htId));
    }
    
}
