package com.rafaelvieira.movieflix.services;

import com.rafaelvieira.movieflix.entities.User;
import com.rafaelvieira.movieflix.repositories.UserRepository;
import com.rafaelvieira.movieflix.services.exceptions.ResourceNotFoundException;
import com.rafaelvieira.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            return userRepository.findByEmail(username);
        }
        catch (Exception e) {
            throw new UnauthorizedException("Invalid user");
        }
    }

    public void validadeMenber(Long userId){
        User user = authenticated();
        if(!user.hasRole("ROLE_MEMBER")){
            throw new ResourceNotFoundException("Invalid user");
        }
    }
}
