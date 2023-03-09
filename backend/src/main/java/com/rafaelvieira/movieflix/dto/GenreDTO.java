package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.Genre;
import com.rafaelvieira.movieflix.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author rafae
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    private List<MovieDTO> movies = new ArrayList<>();

    public GenreDTO(Genre entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public GenreDTO(Genre entity, Set<Movie> movies) {
        this(entity);
        movies.forEach(x -> this.movies.add(new MovieDTO(x)));

    }

}