package com.rafaelvieira.movieflix.dto;
import com.rafaelvieira.movieflix.entities.Review;
import com.rafaelvieira.movieflix.entities.Score;
import com.rafaelvieira.movieflix.entities.ScorePK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;


/**
 * @author rafae
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message ="Campo requerido")
    private String text;

    private Long movieId;

    private UserDTO user;

    private Double score;


    public ReviewDTO(Review entity) {
        id = entity.getId();
        text = entity.getText();
        user = new UserDTO(entity.getUser());
        movieId = entity.getMovie().getId();
        score = entity.getMovie().getScore();
    }

}