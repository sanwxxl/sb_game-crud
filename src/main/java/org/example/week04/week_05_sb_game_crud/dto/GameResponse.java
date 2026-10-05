package org.example.week04.week_05_sb_game_crud.dto;

public record GameResponse(Long id, String name, String company, int price, String genre, int playTime) {
}
