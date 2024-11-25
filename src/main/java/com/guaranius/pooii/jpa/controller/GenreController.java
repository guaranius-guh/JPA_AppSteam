package com.guaranius.pooii.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guaranius.pooii.jpa.entity.Genre;
import com.guaranius.pooii.jpa.service.GenreService;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping
    public ModelAndView genres() {
        var mv = new ModelAndView("home");
        mv.addObject("list", service.findAll());
        return mv;
    }

    @GetMapping
    @RequestMapping("/add")
    public ModelAndView add() {
        var mv = new ModelAndView("addGenre");
        mv.addObject("genre", new Genre());
        return mv;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ModelAndView update(@PathVariable long id) {
        var mv = new ModelAndView("updateGenre");
        var opt = service.findById(id);
        if(opt.isPresent()) {
            mv.addObject("genre", opt.get());
            return mv;
        }
        return new ModelAndView("redirect:/game");
    }

    @GetMapping
    @RequestMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        var opt = service.findById(id);
        if(opt.isPresent()) {
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/game");
    }

    @PostMapping
    @RequestMapping("/save")
    public ModelAndView insert(@ModelAttribute("genre") Genre genre) {
        try {
            service.save(genre);
            return new ModelAndView("redirect:/game");
        } catch (Exception e) {
            var mv = new ModelAndView("addGenre");
            mv.addObject("genre", genre);
            mv.addObject("error", e.getMessage());
            return mv;
        }
    }
}
