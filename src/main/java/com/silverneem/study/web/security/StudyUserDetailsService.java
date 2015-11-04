package com.silverneem.study.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class StudyUserDetailsService implements UserDetailsService {
		
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		String loggedUser = "";
		String loggedUserPassword = "";
		Long userId = null;
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		if(email.equals("user")) {
			loggedUser = "user";
			loggedUserPassword = new BCryptPasswordEncoder().encode("user");
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			userId = null;			
		}
		if(email.equals("admin")) {
			loggedUser = "admin";
			loggedUserPassword = new BCryptPasswordEncoder().encode("admin");
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			userId = null;			
		}
		if(email.equals("support")) {
			loggedUser = "support";
			loggedUserPassword = new BCryptPasswordEncoder().encode("ctrlthreads");
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			userId = null;			
		}
		if (!email.equals("support") && !email.equals("admin") && !email.equals("user")) {
			throw new UsernameNotFoundException(email + "NOT FOUND");
		}
		
		UserDetails userDetails = new StudyUserDetails(loggedUser,
				loggedUserPassword, Boolean.TRUE, Boolean.TRUE,
				Boolean.TRUE,
				Boolean.TRUE, authorities, userId);
		
		return userDetails;
	}

}
