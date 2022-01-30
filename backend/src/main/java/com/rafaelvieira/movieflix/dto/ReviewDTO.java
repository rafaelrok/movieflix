package com.rafaelvieira.movieflix.dto;
import com.rafaelvieira.movieflix.entities.Review;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;


public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message ="Campo requerido")
    private String text;
    private Long movieId;
    private UserDTO user;

    public ReviewDTO() {

    }

    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        user = new UserDTO(entity.getUser());
        movieId = entity.getMovie().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}