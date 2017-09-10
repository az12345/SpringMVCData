package com.controller;

import com.init.AppConfig;
import com.model.Emploee;
import com.service.EmploeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.repository.util.ClassUtils.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class MainControllerTest {

    @Mock
    private EmploeeService emploeeService;
    @InjectMocks
    private MainController mainController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this.emploeeService);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void main() throws Exception {
        List<Emploee> list = new ArrayList<Emploee>();
        list.add(new Emploee());
        list.add(new Emploee());
        list.add(new Emploee());
        when(emploeeService.findDesc()).thenReturn(list);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("list", list));
    }

    @Test
    public void add() throws Exception {
        verifyZeroInteractions(emploeeService);
        mockMvc.perform(post("/add"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"))
                .andExpect(model().attribute("emploee", instanceOf(Emploee.class)));
    }

    @Test
    public void updateEmploee() throws Exception {
        Emploee emploee = new Emploee();
        emploee.setId(1);
        emploee.setName("Bob");
        emploeeService.saveEmploee(emploee);
        when(emploeeService.findEmploeeById(1)).thenReturn(emploee);
        mockMvc.perform(get("/update/1").param("id", "1").param("name", "Tom"))
                .andExpect(status().isOk())
                .andExpect(view().name("emploee"))
                .andExpect(model().attribute("emploee", instanceOf(Emploee.class)));
//                .andExpect(model().attribute("name", emploee.getName()));

    }

    @Test
    public void deleteEmploee() throws Exception {
        mockMvc.perform(get("/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

    }

    @Test
    public void findBYName() throws Exception {
        when(emploeeService.findByName("tom")).thenReturn(new Emploee());
        mockMvc.perform(post("/findbyname").param("name", "tom"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"));

    }

}