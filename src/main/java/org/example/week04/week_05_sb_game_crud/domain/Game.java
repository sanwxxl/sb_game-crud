package org.example.week04.week_05_sb_game_crud.domain;

public class Game {
    private Long id;
    private String name;
    private String company;
    private int price;
    private String genre;
    private int playTime;

    public Game(Long id, String name, String company, int price, String genre, int playTime) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.genre = genre;
        this.playTime = playTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", playTime=" + playTime +
                '}';
    }
}
