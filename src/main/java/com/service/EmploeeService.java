package com.service;

import com.dao.DaoEmploee;
import com.dao.EmploeeDao;
import com.model.Emploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmploeeService {
    private DaoEmploee daoEmploee;

    @Autowired
    @Qualifier("daoEmploee")
    public void setDaoEmploee(DaoEmploee daoEmploee) {
        this.daoEmploee = daoEmploee;
    }
//    private EmploeeDao emploeeDao;
//    @Autowired
//    @Qualifier("emploeeDao")
//    public void setEmploeeDao(EmploeeDao emploeeDao) {
//        this.emploeeDao = emploeeDao;
//    }
//    public void saveEmploee(Emploee emploee){
//        this.emploeeDao.saveEmploee(emploee);
//    }
//    public List<Emploee> emploeeList(){
//        return this.emploeeDao.emploeeList();
//    }


    public void saveEmploee(Emploee emploee) {
        this.daoEmploee.save(emploee);
    }

    public Iterable<Emploee> emploeeList() {
        return this.daoEmploee.findAll();
    }

    public void deleteEmploee(int id) {
        this.daoEmploee.delete(id);
    }

    public Emploee findEmploeeById(int id) {
        return this.daoEmploee.findOne(id);
    }

    public void updateEmploee(Emploee emploee) {
        this.daoEmploee.save(emploee);
    }

    public Emploee findByName(String name){
        return this.daoEmploee.findByName(name);
    }

    public List<Emploee> findDesc(){
        return daoEmploee.findDesc();
    }

}
