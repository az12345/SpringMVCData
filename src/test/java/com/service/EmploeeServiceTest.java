package com.service;

import com.init.AppConfig;
import com.model.Emploee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

//@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class EmploeeServiceTest {

    private EmploeeService emploeeService;

    @Autowired
    @Qualifier("emploeeService")
    public void setEmploeeService(EmploeeService emploeeService) {
        this.emploeeService = emploeeService;
    }


//    @Test
//    public void setDaoEmploee() throws Exception {
//    }
//
//    @Test
//    public void saveEmploee() throws Exception {
//    }
//
//    @Test
//    public void emploeeList() throws Exception {
//    }
//
//    @Test
//    public void deleteEmploee() throws Exception {
//    }

    @Test
    public void saveEmploee() throws Exception {
        Emploee emploee = generateEmploee();
        emploeeService.saveEmploee(emploee);
        String emploeename = emploeeService.findByName(emploee.getName()).getName();
        assertEquals(emploee.getName(), emploeename);
    }

    @Test
    public void deleteEmploee(){
        Emploee emploee = generateEmploee();
        String emploeeName = emploee.getName();
        emploeeService.saveEmploee(emploee);
        emploeeService.deleteEmploee(emploeeService.findByName(emploeeName).getId());
        assertNull(emploeeService.findByName(emploeeName));
    }

    @Test
    public void emploeeList(){
        assertNotNull(emploeeService.emploeeList());
    }

    @Test
    public void findEmploeeById(){
        Emploee emploee = generateEmploee();
        emploeeService.saveEmploee(emploee);
        Emploee newEmploee1 = emploeeService.findByName(emploee.getName());
        Emploee newEmploee = emploeeService.findEmploeeById(newEmploee1.getId());
        assertEquals(newEmploee.getId(), emploee.getId());
    }

    @Test
    public void updateEmploee() throws Exception {
        Emploee emploee = new Emploee();
        emploee.setName("Tom");
        emploeeService.saveEmploee(emploee);
        Emploee newEmploee = emploeeService.findByName("Tom");
        newEmploee.setName("Bob");
        emploeeService.saveEmploee(newEmploee);
        assertEquals(emploeeService.findByName("Bob"), newEmploee);
    }

    @Test
    public void findByName() throws Exception {
        Emploee emploee = new Emploee();
        emploee.setName("Tom");
        emploeeService.saveEmploee(emploee);
        assertNotNull(emploeeService.findByName("Tom"));
    }
//
//    @Test
//    public void findDesc() throws Exception {
//    }

    private Emploee generateEmploee(){
        Emploee emploee = new Emploee();
        emploee.setName("test");
        return emploee;
    }

}