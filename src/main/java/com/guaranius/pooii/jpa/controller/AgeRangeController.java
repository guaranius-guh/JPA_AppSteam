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

import com.guaranius.pooii.jpa.entity.AgeRange;
import com.guaranius.pooii.jpa.service.AgeRangeService;

@RestController
@RequestMapping("/ageRanges")
public class AgeRangeController {

    @Autowired
    private AgeRangeService ageRangeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgeRange insert(@RequestBody AgeRange ageRange) {
        return ageRangeService.insert(ageRange);
    }

    @PutMapping("/{id}")
    public AgeRange update(@PathVariable Long id, @RequestBody AgeRange ageRange) {
        return ageRangeService.update(id, ageRange);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ageRangeService.delete(id);
    }

    @GetMapping
    public List<AgeRange> getAll() {
        return ageRangeService.getAll();
    }

    @GetMapping("/{id}")
    public AgeRange getById(@PathVariable Long id) {
        return ageRangeService.getById(id);
    }
}
