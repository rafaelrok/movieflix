package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author rafae
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO {
    private Long movieId;

    private String email;

    private Double score;


    public ScoreDTO(Score entity) {
        movieId = entity.getId().getMovie().getId();
        email = entity.getId().getUser().getEmail();
        score = entity.getValue();
    }

}
