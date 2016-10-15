package com.silverneem.study.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.silverneem.study.web.security.StudyUserDetails;
@Component
public class SessionUserService {

	public Map<String, Object> getCurrentUser() {
		Map<String, Object> currentUser = new HashMap<String, Object>();
		
		StudyUserDetails recruitUserDetails = (StudyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<String> roles = new ArrayList<String>();
		Iterator<? extends GrantedAuthority> iterAuthorities = recruitUserDetails.getAuthorities().iterator();
		while (iterAuthorities.hasNext()) {
			GrantedAuthority grantedAuthority = (GrantedAuthority) iterAuthorities.next();
			roles.add(getRole(grantedAuthority));
		}
		
		currentUser.put("username", recruitUserDetails.getUsername());
		currentUser.put("roles", roles);
		
		return currentUser;
	}
	
	private String getRole(GrantedAuthority authority) {
		if (authority.getAuthority().equals("ROLE_ADMIN")) {
			return "Admin";
		}
		return null;
	}
	
}
