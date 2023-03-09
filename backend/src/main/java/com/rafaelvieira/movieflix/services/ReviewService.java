package com.rafaelvieira.movieflix.services;

import com.rafaelvieira.movieflix.dto.ReviewDTO;
import com.rafaelvieira.movieflix.dto.ScoreDTO;
import com.rafaelvieira.movieflix.entities.Movie;
import com.rafaelvieira.movieflix.entities.Review;
import com.rafaelvieira.movieflix.entities.Score;
import com.rafaelvieira.movieflix.entities.User;
import com.rafaelvieira.movieflix.repositories.MovieRepository;
import com.rafaelvieira.movieflix.repositories.ReviewRepository;
import com.rafaelvieira.movieflix.repositories.ScoreRepository;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rafae
 */

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ScoreService scoreService;


    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewDTO save(ReviewDTO reviewDTO) {
        Review review = new Review();
        ScoreDTO scoreDTO = new ScoreDTO();
        copyDtoToEntity(reviewDTO, review, scoreDTO);
        review = reviewRepository.save(review);
        return new ReviewDTO(review);
    }

    private void copyDtoToEntity(ReviewDTO dto, Review entity, ScoreDTO scoreDTO) {
        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        User user = authService.authenticated();
        authService.validadeMenber(user.getId());
        scoreService.saveScore(scoreDTO, dto, movie);

        entity.setMovie(movie);
        entity.setUser(user);
        entity.setText(dto.getText());
    }

}
