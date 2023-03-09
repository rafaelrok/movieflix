package com.rafaelvieira.movieflix.controllers;

import com.rafaelvieira.movieflix.dto.MovieDTO;
import com.rafaelvieira.movieflix.dto.ScoreDTO;
import com.rafaelvieira.movieflix.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rafae
 */

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

//    @Autowired
//    private ScoreService scoreService;
//
//    @PutMapping
//    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
//        return scoreService.saveScore(dto);
//    }
}
