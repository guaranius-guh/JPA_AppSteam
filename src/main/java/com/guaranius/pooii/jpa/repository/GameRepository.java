package com.guaranius.pooii.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guaranius.pooii.jpa.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
