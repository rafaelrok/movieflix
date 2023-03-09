package com.rafaelvieira.movieflix.controllers;

import com.rafaelvieira.movieflix.dto.ReviewDTO;
import com.rafaelvieira.movieflix.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> save(@Valid @RequestBody ReviewDTO reviewDTO) {
        reviewDTO = reviewService.save(reviewDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reviewDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(reviewDTO);
    }
}

