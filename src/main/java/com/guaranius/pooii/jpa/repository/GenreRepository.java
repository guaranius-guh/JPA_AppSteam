package com.guaranius.pooii.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guaranius.pooii.jpa.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
