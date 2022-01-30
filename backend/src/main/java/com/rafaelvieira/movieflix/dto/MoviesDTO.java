package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.Movie;
import com.rafaelvieira.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MoviesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo requerido")
    private String title;

    @NotBlank(message = "Campo requerido")
    private String subTitle;

    @NotBlank(message = "Campo requerido")
    private String synopsis;
    private int year;
    private String imgUri;

    private List<ReviewDTO> reviews = new ArrayList<>();

    public MoviesDTO(){}

    public MoviesDTO(Long id, String title, String subTitle, String synopsis, int year, String imgUri) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.synopsis = synopsis;
        this.year = year;
        this.imgUri = imgUri;
    }

    public MoviesDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        subTitle = entity.getSubTitle();
        synopsis = entity.getSynopsis();
        year = entity.getYear();
        imgUri = entity.getImgUri();
    }

    public MoviesDTO(Movie entity, List<Review> list) {
        this(entity);
        list.forEach(x -> reviews.add(new ReviewDTO(x)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }


}
