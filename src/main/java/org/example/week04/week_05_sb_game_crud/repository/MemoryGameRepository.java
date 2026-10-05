package org.example.week04.week_05_sb_game_crud.repository;

import org.example.week04.week_05_sb_game_crud.domain.Game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MemoryGameRepository implements GameRepository{
    @Override
    public Game save(Game game) {
        return null;
    }

    @Override
    public List<Game> findAll() {
        return List.of();
    }

    @Override
    public Game findById(Long id) {
        return null;
    }

    @Override
    public Game update(Game game) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
