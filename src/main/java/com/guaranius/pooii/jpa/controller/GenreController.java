package com.guaranius.pooii.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guaranius.pooii.jpa.entity.Genre;
import com.guaranius.pooii.jpa.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre insert(@RequestBody Genre genre) {
        return genreService.insert(genre);
    }

    @PutMapping("/{id}")
    public Genre update(@PathVariable Long id, @RequestBody Genre genre) {
        return genreService.update(id, genre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }

    @GetMapping
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    public Genre getById(@PathVariable Long id) {
        return genreService.getById(id);
    }
}
