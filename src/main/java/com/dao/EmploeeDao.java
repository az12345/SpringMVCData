package com.dao;

import com.model.Emploee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmploeeDao {
//    private SessionFactory sessionFactory;
//    @Autowired
//    @Qualifier("hibernate4AnnotatedSessionFactory")
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public void saveEmploee(Emploee emploee){
//        Session session =this.sessionFactory.getCurrentSession();
//        session.persist(emploee);
//    }
//    public List<Emploee> emploeeList(){
//        Session session = this.sessionFactory.getCurrentSession();
//
//        List<Emploee> list = session.createQuery("from Emploee ").list();
//        return list;
//    }

}
