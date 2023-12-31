package model;

import Enums.Genre;
import Enums.Language;

public class Movie {
    private String name;
    private float ratings;
    private Language language;
    private Genre genre;

    public Movie(String name, Language language, Genre genre) {
        this.name = name;
        this.language = language;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
