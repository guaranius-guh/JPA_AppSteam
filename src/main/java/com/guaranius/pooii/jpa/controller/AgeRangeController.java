package com.guaranius.pooii.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guaranius.pooii.jpa.entity.AgeRange;
import com.guaranius.pooii.jpa.service.AgeRangeService;

@Controller
@RequestMapping("/ageRange")
public class AgeRangeController {

    @Autowired
    private AgeRangeService service;

    @GetMapping
    public ModelAndView ageRanges() {
        var mv = new ModelAndView("ageRanges");
        mv.addObject("list", service.findAll());
        System.out.println(service.findAll());
        return mv;
    }

    @GetMapping
    @RequestMapping("/add")
    public ModelAndView add() {
        var mv = new ModelAndView("addAgeRange");
        mv.addObject("ageRange", new AgeRange());
        return mv;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ModelAndView update(@PathVariable long id) {
        var mv = new ModelAndView("updateAgeRange");
        var opt = service.findById(id);
        if(opt.isPresent()) {
            mv.addObject("ageRange", opt.get());
            return mv;
        }
        return new ModelAndView("redirect:/ageRange");
    }

    @GetMapping
    @RequestMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        var opt = service.findById(id);
        ModelAndView mv = new ModelAndView();
        if(opt.isPresent()) {
            try {
                service.delete(opt.get());
                mv.setViewName("redirect:/ageRange");
            } catch (Exception e) {
                mv.setViewName("updateAgeRange");
                mv.addObject("error", "Não foi possível excluir a Faixa Etária");
            }
        } else {
            mv.setViewName("updateAgeRange");
            mv.addObject("error", "Faixa Etária não encontrada.");
        }
        return mv;
    }

    @PostMapping
    @RequestMapping("/save")
    public ModelAndView insert(@ModelAttribute("ageRange") AgeRange ageRange) {
        try {
            service.save(ageRange);
            return new ModelAndView("redirect:/ageRange");
        } catch (Exception e) {
            var mv = new ModelAndView("addAgeRange");
            mv.addObject("ageRange", ageRange);
            mv.addObject("error", e.getMessage());
            return mv;
        }
    }
}
