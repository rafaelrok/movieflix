package com.rafaelvieira.movieflix.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafae
 */

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String authority;

}
