package com.rafaelvieira.movieflix.controllers;

import com.rafaelvieira.movieflix.dto.MovieDTO;
import com.rafaelvieira.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAllPaged(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "4") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "title") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        Page<MovieDTO> movies = movieService.findAllPaged(genreId, title.trim(), pageRequest);
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        MovieDTO movie = movieService.findById(id);
        return ResponseEntity.ok().body(movie);
    }

}
