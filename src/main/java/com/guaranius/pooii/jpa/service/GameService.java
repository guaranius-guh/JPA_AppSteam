package com.guaranius.pooii.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.guaranius.pooii.jpa.entity.Game;
import com.guaranius.pooii.jpa.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game insert(Game game) {
        return gameRepository.save(game);
    }

    public Game update(Long id, Game game) {
        Optional<Game> existingGame = gameRepository.findById(id);
        if (existingGame.isPresent()) {
            Game gameToUpdate = existingGame.get();
            gameToUpdate.setName(game.getName());
            gameToUpdate.setDeveloper(game.getDeveloper());
            gameToUpdate.setGenre(game.getGenre());
            gameToUpdate.setAgeRange(game.getAgeRange());
            return gameRepository.save(gameToUpdate);
        } else {
            throw new RuntimeException("Id " + id + " not found");
        }
    }

    public void delete(Game game) {
        gameRepository.delete(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll(Sort.by("name"));
    }

    public Optional<Game> getById(long id){
        return gameRepository.findById(id);
    }

    public List<Game> getGamesByGenre(Long genreId) {
        return gameRepository.findByGenreId(genreId);
    }

    public List<Game> getGamesByDeveloper(Long developerId) {
        return gameRepository.findByDeveloperId(developerId);
    }

    public List<Game> getGamesByAgeRange(Long ageRangeId) {
        return gameRepository.findByAgeRangeId(ageRangeId);
    }
}
