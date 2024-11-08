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

import com.guaranius.pooii.jpa.entity.Developer;
import com.guaranius.pooii.jpa.service.DeveloperService;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Developer insert(@RequestBody Developer developer) {
        return developerService.insert(developer);
    }

    @PutMapping("/{id}")
    public Developer update(@PathVariable Long id, @RequestBody Developer developer) {
        return developerService.update(id, developer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        developerService.delete(id);
    }

    @GetMapping
    public List<Developer> getAll() {
        return developerService.getAll();
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return developerService.getById(id);
    }
}
