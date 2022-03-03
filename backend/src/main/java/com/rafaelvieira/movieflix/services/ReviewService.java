package com.rafaelvieira.movieflix.services;

import com.rafaelvieira.movieflix.dto.ReviewDTO;
import com.rafaelvieira.movieflix.entities.Movie;
import com.rafaelvieira.movieflix.entities.Review;
import com.rafaelvieira.movieflix.entities.User;
import com.rafaelvieira.movieflix.repositories.MovieRepository;
import com.rafaelvieira.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    public ReviewDTO save(ReviewDTO reviewDTO) {
        Review review = new Review();
        copyDtoToEntity(reviewDTO, review);
        review = reviewRepository.save(review);
        return new ReviewDTO(review);
    }

    private void copyDtoToEntity(ReviewDTO dto, Review entity) {
        Movie movie = movieRepository.findById(dto.getMovieId()).get();
        User user = authService.authenticated();
        authService.validadeMenber(user.getId());

        entity.setMovie(movie);
        entity.setUser(user);
        entity.setText(dto.getText());
    }


}
