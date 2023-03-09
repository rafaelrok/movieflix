package com.rafaelvieira.movieflix.dto;


import com.rafaelvieira.movieflix.services.validations.UserInsertValid;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rafae
 */

@Getter
@Setter
@UserInsertValid
public class UserInsertDTO extends UserDTO {
	private static final long serialVersionUID = 1L;

	private String password;

	UserInsertDTO() {
		super();
	}

}
