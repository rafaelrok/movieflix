package com.rafaelvieira.movieflix.dto;


import com.rafaelvieira.movieflix.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author rafae
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String authority;

	public RoleDTO(Role role) {
		super();
		id = role.getId();
		authority = role.getAuthority();
	}

}
