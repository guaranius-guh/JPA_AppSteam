package com.guaranius.pooii.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.guaranius.pooii.jpa.entity.Game;
import com.guaranius.pooii.jpa.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping
    @RequestMapping("/save")
    public ModelAndView insert(@ModelAttribute("game") Game game) {
        try {
            service.insert(game);
            return new ModelAndView("redirect:/game");
        } catch (Exception e) {
            var mv = new ModelAndView("addGame");
            mv.addObject("game", game);
            mv.addObject("error", e.getMessage());
            return mv;
        }
    }

    @GetMapping
    public ModelAndView home() {
        var mv = new ModelAndView("home");
        mv.addObject("list", service.getAllGames());
        return mv;
    }

    @GetMapping
    @RequestMapping("/addGame")
    public ModelAndView addGame() {
        var mv = new ModelAndView("addGame");
        mv.addObject("game", new Game());
        return mv;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ModelAndView update(@PathVariable long id) {
        var mv = new ModelAndView("addGame");
        var opt = service.getById(id);
        if(opt.isPresent()) {
            mv.addObject("game", opt.get());
            return mv;
        }
        return new ModelAndView("redirect:/game");
    }

    @GetMapping
    @RequestMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable long id){
        var mv = new ModelAndView("addGame");
        var opt = service.getById(id);
        if(opt.isPresent()) {
            service.delete(opt.get());
        }
        return new ModelAndView("redirect:/continente");
    }
}
