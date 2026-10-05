package org.example.week04.week_05_sb_game_crud.service;

import org.example.week04.week_05_sb_game_crud.domain.Game;
import org.example.week04.week_05_sb_game_crud.dto.GameRequest;
import org.example.week04.week_05_sb_game_crud.dto.GameResponse;
import org.example.week04.week_05_sb_game_crud.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameResponse create(GameRequest request) {
        Game game = new Game(null, request.name(), request.company(), request.price(), request.genre(), request.playTime());
        Game savedGame = gameRepository.save(game);
        return toResponse(savedGame);
    }

    public List<GameResponse> findAll() {
        List<GameResponse> result = new ArrayList<>();
        for (Game game : gameRepository.findAll()) {
            result.add(toResponse(game));
        }
        return result;
    }

    public GameResponse findById(Long id) {
        Game game = gameRepository.findById(id);
        if (game == null) {
            return null;
        }
        return toResponse(game);
    }

    public GameResponse update(Long id, GameRequest request) {
        Game game = gameRepository.findById(id);
        if (game == null) {
            return null;
        }
        game.setName(request.name());
        game.setCompany(request.company());
        game.setPrice(request.price());
        game.setGenre(request.genre());
        game.setPlayTime(request.playTime());
        Game updatedGame = gameRepository.update(game);
        return toResponse(updatedGame);
    }

    public boolean delete(Long id) {
        Game game = gameRepository.findById(id);
        if (game == null) {
            return false;
        }
        gameRepository.deleteById(id);
        return true;
    }

    public List<GameResponse> findByGenre(String genre) {
        List<GameResponse> result = new ArrayList<>();
        for (Game game : gameRepository.findAll()) {
            if (game.getGenre().equals(genre)) {
                result.add(toResponse(game));
            }
        }
        return result;
    }

    public boolean isValid(GameRequest request) {
        if (request.name() == null || request.name().isBlank()) {
            return false;
        }
        if (request.company() == null || request.company().isBlank()) {
            return false;
        }
        if (request.genre() == null || request.genre().isBlank()) {
            return false;
        }
        if (request.price() < 0) {
            return false;
        }
        if (request.playTime() < 0) {
            return false;
        }
        return true;
    }

    private GameResponse toResponse(Game game) {
        return new GameResponse(game.getId(), game.getName(), game.getCompany(), game.getPrice(), game.getGenre(), game.getPlayTime());
    }
}
