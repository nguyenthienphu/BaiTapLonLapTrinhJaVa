/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.pojo;

import lombok.Data;

/**
 *
 * @author admin
 */
@Data
public class Cart {
    private Long id;
    private String name;
    private int quantity;
    private Long unitPrice;

    public Cart(Long id, String name, int quantity, Long unitPrice) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
    
    
    
}
