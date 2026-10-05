package org.example.week04.week_05_sb_game_crud.controller;

import org.example.week04.week_05_sb_game_crud.dto.GameRequest;
import org.example.week04.week_05_sb_game_crud.dto.GameResponse;
import org.example.week04.week_05_sb_game_crud.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameResponse> create(@RequestBody GameRequest request) {
        if (!gameService.isValid(request)) {
            return ResponseEntity.badRequest().build();
        }
        GameResponse response = gameService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<GameResponse> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> findById(@PathVariable Long id) {
        GameResponse response = gameService.findById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameResponse> update(@PathVariable Long id, @RequestBody GameRequest request) {
        if (!gameService.isValid(request)) {
            return ResponseEntity.badRequest().build();
        }
        GameResponse response = gameService.update(id, request);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = gameService.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<GameResponse> findByGenre(@RequestParam String genre) {
        return gameService.findByGenre(genre);
    }
}
