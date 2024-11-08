package com.guaranius.pooii.jpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.guaranius.pooii.jpa.entity.Game;
import com.guaranius.pooii.jpa.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable Long genreId) {
        return ResponseEntity.ok(gameService.getGamesByGenre(genreId));
    }

    @GetMapping("/developer/{developerId}")
    public ResponseEntity<List<Game>> getGamesByDeveloper(@PathVariable Long developerId) {
        return ResponseEntity.ok(gameService.getGamesByDeveloper(developerId));
    }

    @GetMapping("/agerange/{ageRangeId}")
    public ResponseEntity<List<Game>> getGamesByAgeRange(@PathVariable Long ageRangeId) {
        return ResponseEntity.ok(gameService.getGamesByAgeRange(ageRangeId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game insert(@RequestBody Game game) {
        return gameService.insert(game);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
        try {
            Game updatedGame = gameService.update(id, game);
            return ResponseEntity.ok(updatedGame);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            gameService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
