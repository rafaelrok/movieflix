package com.rafaelvieira.movieflix.controllers;

import com.rafaelvieira.movieflix.dto.GenreDTO;
import com.rafaelvieira.movieflix.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping
    public ResponseEntity<List<GenreDTO>> findAll(){
        List<GenreDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GenreDTO> findById(@PathVariable Long id){
        GenreDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }
}

