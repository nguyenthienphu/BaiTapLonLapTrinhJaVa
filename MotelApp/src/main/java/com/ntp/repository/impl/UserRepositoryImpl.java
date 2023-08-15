/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.repository.impl;

import com.ntp.pojo.User;
import com.ntp.repository.UserRepository;
import java.util.List;
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
 * @author admin
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;

//    @Override
//    public User getUserByUsername(String username) {
//        Session s = this.factory.getObject().getCurrentSession();
//        Query q = s.createQuery("From User Where username=:un");
//        q.setParameter("un", username);
//        
//        return (User) q.getSingleResult();
//    }

    @Override
    public boolean addOrUpdateUser(User user) {
          Session s = this.factory.getObject().getCurrentSession();
        try {
            if (user.getId() == null) {
                s.save(user);
            } else {
                s.update(user);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getUsers(String username) {
       Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> query = b.createQuery(User.class);
        Root r = query.from(User.class);
        
        if(!username.isEmpty()){
            Predicate p = b.equal(r.get("username").as(String.class), username.trim());
            query = query.where(p);
        }
        
        Query q = session.createQuery(query.select(r));
        return q.getResultList();
    }
    
}
