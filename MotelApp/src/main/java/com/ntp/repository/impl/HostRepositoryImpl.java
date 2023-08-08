///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.ntp.repository.impl;
//
//import com.ntp.pojo.Host;
//import com.ntp.repository.HostRepository;
//import java.util.List;
//import javax.persistence.Query;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author Admin
// */
//@Repository
//public class HostRepositoryImpl implements HostRepository{
//    @Autowired
//    private LocalSessionFactoryBean factory;
//    
//    @Override
//    public List<Host> getHost() {
//        Session s = this.factory.getObject().getCurrentSession();
//        
//        Query q = s.createNamedQuery("Host.findAll");
//        
//        return q.getResultList();
//    } 
//}
