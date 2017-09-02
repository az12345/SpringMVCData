package com.service;

import com.dao.EmploeeDao;
import com.dao.RepositoryEmploee;
import com.model.Emploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmploeeService {
    @Autowired
    RepositoryEmploee repositoryEmploee;

//    private EmploeeDao emploeeDao;
//    @Autowired
//    @Qualifier("emploeeDao")
//    public void setEmploeeDao(EmploeeDao emploeeDao) {
//        this.emploeeDao = emploeeDao;
//    }
    public void saveEmploee(Emploee emploee){
//        this.emploeeDao.saveEmploee(emploee);
        repositoryEmploee.save(emploee);
    }
//    public List<Emploee> emploeeList(){
//        return this.emploeeDao.emploeeList();
//    }

}
