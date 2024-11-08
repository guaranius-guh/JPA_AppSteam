package com.guaranius.pooii.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guaranius.pooii.jpa.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
    List<Game> findByGenreId(Long genreId);

    List<Game> findByDeveloperId(Long developerId);

    List<Game> findByAgeRangeId(Long ageRangeId);
}
