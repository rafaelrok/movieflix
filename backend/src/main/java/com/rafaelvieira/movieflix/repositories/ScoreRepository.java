package com.rafaelvieira.movieflix.repositories;

import com.rafaelvieira.movieflix.entities.Score;
import com.rafaelvieira.movieflix.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
