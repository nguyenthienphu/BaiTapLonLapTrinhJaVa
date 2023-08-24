/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.repository.impl;

import com.ntp.pojo.Host;
import com.ntp.repository.HostRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Host> query = b.createQuery(Host.class);
        Root r = query.from(Host.class);
        
        query.orderBy(b.desc(r.get("id")));
        
        Query q = session.createQuery(query.select(r));
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

    @Override
    public Host getHostById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Host.class, id);
    }
}
