package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.Movie;
import com.rafaelvieira.movieflix.entities.Review;
import com.rafaelvieira.movieflix.entities.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rafae
 */

@Setter
@Getter
@AllArgsConstructor
public class MovieDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private Double score;
    private Integer count;
    private String synopsis;
    private Long genreId;

    private List<ReviewDTO> reviews = new ArrayList<>();

    public MovieDTO(Movie entity) {
        id = entity.getId();
        title = entity.getTitle();
        subTitle = entity.getSubTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        score = entity.getScore();
        count = entity.getCount();
        synopsis = entity.getSynopsis();
        genreId = entity.getGenre().getId();
        entity.getReviews().forEach(x -> new ReviewDTO(x));
    }

    public MovieDTO(Movie entity, List<Review> review) {
        this(entity);
        review.forEach(x -> reviews.add(new ReviewDTO(x)));
    }


}
