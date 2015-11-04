package com.silverneem.study.web.security;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class StudyAuthenticationProvider extends DaoAuthenticationProvider {

	private static final Pattern proxyUserPattern = Pattern.compile("^su (.*?)\\:(.*?)$");
	
	public StudyAuthenticationProvider() {
		super();
	}
	
	@SuppressWarnings("deprecation")
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		Object salt = null;
		
		if (this.getSaltSource() != null) {
			salt = this.getSaltSource().getSalt(userDetails);
		}
		
		if (authentication.getCredentials() == null) {
			logger.debug("Authentication failed: no credentials provided");
			
			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}
		
		String presentedPassword = authentication.getCredentials().toString();
		
		// Check for proxy users.
		UserDetails proxyUserDetails = retrieveProxyUser(userDetails, authentication);
		presentedPassword = retrieveProxyUserPassword(authentication);
		
		if (!this.getPasswordEncoder().isPasswordValid(proxyUserDetails.getPassword(),
				presentedPassword, salt)) {
			logger.debug("Authentication failed: password does not match stored value");
			
			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}
		
		if (!userDetails.getUsername().equals(proxyUserDetails.getUsername()) &&
				!isAdmin(proxyUserDetails)) {
			logger.debug("Authentication failed: proxy user is not an admin.");
			
			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials",
					"Bad credentials"));
		}
	}
	
	private Boolean isAdmin(UserDetails userDetails) {
		Boolean adminUser = Boolean.FALSE;
		Iterator<? extends GrantedAuthority> iterAuthorities = userDetails.getAuthorities().iterator();
		while (iterAuthorities.hasNext()) {
			GrantedAuthority grantedAuthority = (GrantedAuthority) iterAuthorities.next();
			if (grantedAuthority.getAuthority().equals("Admin")) {
				adminUser = Boolean.TRUE;
			}
		}
		return adminUser;
	}
	
	private String retrieveProxyUserPassword(UsernamePasswordAuthenticationToken authentication) {
		String presentedPassword = authentication.getCredentials().toString();
		
		Matcher matcher = proxyUserPattern.matcher(presentedPassword);
		if (matcher.matches()) {
			presentedPassword = matcher.group(2);
		}
		
		return presentedPassword;
	}
	
	private UserDetails retrieveProxyUser(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		String presentedPassword = authentication.getCredentials().toString();
		
		UserDetails proxyUserDetails = userDetails;
		
		// Match pattern to find proxy user.
		Matcher matcher = proxyUserPattern.matcher(presentedPassword);
		if (matcher.matches()) {
			String username = matcher.group(1);
			String password = matcher.group(2);
			UsernamePasswordAuthenticationToken proxyAuthentication = new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities());
			proxyUserDetails = this.retrieveUser(username, proxyAuthentication);
		}
		
		return proxyUserDetails;
	}
	
}
