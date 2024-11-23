package com.guaranius.pooii.jpa.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.guaranius.pooii.jpa.entity.AgeRange;
import com.guaranius.pooii.jpa.repository.AgeRangeRepository;

@Service
public class AgeRangeService {

    @Autowired
    private AgeRangeRepository repository;

    public Optional<AgeRange> findById(long id) {
        return repository.findById(id);
    }

    public List<AgeRange> findAll() {
        return repository.findAll(Sort.by("name"));
    }

    public void save(AgeRange ageRange) {
        if(Strings.isBlank(ageRange.getAgeRange())) {
            throw new RuntimeException("Nada informado.");
        }
        repository.save(ageRange);
    }

    public void delete(AgeRange ageRange) {
        repository.delete(ageRange);
    }
}