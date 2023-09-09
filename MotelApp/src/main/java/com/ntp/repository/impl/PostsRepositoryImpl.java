/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.repository.impl;

import com.ntp.pojo.Posts;
import com.ntp.repository.PostsRepository;
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
public class PostsRepositoryImpl implements PostsRepository {
    
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Posts> getPosts() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Posts> q = b.createQuery(Posts.class);
        Root r = q.from(Posts.class);
        q.select(r);
        
        
        q.orderBy(b.desc(r.get("id")));
        
        Query query = session.createQuery(q.select(r));
        return query.getResultList();
    }

    @Override
    public Posts addPosts(Posts p) {
       Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(p);
            return p;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
      
}
