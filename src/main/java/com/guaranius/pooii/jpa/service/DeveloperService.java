package com.guaranius.pooii.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranius.pooii.jpa.entity.Developer;
import com.guaranius.pooii.jpa.repository.DeveloperRepository;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    public Developer insert(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer update(Long id, Developer developer) {
        Optional<Developer> existingDeveloper = developerRepository.findById(id);
        if (existingDeveloper.isPresent()) {
            Developer developerToUpdate = existingDeveloper.get();
            developerToUpdate.setName(developer.getName());
            return developerRepository.save(developerToUpdate);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public void delete(Long id) {
        if (developerRepository.existsById(id)) {
            developerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public List<Developer> getAll() {
        return developerRepository.findAll();
    }

    public Developer getById(Long id) {
        return developerRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " not found"));
    }
}
