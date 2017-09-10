package com.controller;

import com.model.Emploee;
import com.service.EmploeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private EmploeeService emploeeService;
//    @Autowired
//    @Qualifier("emploeeService")
//    public void setEmploeeService(EmploeeService emploeeService) {
//        this.emploeeService = emploeeService;
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//        public ModelAndView main(Model model){
//           model.addAttribute("emploee", new Emploee());
////           model.addAttribute("list", emploeeService.emploeeList());
//           return new ModelAndView("index");
//        }
//        @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String add(@ModelAttribute Emploee emploee){
//            emploeeService.saveEmploee(emploee);
//            return "redirect:/";
//        }


    @Autowired
    @Qualifier("emploeeService")
    public void setEmploeeService(EmploeeService emploeeService) {
        this.emploeeService = emploeeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(Model model) {
        model.addAttribute("emploee", new Emploee());
        model.addAttribute("list", emploeeService.findDesc());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Emploee emploee) {
        emploeeService.saveEmploee(emploee);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateEmploee(@PathVariable("id") int id, Model model) {
        model.addAttribute("emploee", this.emploeeService.findEmploeeById(id));
        return "emploee";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmploee(@PathVariable("id") int id) {
        this.emploeeService.deleteEmploee(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/findbyname", method = RequestMethod.POST)
    public String findBYName(@RequestParam String name, Model model){
        model.addAttribute("emploee", this.emploeeService.findByName(name));
        return "result";
    }

}
