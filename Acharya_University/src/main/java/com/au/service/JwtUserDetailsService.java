package com.au.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.au.model.UserAuthentication;
import com.au.repository.AuthenticationRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthenticationRepository authentication;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserAuthentication user = authentication.findByUsername(username);

		if (user != null) {
			return new User(user.getUsername(), user.getPassword(), new ArrayList());

		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}

/*
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { if ("java".equals(username)) { return new
 * User("java", "$2a$10$T0zYmW3AWqOoIafNHSnPW.7mOmfxcLdkaKj90tXEB5CMADDNGDY3a",
 * new ArrayList<>()); } else { throw new
 * UsernameNotFoundException("User not found with username: " + username); } }
 */
