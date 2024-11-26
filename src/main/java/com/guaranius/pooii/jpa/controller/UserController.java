package com.guaranius.pooii.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guaranius.pooii.jpa.entity.User;
import com.guaranius.pooii.jpa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ModelAndView users() {
        var mv = new ModelAndView("users");
        mv.addObject("list", service.findAll());
        return mv;
    }

    @GetMapping
    @RequestMapping("/add")
    public ModelAndView add() {
        var mv = new ModelAndView("addUser");
        mv.addObject("user", new User());
        return mv;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ModelAndView update(@PathVariable long id) {
        var mv = new ModelAndView("updateUser");
        var opt = service.findById(id);
        if(opt.isPresent()) {
            mv.addObject("user", opt.get());
            return mv;
        }
        return new ModelAndView("redirect:/user");
    }

    @GetMapping
    @RequestMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        var opt = service.findById(id);
        if(opt.isPresent()) {
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/user");
    }

    @PostMapping
    @RequestMapping("/save")
    public ModelAndView insert(@ModelAttribute("user") User user) {
        try {
            service.save(user);
            return new ModelAndView("redirect:/user");
        } catch (Exception e) {
            var mv = new ModelAndView("addUser");
            mv.addObject("user", user);
            mv.addObject("error", e.getMessage());
            return mv;
        }
    }
}
