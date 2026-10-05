package org.example.week04.week_05_sb_game_crud.repository;

import org.example.week04.week_05_sb_game_crud.domain.Game;

import java.util.List;

public interface GameRepository{
    Game save(Game game);

    List<Game> findAll();

    Game findById(Long id);

    Game update(Game game);

    void deleteById(Long id);
}
