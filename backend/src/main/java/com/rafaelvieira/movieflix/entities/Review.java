package com.rafaelvieira.movieflix.entities;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
@Entity
@Table(name = "tb_review")
public class Review implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


}