/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.repository.impl;

import com.ntp.pojo.Host;
import com.ntp.repository.HostRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class HostRepositoryImpl implements HostRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Host> getHost() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Host.findAll");

        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateHost(Host h) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (h.getId() == null) {
                s.save(h);
            } else {
                s.update(h);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }
}
