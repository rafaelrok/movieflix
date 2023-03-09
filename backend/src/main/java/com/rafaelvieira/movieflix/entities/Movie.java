package com.rafaelvieira.movieflix.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rafae
 */

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String subTitle;

	private Integer year;

	private String imgUrl;

	private Double score;

	private Integer count;

	@Column(columnDefinition = "TEXT")
	private String synopsis;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;

	@ManyToMany(mappedBy = "movie", fetch = FetchType.EAGER)
	private List<Review> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "id.movie", fetch = FetchType.LAZY)
	private Set<Score> scores = new HashSet<>();

}