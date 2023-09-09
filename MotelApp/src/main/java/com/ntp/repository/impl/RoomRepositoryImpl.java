/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntp.repository.impl;


import com.ntp.pojo.Room;
import com.ntp.repository.RoomRepository;
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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class RoomRepositoryImpl implements RoomRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    public List<Room> getRoom(Map<String, String> params) {

        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Room> q = b.createQuery(Room.class);
        Root r = q.from(Room.class);
        q.select(r);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(r.get("name"), String.format("%%%s%%", kw)));
            }
//                
//                String fromPrice = params.get("fromPrice");
//                if (fromPrice != null && !fromPrice.isEmpty()) 
//                    predicates.add(b.greaterThanOrEqualTo(r.get("price"), Long.parseLong(fromPrice)));
//                
//                String toPrice = params.get("toPrice");
//                if (toPrice != null && !toPrice.isEmpty()) 
//                    predicates.add(b.lessThanOrEqualTo(r.get("price"), Long.parseLong(toPrice)));
//                
            String hId = params.get("hId");
            if (hId != null && !hId.isEmpty()) {
                predicates.add(b.equal(r.get("hostId"), Long.valueOf(hId)));
            }
//                
            q.where(predicates.toArray(Predicate[]::new));
        }
        
        q.orderBy(b.desc(r.get("id")));
        
        Query query = session.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
            }
        }

        return query.getResultList();

    }

    @Override
    public int coutRoom() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Room");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateRoom(Room r) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (r.getId() == null) {
                s.save(r);
            } else {
                s.update(r);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Room getRoomById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Room.class, id);
    }

    @Override
    public boolean deleteRoom(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Room r = this.getRoomById(id);
        try {
            s.delete(r);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Room addRoom(Room room) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(room);
        
        return room;
    }
}

   
