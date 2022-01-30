package com.rafaelvieira.movieflix.dto;

import com.rafaelvieira.movieflix.entities.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;

	@Email(message = "Favor entrar um email válido")
	private String email;
	
	//Set<RoleDTO> roles = new HashSet<>();

	//private List<ReviewDTO> reviews = new ArrayList<>();

	
	public UserDTO() {}

	public UserDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;

	}
	 */
}
