package com.guaranius.pooii.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guaranius.pooii.jpa.entity.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

}
