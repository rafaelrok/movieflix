package com.rafaelvieira.movieflix.repositories;

import com.rafaelvieira.movieflix.entities.Genre;
import com.rafaelvieira.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /*
    @Query("SELECT DISTINCT obj FROM Movie obj INNER JOIN obj.genre cats WHERE "
            + "(COALESCE(:genre) IS NULL OR cats IN :genre) AND "
            + "(LOWER(obj.title) LIKE LOWER(CONCAT('%',:title,'%'))) ")
    Page<Movie> find(List<Genre> genre, String title, Pageable pageable);
     */

    @Query("SELECT DISTINCT obj FROM Movie obj WHERE "
            + "(:genre IS NULL OR :genre = obj.genre) AND "
            + "(LOWER(obj.title) LIKE LOWER(CONCAT('%',:title,'%')))")
    Page<Movie> find(Genre genre, String title, Pageable pageable);

    @Query("SELECT obj FROM Movie obj JOIN FETCH obj.genre WHERE obj IN :movies")
    List<Movie> findMoviesWithGenre(List <Movie> movies);
}
