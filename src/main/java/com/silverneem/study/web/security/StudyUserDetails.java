package com.silverneem.study.web.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class StudyUserDetails implements UserDetails {

	private static final long serialVersionUID = -9121274038630191739L;
	
	private String username;
	private String password;
	private Long userId;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonLocked;
	private Boolean enabled;
	private List<SimpleGrantedAuthority> authorities;
	
	public StudyUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public StudyUserDetails(String username, String password,
			Boolean accountNonExpired, Boolean accountNonLocked,
			Boolean credentialsNonLocked, Boolean enabled,
			List<SimpleGrantedAuthority> authorities,
			Long userId) {
		this.username = username;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonLocked = credentialsNonLocked;
		this.enabled = enabled;
		this.authorities = authorities;
		this.userId = userId;
	}
	
	@Override
	public Collection< ? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonLocked;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
