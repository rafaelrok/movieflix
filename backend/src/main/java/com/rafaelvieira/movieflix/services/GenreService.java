package com.rafaelvieira.movieflix.services;

import com.rafaelvieira.movieflix.dto.GenreDTO;
import com.rafaelvieira.movieflix.entities.Genre;

import com.rafaelvieira.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Transactional(readOnly = true)
    public List<GenreDTO> findAll(){
        List<Genre> list = repository.findAll();
        return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());


    }

    @Transactional(readOnly = true)
    public GenreDTO findById(Long id) {
        Optional<Genre> obj = repository.findById(id);
        Genre entity = obj.orElseThrow(() -> new EntityNotFoundException("Genre not found"));
        return new GenreDTO(entity, entity.getMovies());
    }
}
