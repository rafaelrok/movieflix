package com.rafaelvieira.movieflix.entities;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author rafae
 */

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@RequiredArgsConstructor
@Entity
@Table(name = "tb_genre")
public class Genre implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies = new HashSet<>();

}