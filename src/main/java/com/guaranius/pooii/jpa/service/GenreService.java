package com.guaranius.pooii.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guaranius.pooii.jpa.entity.Genre;
import com.guaranius.pooii.jpa.repository.GenreRepository;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre insert(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre update(Long id, Genre genre) {
        Optional<Genre> existingGenre = genreRepository.findById(id);
        if (existingGenre.isPresent()) {
            Genre genreToUpdate = existingGenre.get();
            genreToUpdate.setName(genre.getName());
            return genreRepository.save(genreToUpdate);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public void delete(Long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre getById(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Id " + id + " not found"));
    }
}
