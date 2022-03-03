package com.rafaelvieira.movieflix.repositories;

import com.rafaelvieira.movieflix.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
