package org.example.week04.week_05_sb_game_crud.repository;

import org.example.week04.week_05_sb_game_crud.domain.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryGameRepository implements GameRepository{

    private Map<Long, Game> store = new LinkedHashMap<>();
    private long sequence = 0L;

    @Override
    public Game save(Game game) {
        sequence = sequence + 1;
        game.setId(sequence);
        store.put(game.getId(), game);
        return game;
    }

    @Override
    public List<Game> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Game findById(Long id) {
        return store.get(id);
    }

    @Override
    public Game update(Game game) {
        store.put(game.getId(), game);
        return game;
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
