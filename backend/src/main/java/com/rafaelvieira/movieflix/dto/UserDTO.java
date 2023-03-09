package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


/**
 * @author rafae
 */

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;

	@Email(message = "Favor entrar um email válido")
	private String email;
	
	//Set<RoleDTO> roles = new HashSet<>();

	//private List<ReviewDTO> reviews = new ArrayList<>();
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		//entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	/*
	public UserDTO(User entity, List<Review> list) {
		this(entity);
		list.forEach(x -> this.reviews.add(new ReviewDTO(x)));

	}
	 */

	/*
	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;

	}
	 */
}
