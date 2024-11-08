package com.guaranius.pooii.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranius.pooii.jpa.entity.AgeRange;
import com.guaranius.pooii.jpa.repository.AgeRangeRepository;

@Service
public class AgeRangeService {

    @Autowired
    private AgeRangeRepository ageRangeRepository;

    public AgeRange insert(AgeRange ageRange) {
        return ageRangeRepository.save(ageRange);
    }

    public AgeRange update(Long id, AgeRange ageRange) {
        Optional<AgeRange> existingAgeRange = ageRangeRepository.findById(id);
        if (existingAgeRange.isPresent()) {
            AgeRange ageRangeToUpdate = existingAgeRange.get();
            ageRangeToUpdate.setAgeRange(ageRange.getAgeRange());
            return ageRangeRepository.save(ageRangeToUpdate);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public void delete(Long id) {
        if (ageRangeRepository.existsById(id)) {
            ageRangeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public List<AgeRange> getAll() {
        return ageRangeRepository.findAll();
    }

    public AgeRange getById(Long id) {
        return ageRangeRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " not found"));
    }
}
