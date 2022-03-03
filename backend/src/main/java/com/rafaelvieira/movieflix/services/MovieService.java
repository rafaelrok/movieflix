package com.rafaelvieira.movieflix.services;

import com.rafaelvieira.movieflix.dto.MovieDTO;
import com.rafaelvieira.movieflix.entities.Genre;
import com.rafaelvieira.movieflix.entities.Movie;
import com.rafaelvieira.movieflix.repositories.GenreRepository;
import com.rafaelvieira.movieflix.repositories.MovieRepository;
import com.rafaelvieira.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;


    @Transactional(readOnly = true)
    public Page<MovieDTO> findAllPaged(Long genreId, String title, PageRequest pageRequest) {
        Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
        Page<Movie> page = movieRepository.find(genre, title, pageRequest);
        return page.map(x -> new MovieDTO(x));

    }


    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        Movie obj = movie.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
        return new MovieDTO(obj, obj.getReviews());
    }
}
