package com.guaranius.pooii.jpa.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.guaranius.pooii.jpa.entity.Genre;
import com.guaranius.pooii.jpa.repository.GenreRepository;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public Optional<Genre> findById(long id) {
        return repository.findById(id);
    }

    public List<Genre> findAll() {
        return repository.findAll(Sort.by("name"));
    }

    public void save(Genre genre) {
        if(Strings.isBlank(genre.getName())) {
            throw new RuntimeException("Nome não informado.");
        }
        repository.save(genre);
    }

    public void delete(Genre genre) {
        repository.delete(genre);
    }
}
