/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.repository.impl;

import com.ntp.pojo.Host;
import com.ntp.repository.HostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
    public List<Host> getHost(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Host> q = b.createQuery(Host.class);
        Root r = q.from(Host.class);
        
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
      
            String Id = params.get("id");
            if (Id != null && !Id.isEmpty()) {
                predicates.add(b.equal(r.get("id"), Long.valueOf(Id)));
            }
               
            q.where(predicates.toArray(Predicate[]::new));
        }
        
        q.orderBy(b.desc(r.get("id")));
        
        Query query = session.createQuery(q.select(r));
        return query.getResultList();
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
