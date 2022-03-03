package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.Genre;
import com.rafaelvieira.movieflix.entities.Movie;
import com.rafaelvieira.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MovieDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;
    private Long genreId;

    private List<ReviewDTO> reviews = new ArrayList<>();

    public MovieDTO() {

    }

    public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis, Long genreId) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.year = year;
        this.imgUrl = imgUrl;
        this.synopsis = synopsis;
        this.genreId = genreId;
    }

    public MovieDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        subTitle = entity.getSubTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        synopsis = entity.getSynopsis();
        genreId = entity.getGenre().getId();
        entity.getReviews().forEach(x -> new ReviewDTO(x));
    }

    public MovieDTO(Movie entity, List<Review> list) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }
}
