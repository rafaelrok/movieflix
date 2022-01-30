package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.Genre;
import com.rafaelvieira.movieflix.entities.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GenreDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    List<MoviesDTO> movies = new ArrayList<>();

    public GenreDTO(){}

    public GenreDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreDTO(Genre genre) {
        id = genre.getId();
        name = genre.getName();
    }

    public GenreDTO(Genre entity, Set<Movie> movies) {
        this(entity);
        movies.forEach(x -> this.movies.add(new MoviesDTO(x)));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MoviesDTO> getMovies() {
        return movies;
    }

}
