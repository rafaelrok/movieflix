package com.rafaelvieira.movieflix.repositories;

import com.rafaelvieira.movieflix.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
