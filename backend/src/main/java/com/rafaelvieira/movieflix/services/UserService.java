package com.rafaelvieira.movieflix.services;

import com.rafaelvieira.movieflix.dto.RoleDTO;
import com.rafaelvieira.movieflix.dto.UserDTO;
import com.rafaelvieira.movieflix.dto.UserInsertDTO;
import com.rafaelvieira.movieflix.dto.UserUpdateDTO;
import com.rafaelvieira.movieflix.entities.Role;
import com.rafaelvieira.movieflix.entities.User;
import com.rafaelvieira.movieflix.repositories.RoleRepository;
import com.rafaelvieira.movieflix.repositories.UserRepository;
import com.rafaelvieira.movieflix.services.exceptions.DatabaseException;
import com.rafaelvieira.movieflix.services.exceptions.ResourceNotFoundException;
import com.rafaelvieira.movieflix.services.exceptions.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;



@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthService authService;


	@Transactional(readOnly = true)
	public UserDTO getAuthUser() {
		User user = authService.authenticated();

		return new UserDTO(user);
	}
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> list = repository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repository.findByEmail(username);
		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + username);
		return user;
	}

}
